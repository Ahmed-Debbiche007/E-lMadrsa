/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entites.Attestation;
import utiles.DataDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class ServiceAttestation {
    Connection cnx = DataDB.getInstance().getCnx();
    
    
    public void ajouter_attestation (Attestation A ) {
        try {
            String requete = "INSERT INTO Attestation (idParticipation,dateAcq) VALUES ('" + A.getIdParticipation() + "','" + A.getDateAcq() +  "')";
            System.out.println("1A");
            Statement st = cnx.createStatement();
            System.out.println("2A");
            st.executeUpdate(requete);
            System.out.println("Attestation ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    public void modifier_attestation(Attestation A) {
        try {
            String requete = "UPDATE Attestation SET idParticipation='" +A.getIdParticipation()  + "',dateAcq='" + A.getDateAcq() +"' WHERE idAttestation=" + A.getIdAttestation() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Attestation modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    public void supprimer_attestation(Attestation A ) {
        try {
            String requete = "DELETE FROM Attestation WHERE idAttestation=" + A.getIdAttestation() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Attestation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Attestation> afficher() {
        List<Attestation> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Attestation ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Attestation(rs.getLong(1),rs.getLong(2),rs.getDate(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
     public ObservableList<Attestation> afficher_Att() {
        System.out.println("1");
        ObservableList<Attestation> list = FXCollections.observableArrayList();

        try {
            String requete = "select * from attestation JOIN participation On attestation.idParticipation=participation.idParticipation join user ON participation.idUser=user.idUser; ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Attestation(rs.getLong("idAttestation"),rs.getLong("idParticipation"),rs.getDate("dateAcq"),rs.getString("nom"),rs.getString("prenom")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}
