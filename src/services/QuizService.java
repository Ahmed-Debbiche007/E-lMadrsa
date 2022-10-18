package services;

import entities.Quiz;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import outils.MyDB;

 


public class QuizService implements IService<Quiz> {
        Connection cnx ; 

    public QuizService() {
    cnx = MyDB.getInstance().getCnx();
    }
 

    @Override
    public void ajouter(Quiz q) {
                try {
            String req="insert into Quiz(nameQuiz) values(?);" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, q.getNameQuizz());
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
    public List<Quiz> afficher() {
         List<Quiz> List = new ArrayList<>();

        
        try {
            
                 String req="select * from Quiz";
                 PreparedStatement st = cnx.prepareCall(req); 
                 ResultSet rs= st.executeQuery();
                while(rs.next()){
                  Quiz  q =new Quiz();
                  q.setNameQuizz("quizname");
        
                   List.add(q);
                }
             } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        
 
        return List;    
    }

    
    
    
    

}
