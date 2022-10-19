
package services;

import entities.Examen;
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
            String req = "insert into Examen (nomExamen,pourcentage,DureeExamen) values(?,?,?)"  ;
            PreparedStatement st = cnx.prepareStatement(req) ; 
            st.setString(1, e.getNomExamen());
            st.setDouble(2, e.getPourcentage());
            st.setInt(3, e.getDureeExamen());
            st.execute();
            System.out.println("Examen  ajouté  !");

            
        } catch (SQLException ex) {
                        System.out.println("erreur ! examen n'est pas ajouté") ; 
        }
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
    public List<Examen> afficher() {
                   List<Examen> listExamen = new ArrayList<>();

            try {
                String req = "select * from Examen" ;
                PreparedStatement st = cnx.prepareStatement(req) ; 
                 ResultSet rs = st.executeQuery(req) ;
                
                while(rs.next()) {
                Examen ex = new Examen();
                ex.setNomExamen("math");
                ex.setPourcentage(60.0);
                ex.setDureeExamen(20);
                listExamen.add(ex);
            }
                
                
            } catch (SQLException ex) {
                System.out.println("error occured");
                
            }
              return listExamen ;
     }

 


   
}
