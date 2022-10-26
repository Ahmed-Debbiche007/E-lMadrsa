
package services;

import entities.Examen;
import entities.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/*
   private int idExamen ; 
   private String nomExamen ;  
   private Double pourcentage  ; 
   private int DureeExamen ;  
*/

public class ExamenService implements IService<Examen> {
    
        public ExamenService() {
    cnx = MyDB.getInstance().getCnx();
    }
    
    Connection cnx ; 
 

    @Override
    public void ajouter(Examen e) {
                try {
            String req = "insert into Examen (nomExamen,pourcentage,DureeExamen,formationId ,idcategorie) values(?,?,?,?,?)"  ;
            PreparedStatement st = cnx.prepareStatement(req) ; 
            st.setString(1, e.getNomExamen());
            st.setDouble(2, e.getPourcentage());
            st.setInt(3, e.getDureeExamen());
            st.setLong(4, e.getFormationId());
            st.setLong(5, e.getIdCategorie());
            st.execute();
            System.out.println("Examen  ajouté  !");

            
        } catch (SQLException ex) {
                        System.out.println("erreur ! examen n'est pas ajouté") ; 
        }
     }
    
public Examen getLatest() {
        try {
            String req = "SELECT * FROM Examen ORDER BY idExamen DESC LIMIT 1 ";
            PreparedStatement st = cnx.prepareStatement(req) ;
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Examen e = new Examen();
                e.setIdExamen(rs.getLong("idExamen"));
                e.setNomExamen(rs.getString("nomExamen"));
                e.setPourcentage(rs.getDouble("pourcentage"));
                e.setDureeExamen(rs.getInt("DureeExamen"));
                e.setFormationId(rs.getLong("formationId"));
                e.setIdCategorie(rs.getLong("idCategorie"));
                return e;
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return null;
    }
public Examen getExamById(Long id ) {
        try {
            String req = "SELECT * FROM Examen  where idExamen = ? ";
            PreparedStatement st = cnx.prepareStatement(req) ;
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Examen e = new Examen();
                e.setIdExamen(rs.getLong("idExamen"));
                e.setNomExamen(rs.getString("nomExamen"));
                e.setPourcentage(rs.getDouble("pourcentage"));
                e.setDureeExamen(rs.getInt("DureeExamen"));
                e.setFormationId(rs.getLong("formationId"));
                e.setIdCategorie(rs.getLong("idCategorie"));
                return e;
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return null;
    }


public Examen countExams( String nom ) {
            try {
                String req = "SELECT  *  FROM Examen  where nomExamen=? ";
                PreparedStatement st = cnx.prepareStatement(req) ;
                            st.setString(1, nom);

                ResultSet rs = st.executeQuery();
            while (rs.next()){
                Examen e = new Examen();
                e.setIdExamen(rs.getLong("idExamen"));
                e.setNomExamen(rs.getString("nomExamen"));
                e.setPourcentage(rs.getDouble("pourcentage"));
                e.setDureeExamen(rs.getInt("DureeExamen"));
                e.setFormationId(rs.getLong("formationId"));
                e.setIdCategorie(rs.getLong("idCategorie"));
                return e;
            }
            } catch (SQLException ex) {
                System.out.println("examen not found "  + ex.getMessage());
                
            }
            
            return null ;
    
    
}
    
    
        public boolean save(List<Question> questions) {
        boolean flag = true;
        QuestionService Qservice = new QuestionService() ;
        for (Question q : questions) {
             Qservice.ajouter(q);
            System.out.println(flag);
        }
        return flag;
    }

    @Override
    public void supprimer(Examen e) {
                try {
            String req = "DELETE FROM Examen WHERE idExamen=? ;"  ;
            PreparedStatement st = cnx.prepareStatement(req); 
            st.setLong(1, e.getIdExamen());
            st.executeUpdate();
            System.out.println("Examen  deleted");

        } catch (SQLException ex) {
            Logger.getLogger(ExamenService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    @Override
    public void modifier(Examen E) {
                    try {
                String req ="update Examen set nomExamen=?,pourcentage=?,DureeExamen=? where idExamen=?" ;
                PreparedStatement st = cnx.prepareStatement(req); 
                st.setString(1, E.getNomExamen());
                st.setDouble(2,E.getPourcentage());
                st.setInt(3, E.getDureeExamen());
                st.setLong(4, E.getIdExamen());
                st.executeUpdate();
                System.out.println("Examen  updated");

            } catch (SQLException ex) {
                Logger.getLogger(ExamenService.class.getName()).log(Level.SEVERE, null, ex);
            }
     }

    @Override
    public ObservableList<Examen> afficher() {
                   ObservableList<Examen> listExamen =FXCollections.observableArrayList();

            try {
                
                  
                
                
                
                String req = "SELECT * FROM examen  JOIN categorie ON examen.idcategorie=categorie.idCategorie JOIN formation On examen.formationId= formation.idFormation" ;
                PreparedStatement st = cnx.prepareStatement(req) ; 
                 ResultSet rs = st.executeQuery(req) ;
                
                while(rs.next()) {
                listExamen.add(new Examen( rs.getLong("idExamen"),rs.getString("nomExamen"), rs.getDouble("pourcentage"), rs.getInt("DureeExamen") , rs.getLong("formationId") ,rs.getLong("idCategorie"),rs.getString("nomCategorie"),rs.getString("sujet")));
                

            }

                
            } catch (SQLException ex) {
                System.out.println("error occured" +ex.getMessage());
                
            }
              return listExamen ;
     }

 

    public  Map<Examen, List<Question>> getAll() {                
        Map<Examen, List<Question>> exams = new HashMap<>();
                Examen key = null;
        
            try {

                
                String req = " SELECT * from Examen e join Question q on e.idExamen=q.idExamen ;"  ;
                PreparedStatement st = cnx.prepareStatement(req) ;
                ResultSet rs = st.executeQuery() ;
                while(rs.next()) {
                    
                 
                Examen tempEX = new Examen();
                tempEX.setIdExamen(rs.getLong(1));
                tempEX.setNomExamen(rs.getString(2));
                tempEX.setPourcentage(rs.getDouble(3));
                tempEX.setDureeExamen(rs.getInt(4));
                tempEX.setFormationId(rs.getLong(5));
                tempEX.setIdCategorie(rs.getLong(6));
                
          
                Question tempQuestion = new Question();
                tempQuestion.setIdQuestion(rs.getLong(7));
                tempQuestion.setEnnonce(rs.getString(8));
                tempQuestion.setOption1(rs.getString(9));
                tempQuestion.setOption2(rs.getString(10));
                tempQuestion.setOption3(rs.getString(11));
                tempQuestion.setAnswer(rs.getString(12));    
                tempQuestion.setIdExamen(rs.getLong(13));    
                if (key != null && key.equals(tempEX)) {
                exams.get(key).add(tempQuestion);
                } else {
                ArrayList<Question> value = new ArrayList<>();
                value.add(tempQuestion);
                exams.put(tempEX, value);
                }
                
                key = tempEX;
                
                
                
                }
            
            
                        } catch (SQLException ex) {
                                System.out.println("error occured" +ex.getMessage());
            }
                        return exams ; 
}

                
                /*
                try {
                Class.forName(DatabaseConstants.DRIVER_CLASS);
                try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet result = ps.executeQuery();

                while (result.next()) {
                Quiz temp = new Quiz();
                temp.setQuizId(result.getInt(1));
                temp.setTitle(result.getString(2));
                
                Question tempQuestion = new Question();
                tempQuestion.setQuestionId(result.getInt(3));
                tempQuestion.setQuestion(result.getString(4));
                tempQuestion.setOption1(result.getString(5));
                tempQuestion.setOption2(result.getString(6));
                tempQuestion.setOption3(result.getString(7));
                tempQuestion.setOption4(result.getString(8));
                tempQuestion.setAnswer(result.getString(9));
                
                if (key != null && key.equals(temp)) {
                quizes.get(key).add(tempQuestion);
                } else {
                ArrayList<Question> value = new ArrayList<>();
                value.add(tempQuestion);
                quizes.put(temp, value);
                }
                
                key = temp;
                
                }
                }
                } catch (Exception ex) {
                ex.printStackTrace();
                }
                
                return quizes;
                }
            */   
    
    
    
    
    
    
    
    
        public   Map<Examen, Integer> getAllWithQuestionCount() {
                            Map<Examen, Integer> examesmap = new HashMap<>();
                Examen key = null;
            try {

                
                String req = " select * , count(*) as c   from  examen  join question on examen.idExamen = question.idExamen group by examen.idExamen ;";
                
                PreparedStatement st = cnx.prepareStatement(req) ;
                ResultSet rs = st.executeQuery() ;
                while(rs.next()) {
                    Examen temp = new Examen();
                    temp.setIdExamen(rs.getLong(1));
                    temp.setNomExamen(rs.getString(2));
                    temp.setPourcentage(rs.getDouble(3));
                    temp.setDureeExamen(rs.getInt(4));
                    
                    
                    temp.setFormationId(rs.getLong(5));
                    temp.setIdCategorie(rs.getLong(6));
 
                    
 
                    
                    int count = rs.getInt("c");
                    examesmap.put(temp, count);
                     System.out.println( examesmap);

                } 
            } catch (SQLException ex) {
                 System.out.println("error occured" +ex.getMessage());
            }
                    
 
        return examesmap;
    }
    
            public  ObservableList<Examen> getAllWithQuestionCountbycategorieid(Long id ) {
                   ObservableList<Examen> listExamen =FXCollections.observableArrayList();

            try {

                String req = "SELECT * FROM examen  where examen.idcategorie= ? ;" ;
                PreparedStatement st = cnx.prepareStatement(req) ; 
                st.setLong(1, id);
                 ResultSet rs = st.executeQuery() ;
                
                while(rs.next()) {
                listExamen.add(new Examen( rs.getLong("idExamen"),rs.getString("nomExamen"), rs.getDouble("pourcentage"), rs.getInt("DureeExamen") , rs.getLong("formationId") ,rs.getLong("idCategorie") ));
 
            }

                
            } catch (SQLException ex) {
                System.out.println("error occured" +ex.getMessage());
                
            }
              return listExamen ;
    }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            //  
            
             public   Map<Examen, Integer> getAllWithQuestionCountByCategory(Long id) {
                            Map<Examen, Integer> examesmap = new HashMap<>();
                Examen key = null;
            try {

                
                String req = "select * , count(*) as c   from  examen  join question on examen.idExamen = question.idExamen and examen.idcategorie=? group by examen.idExamen;";
                
                PreparedStatement st = cnx.prepareStatement(req) ;
                                 st.setLong(1, id);

                ResultSet rs = st.executeQuery() ;
                while(rs.next()) {
                    Examen temp = new Examen();
                    temp.setIdExamen(rs.getLong(1));
                    temp.setNomExamen(rs.getString(2));
                    temp.setPourcentage(rs.getDouble(3));
                    temp.setDureeExamen(rs.getInt(4));
                    
                    
                    temp.setFormationId(rs.getLong(5));
                    temp.setIdCategorie(rs.getLong(6));
 
                    
 
                    
                    int count = rs.getInt("c");
                    examesmap.put(temp, count);
                     System.out.println( examesmap);

                } 
            } catch (SQLException ex) {
                 System.out.println("error occured" +ex.getMessage());
            }
                    
 
        return examesmap;
    }
            
            
            
            
            
            
            
  public List<Question> getQuestions(Long id) {
       List<Question> listQuestion = new ArrayList<>();
       
       
       
            try {
               
                
                String req = "SELECT * from question q where q.idExamen=? ;  " ;
                
                PreparedStatement st = cnx.prepareStatement(req) ;
                st.setLong(1, id);
                ResultSet rs = st.executeQuery() ;
                
                
                while (rs.next()) {
                listQuestion.add(new Question(rs.getLong("idQuestion"),rs.getString("ennonce"),rs.getString("option1"),rs.getString("option2"),rs.getString("option3"),rs.getString("answer"),rs.getLong("idExamen"))) ;
                System.out.println("ffffffffff" + listQuestion);
                }
                    
               
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ExamenService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            return  listQuestion ; 
    
    
    
  }
}
