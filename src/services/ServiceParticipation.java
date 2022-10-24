/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entites.Participation;
import utiles.DataDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ServiceParticipation {
    Connection cnx = DataDB.getInstance().getCnx();
    public void ajouter_Participation (Participation P ) {
        try {
            String requete = "INSERT INTO Participation (Resultat) VALUES ('" + P.getResultat() + "')";
            System.out.println("1C");
            Statement st = cnx.createStatement();
            System.out.println("2C");
            st.executeUpdate(requete);
            System.out.println("Categorie ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("problème IcI");
        }
        
        
    }
    
    
}
