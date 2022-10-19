/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
    private int idQuestion ; 
    private String ennonce ; 
    private  List<String> options ; 
    private String OptionCorrecte ; 
 */
package services;

 import entities.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

public class QuestionService implements IService<Question> {
            public QuestionService() {
    cnx = MyDB.getInstance().getCnx();
    }
    
    Connection cnx ; 

    
    


  

    @Override
    public void ajouter(Question q) {
                try {
            String req = "insert into Question(ennonce,quizId) values(?,?) ; "  ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1,q.getEnnonce());
            st.setLong(2,q.getIdQuizz());
            st.execute();
            System.out.println("Question Ajoutée ! ");
        } catch (SQLException ex) {
            System.out.println("Erreur ! Question non ajoutée ! " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(Question q) {
                try {
            String req = "DELETE FROM Question WHERE idQuestion=? ;"  ;
            PreparedStatement st = cnx.prepareStatement(req); 
            st.setLong(1, q.getIdQuestion());
            st.executeUpdate();
            System.out.println("Question  supprimée ");

        } catch (SQLException ex) {
            System.out.println(" Erreur ! Question non supprimée ");

         }
    }

    @Override
    public void modifier(Question q) {
                    try {
                String req ="update Question set ennonce=? where idQuestion=?" ;
                PreparedStatement st = cnx.prepareStatement(req); 
                st.setString(1, q.getEnnonce());
                st.setDouble(2,q.getIdQuestion());
                st.executeUpdate();
                System.out.println("Question  modifiée ! ");

            } catch (SQLException ex) {
                System.out.println(" Erreur ! Question non   modifiée ! ");
            }
    }

    @Override
    public ObservableList<Question> afficher() {
                   ObservableList<Question> listQuestion = FXCollections.observableArrayList() ;

            try {
                String req = "select * from Question" ;
                PreparedStatement st = cnx.prepareCall(req) ; 
                ResultSet rs = st.executeQuery(req) ;
                
                while(rs.next()) {
                listQuestion.add(new Question(rs.getLong("idQuestion"),rs.getString("ennonce"),rs.getLong("quizId"))) ;

            }
                
                
            } catch (SQLException ex) {
                System.out.println("erreur lors de la selection des questions ! ");
                
            }
              return listQuestion ;
    }
    
}
