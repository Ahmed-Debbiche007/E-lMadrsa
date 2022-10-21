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
            String req = "INSERT INTO question ( ennonce,option1, option2, option3,answer,idExamen) VALUES (?, ?, ?, ?, ?, ?);"  ;
            
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1,q.getEnnonce());
            st.setString(2,q.getOption1());
            st.setString(3,q.getOption2());
            st.setString(4,q.getOption3());
            st.setString(5,q.getAnswer());
            st.setLong(6,q.getIdExamen()) ;
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
                String req ="update Question set ennonce=?,option1=?, option2=?,option3=?,answer=?,idExamen=? where idQuestion=?" ;
                PreparedStatement st = cnx.prepareStatement(req); 
                st.setString(1,q.getEnnonce());
                st.setString(2,q.getOption1());
                st.setString(3,q.getOption2());
                st.setString(4,q.getOption3());
                st.setString(5,q.getAnswer());
                st.setLong(6,q.getIdExamen()) ;
                st.setLong(7,q.getIdQuestion()) ;
                st.executeUpdate();
                System.out.println("Question  modifiée ! ");

            } catch (SQLException ex) {
                System.out.println(" Erreur ! Question non   modifiée ! " + ex.getMessage());
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
                listQuestion.add(new Question(rs.getLong("idQuestion"),rs.getString("ennonce"),rs.getString("option1"),rs.getString("option2"),rs.getString("option3"),rs.getString("answer"),rs.getLong("idExamen"))) ;

            }
                
                
            } catch (SQLException ex) {
                System.out.println("erreur lors de la selection des questions ! ");
                
            }
              return listQuestion ;
    }
    
}
