/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.category;
import entities.post;
import entities.vote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;

/**
 *
 * @author aymen
 */
public class ServiceVote implements IService<vote> {
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(vote t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(vote t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modifier(vote t) {
       
        
        try {
            String requete = "UPDATE vote SET votenb=?  WHERE userID=? AND postID=? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getVotenb());
            pst.setLong(2, t.getUserID());
            pst.setLong(3, t.getPostID());
            
            
            pst.executeUpdate();
            System.out.println("vote update !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<vote> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void like(vote t){
        try {
            String requete = "INSERT INTO vote (userID,postID,votenb) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setLong(1, t.getUserID());
            pst.setLong(2, t.getPostID());
            pst.setInt(3, 1);
          
            pst.executeUpdate();
            System.out.println("like added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public void dislike(vote t){
        try {
            String requete = "INSERT INTO vote (userID,postID,votenb) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setLong(1, t.getUserID());
            pst.setLong(2, t.getPostID());
            pst.setInt(3, -1);
          
            pst.executeUpdate();
            System.out.println("dislike added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public boolean isliked(post p){
        ArrayList<vote> list= new ArrayList();
        try {
            String requete = "SELECT * FROM vote WHERE userID=? AND postID=? AND votenb=? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, p.getUserID());
            pst.setLong(2, p.getPostID());
            pst.setInt(3, 1);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new vote( rs.getLong(1),rs.getLong(2),rs.getInt(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

       list.forEach(System.out::println);
         return(!list.isEmpty());
    }
    public boolean isdisliked(post p){
        ArrayList<vote> list= new ArrayList();
        try {
            String requete = "SELECT * FROM vote WHERE userID=? AND postID=? AND votenb=? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, p.getUserID());
            pst.setLong(2, p.getPostID());
            pst.setInt(3, -1);
         
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new vote( rs.getLong(1),rs.getLong(2),rs.getInt(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

       list.forEach(System.out::println);
       return(!list.isEmpty());
    }
    
}
