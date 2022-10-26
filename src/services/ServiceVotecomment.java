/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.comment;
import entities.post;
import entities.vote;
import entities.votecomment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author SBS
 */
public class ServiceVotecomment implements IService<votecomment>{
     Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(votecomment t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(votecomment t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modifier(votecomment t) {
        try {
            String requete = "UPDATE votecomment SET votenb=?  WHERE userID=? AND commentID=? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getVotenb());
            pst.setLong(2, t.getUserID());
            pst.setLong(3, t.getCommentID());
            
            
            pst.executeUpdate();
            System.out.println("commentvote update !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<votecomment> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void like(votecomment t){
        try {
            String requete = "INSERT INTO votecomment (userID,commentID,votenb) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setLong(1, t.getUserID());
            pst.setLong(2, t.getCommentID());
            pst.setInt(3, 1);
          
            pst.executeUpdate();
            System.out.println("like added comment !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public void dislike(votecomment t){
        try {
            String requete = "INSERT INTO votecomment (userID,commentID,votenb) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setLong(1, t.getUserID());
            pst.setLong(2, t.getCommentID());
            pst.setInt(3, -1);
          
            pst.executeUpdate();
            System.out.println("dislike added comment !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public boolean isliked(comment p){
        ArrayList<votecomment> list= new ArrayList();
        try {
            String requete = "SELECT * FROM votecomment WHERE userID=? AND commentID=? AND votenb=? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, p.getUserID());
            pst.setLong(2, p.getCommentID());
            pst.setInt(3, 1);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new votecomment( rs.getLong(1),rs.getLong(2),rs.getInt(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

       list.forEach(System.out::println);
         return(!list.isEmpty());
    }
    public boolean isdisliked(comment p){
        ArrayList<votecomment> list= new ArrayList();
        try {
            String requete = "SELECT * FROM votecomment WHERE userID=? AND commentID=? AND votenb=? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, p.getUserID());
            pst.setLong(2, p.getCommentID());
            pst.setInt(3, -1);
         
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new votecomment( rs.getLong(1),rs.getLong(2),rs.getInt(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

       list.forEach(System.out::println);
       return(!list.isEmpty());
    }
}
