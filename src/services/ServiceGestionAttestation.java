/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entites.Attestation;
import entites.Participation;
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
public class ServiceGestionAttestation {
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
    
     public ObservableList<Participation> afficher_DemandeAttestation() {
        System.out.println("1");
        ObservableList<Participation> list = FXCollections.observableArrayList();
       
        
        

         try {
            String requete = "SELECT * from participation join user on user.idUser=participation.idUser JOIN formation on participation.idFormation=formation.idFormation; ";
            PreparedStatement st = cnx.prepareStatement(requete) ;
            ResultSet rs = st.executeQuery(requete);
            
           
            System.out.println(rs);
            while (rs.next()) {
               
                
             
                list.add(new Participation(rs.getLong("idParticipation"), rs.getLong("idUser"), rs.getLong("idFormation"),rs.getLong("resultat"),rs.getString("nom"),rs.getString("Prenom"),rs.getString("sujet")));
                System.out.println("heeeeeeeeeeey" + list);
            
            
            }
            
            
            
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}
