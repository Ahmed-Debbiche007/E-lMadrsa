/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Participation;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/**
 *
 * @author Msi
 */
public class ParticipationsService implements IService<Participation> {
        Connection cnx ; 

    public ParticipationsService() {
    cnx = MyDB.getInstance().getCnx();
    }
 
    @Override
    public void ajouter(Participation p) {
                        try {
            String req="insert into Participation(idFormation,idUser) values(?,?);" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1, p.getIdFormation());
            st.setLong(2, p.getIdUser());

            st.execute() ; 
            System.out.println("Participation ajouté ") ;
           
            
            
        } catch (SQLException ex) {
            System.out.println("Erreur participation non ajouté ") ;
        }
     }
    public void AffecterResultat(double Resultat, Long id) {
                        try {
            String req="UPDATE participation SET resultat=? WHERE  idParticipation=?;" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setDouble(1, Resultat);
            st.setLong(2, id);

            st.execute() ; 
            System.out.println("result added ") ;
           
            
            
        } catch (SQLException ex) {
            System.out.println("Erreur participation non modifié , result not updated ") ;
        }
     }
    @Override
    public void supprimer(Participation p) {
                        try {
            String req = "DELETE FROM participation WHERE idParticipation=? ;"  ;
            PreparedStatement st = cnx.prepareStatement(req); 
            st.setLong(1, p.getIdParticipation());
            st.executeUpdate();
            System.out.println("participation  supprimé");

        } catch (SQLException ex) {
            System.out.println("Erreur participation   non  supprimé");
        }
     }

    @Override
    public void modifier(Participation p) {
                            try {
                String req ="update participation set resultat=? where idParticipation=?" ;
                PreparedStatement st = cnx.prepareStatement(req); 
                st.setDouble(1, p.getResultat());
                st.setLong(2,p.getIdParticipation());

                st.executeUpdate();
                System.out.println("participation modifié ");

            } catch (SQLException ex) {
                System.out.println("Erreur participation non  modifié ");
            }
     }

    @Override
    public  ObservableList<Participation> afficher() {
                 ObservableList<Participation> List = FXCollections.observableArrayList();

        
        try {
            
                 String req="SELECT * FROM participation p  JOIN formation f ON f.idFormation=p.idFormation JOIN user On user.idUtilisateur=p.idUser ;";
                 PreparedStatement st = cnx.prepareCall(req); 
                 ResultSet rs= st.executeQuery();
                while(rs.next()){
                  Participation  p =new Participation();
                  p.setIdParticipation(rs.getLong(1));
                  p.setIdUser(rs.getLong(2));
                  p.setIdFormation(rs.getLong(3));
                  p.setResultat(rs.getDouble(4));
                  p.setNomFormation(rs.getString(6));
                  p.setNomUser(rs.getString(15));
                  
                  
        
                   List.add(p);
                }
             } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        
 
        return List;   
     }
    
    
    
    
        public  Participation  getParticipation(Long idUser , Long idFormation) {
 
        
        try {
            
                 String req="select * from participation where idUser=? and idFormation=?;";
                 PreparedStatement st = cnx.prepareCall(req); 
                st.setDouble(1,idUser );
                st.setLong(2,idFormation );
                 ResultSet rs= st.executeQuery();
                while(rs.next()){
                                    Participation  p = new Participation()  ; 

                   p.setIdParticipation(rs.getLong(1));
                  p.setIdUser(rs.getLong(2));
                  p.setIdFormation(rs.getLong(3));
                  p.setResultat(rs.getDouble(4));
                  System.out.println("paaaart" +p);
                  return p ;
                  
        
             }
             } catch (SQLException ex) {
                System.out.println("*********************" +ex.getLocalizedMessage());
    }
        
 
        return null   ;   
     }
    
    
    
        // 

            public  ObservableList<User>  getParticipation(Long id) {
 
       ObservableList<User> list = FXCollections.observableArrayList();
        try {
            
                 String req="SELECT * FROM participation p INNER JOIN user u  ON p.idUser = u.idUtilisateur  JOIN formation f ON p.idFormation = f.idFormation  where p.idFormation=? ORDER BY p.resultat desc limit 3";
                 PreparedStatement st = cnx.prepareCall(req); 
                st.setDouble(1,id );
                 ResultSet rs= st.executeQuery();
                while(rs.next()){
               User  u = new User()  ; 
               
               u.setNom(rs.getString(5));
               u.setPrenom(rs.getString(6));
               u.setResultat(rs.getDouble(4));
               
               list.add(u);


                   
        
             }
                
                return list  ;
             } catch (SQLException ex) {
                System.out.println("*********************" +ex.getLocalizedMessage());
    }
        
 
        return list   ;   
     }
    
    
}
