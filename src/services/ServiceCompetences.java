/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entites.Competences;
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
public class ServiceCompetences {
    
    Connection cnx = DataDB.getInstance().getCnx();
    public void ajouter_competence (Competences Comp ) {
        try {
            String requete = "INSERT INTO competences (nomCompetence) VALUES ('" + Comp.getNomCompetence() + "')";
            System.out.println("1Comp");
            Statement st = cnx.createStatement();
            System.out.println("2Comp");
            st.executeUpdate(requete);
            System.out.println("Competence ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    
    public void modifier_competence (Competences Comp) {
        try {
            String requete = "UPDATE competences SET nomCompetence='" +Comp.getNomCompetence()  + "' WHERE idCompetence=" + Comp.getIdCompetence() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Competence modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimer_competence(Competences Comp ) {
        try {
            String requete = "DELETE FROM competences WHERE idCompetence=" + Comp.getIdCompetence() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println(" Competence supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    /*public List<Competences> afficher() {
        List<Competences> list = new ArrayList<>();

        try {
            String requete = "SELECT idCompetence,nomCompetence FROM Competences ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Competences(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }*/
    public ObservableList<Competences> afficher_comp() {
        System.out.println("1");
        ObservableList<Competences> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT idCompetence,nomCompetence FROM competences ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Competences(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public ObservableList<Competences> afficher() {
        System.out.println("1");
        ObservableList<Competences> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT idCompetence,nomCompetence FROM competences ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Competences(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    
}
