/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Examen;
import entities.Reclamation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/**
 *
 * @author Msi
 */
public class ReclamationServices implements IService<Reclamation> {
        public ReclamationServices() {
    cnx = MyDB.getInstance().getCnx();
    }
    
    Connection cnx ; 
 
    @Override
    public void ajouter(Reclamation t) {
                        try {
            String req = "INSERT INTO reclamation (sujet, description, dateRec) VALUES (?, ?, ?);"  ;
            PreparedStatement st = cnx.prepareStatement(req) ; 
            st.setString(1,t.getSujet());
            st.setString(2,t.getDescription());
            st.setDate(3, new java.sql.Date(t.getDateRec().getTime()));
  
            st.execute();
            System.out.println("reclaamtion  ajouté  !");

            
        } catch (SQLException ex) {
                        System.out.println("erreur ! reclaamtion n'est pas ajouté") ; 
        }
     }

    @Override
    public void supprimer(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modifier(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<Reclamation>   afficher() {
            
                  ObservableList<Reclamation>   list =FXCollections.observableArrayList();

            try {
                
                  
                
                
                
                String req = "SELECT *  from reclamation" ;
                PreparedStatement st = cnx.prepareStatement(req) ; 
                 ResultSet rs = st.executeQuery(req) ;
                
                while(rs.next()) {
                list.add(new Reclamation( rs.getLong("idReclamation"), rs.getString("sujet"), rs.getString("description"), rs.getDate("dateRec"),rs.getLong("idUser")));
                

            }

                
            } catch (SQLException ex) {
                System.out.println("error occured" +ex.getMessage());
                
            }
              return list ;
     }

        
     
    
    
    
    
    
}
