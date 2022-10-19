package services;

import entities.Quiz;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

 


public class QuizService implements IService<Quiz> {
        Connection cnx ; 

    public QuizService() {
    cnx = MyDB.getInstance().getCnx();
    }
 

    @Override
    public void ajouter(Quiz q) {
                try {
            String req="insert into Quiz(nameQuiz,examenId) values(?,?);" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, q.getNameQuizz());
            st.setLong(2,q.getIdExamen());

            st.execute() ; 
            System.out.println("quiz ajouté ") ;
           
            
            
        } catch (SQLException ex) {
            System.out.println("Erreur quiz non ajouté ") ;
        }
    }

    @Override
    public void supprimer(Quiz q) {
                try {
            String req = "DELETE FROM Quiz WHERE idQuiz=? ;"  ;
            PreparedStatement st = cnx.prepareStatement(req); 
            st.setLong(1, q.getIdQuizz());
            st.executeUpdate();
            System.out.println("qiuz  supprimé");

        } catch (SQLException ex) {
            System.out.println("Erreur qiuz   non  supprimé");
        }
    }

    @Override
    public void modifier(Quiz q) {
                    try {
                String req ="update Quiz set nameQuiz=? where idQuiz=?" ;
                PreparedStatement st = cnx.prepareStatement(req); 
                st.setString(1, q.getNameQuizz());
                st.setDouble(2,q.getIdQuizz());

                st.executeUpdate();
                System.out.println("quiz modifié ");

            } catch (SQLException ex) {
                System.out.println("Erreur quiz non  modifié ");
            }
     
}

    @Override
    public ObservableList<Quiz> afficher() {
         ObservableList<Quiz> List = FXCollections.observableArrayList() ;

        
        try {
            
                 String req="select * from Quiz";
                 PreparedStatement st = cnx.prepareCall(req); 
                 ResultSet rs= st.executeQuery();
                while(rs.next()){
                    List.add(new Quiz( rs.getLong("idQuiz"),rs.getString("nameQuiz"),rs.getLong("examenId") ));
                }
             } catch (SQLException ex) {
                System.out.println("*********" + ex.getErrorCode());
    }
        
 
        return List;    
    }

    
    
    
    

}
