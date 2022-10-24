/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utiles.DataDB;

/**
 *
 * @author User
 */
public class ServiceExamen {
    Connection cnx = DataDB.getInstance().getCnx();
    public ObservableList<Examen> afficher() {
                   ObservableList<Examen> listExamen =FXCollections.observableArrayList();

            try {
                
                  
                
                
                
                String req = "SELECT idExamen,nomExamen FROM examen  " ;
                PreparedStatement st = cnx.prepareStatement(req) ; 
                 ResultSet rs = st.executeQuery(req) ;
                
                while(rs.next()) {
                listExamen.add(new Examen( rs.getLong("idExamen"),rs.getString("nomExamen")));
                //System.out.println("dddddddddddddddderfevrgtbrtb" + listExamen);

            }

                
            } catch (SQLException ex) {
                System.out.println("error occured" +ex.getMessage());
                
            }
              return listExamen ;
     }
    
}
