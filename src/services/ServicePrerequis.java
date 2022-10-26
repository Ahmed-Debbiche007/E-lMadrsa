/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entites.Prerequis;
import utiles.DataDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author User
 */
public class ServicePrerequis {
    Connection cnx = DataDB.getInstance().getCnx();
    
    
     public void ajouter_Prerequis (Prerequis P ) {
        try {
            String requete = "INSERT INTO Prerequis (nomPrerequis) VALUES ('" + P.getNomPrerequis() + "')";
            System.out.println("1P");
            Statement st = cnx.createStatement();
            System.out.println("2");
            st.executeUpdate(requete);
            System.out.println("Prerequis ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
     
      public void modifier_prerequise (Prerequis P) {
        try {
            String requete = "UPDATE Prerequis SET nomPrerequis='" +P.getNomPrerequis()  + "' WHERE idPrerequis=" + P.getIdPrerequis() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Prerequis modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
       public void supprimer_prerequis(Prerequis P ) {
        try {
            String requete = "DELETE FROM Prerequis WHERE idPrerequis=" + P.getIdPrerequis() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println(" Prerequis supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
       public ObservableList<Prerequis> afficher_Pre() {
        System.out.println("1");
        ObservableList<Prerequis> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT idPrerequis,nomPrerequis FROM Prerequis ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Prerequis(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
       public ObservableList<Prerequis> afficher() {
        System.out.println("1");
        ObservableList<Prerequis> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT idPrerequis,nomPrerequis FROM Prerequis ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Prerequis(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    
    
}
