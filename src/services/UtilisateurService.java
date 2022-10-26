/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import static gui.CatController.connectedUser;

import entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.DataSource;

/**
 *
 * @author Nour
 */
public class UtilisateurService implements IService<User> {
    Connection cnx = DataSource.getInstance().getCnx();
    
    
    @Override
    public void ajouter(User n) {
        try{
            String requete = "INSERT INTO user (nom,prenom,nomUtilisateur,tel,email,motDePasse,dateNaissance,image,role) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, n.getNom());
            pst.setString(2, n.getPrenom());
            pst.setString(3, n.getnomUtilisateur());
            pst.setString(4, n.gettel());
            pst.setString(5, n.getemail());
            pst.setString(6, n.getmotDePasse());
            pst.setDate(7, n.getdateNaissance());
            pst.setString(8, n.getImage());
            pst.setString(9, n.getrole());
            
            pst.executeUpdate();
        System.out.println("user ajouté");
        
    }  catch (SQLException ex) {
        System.err.println(ex.getMessage());
}
}


   @Override
    public void supprimer(User n) {
        try {
            String requete = "DELETE FROM user WHERE idUtilisateur=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, n.getId());
            pst.executeUpdate();
            System.out.println("user supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(User n) {
        try {
            String requete = "UPDATE user SET nom=?,prenom=?,nomUtilisateur=?,tel=?,email=?,motDePasse=?,dateNaissance=?,image=?,role=? WHERE idUtilisateur=?" ;
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, n.getNom());
            pst.setString(2, n.getPrenom());
            pst.setString(3, n.getnomUtilisateur());
            pst.setString(4, n.gettel());
            pst.setString(5, n.getemail());
            pst.setString(6, n.getmotDePasse());
            pst.setDate(7, n.getdateNaissance());
            pst.setString(8, n.getImage());
            pst.setString(9, n.getrole());
            pst.setLong(10, n.getId());
            
            pst.executeUpdate();
            System.out.println("user modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    

    @Override
    public ObservableList<User> afficher() {
        ObservableList<User> list = FXCollections.observableArrayList();
       
        try {
            String requete = "SELECT * FROM user";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getLong("idUtilisateur"), rs.getString("nom"), rs.getString("prenom"), rs.getString("nomUtilisateur"), rs.getString("tel"), rs.getString("email"),rs.getString("motDePasse"), rs.getDate("dateNaissance"), rs.getString("image"),rs.getString("role")) ;
                list.add(u);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    public User getByUserName(String userName) {
        ObservableList<User> list = FXCollections.observableArrayList();
       
        try {
            String requete = "select * from user where nomUtilisateur=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getLong("idUtilisateur"), rs.getString("nom"), rs.getString("prenom"), rs.getString("nomUtilisateur"), rs.getString("tel"), rs.getString("email"),rs.getString("motDePasse"), rs.getDate("dateNaissance"), rs.getString("image"),rs.getString("role")) ;
                return u;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }
    
    
   
    
    
}
