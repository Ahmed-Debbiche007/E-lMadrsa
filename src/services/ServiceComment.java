/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import static gui.CatController.connectedUser;


import entities.category;
import entities.comment;
import entities.post;
import static gui.CatController.staticpost;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author SBS
 */
public class ServiceComment implements IService<comment>{
    Connection cnx = DataSource.getInstance().getCnx();
   
    @Override
    public void ajouter(comment c) {
        try {
        String requete = "INSERT INTO comment (commentCONTENT,postID,userID,commentDate) VALUES (?,?,?,now())";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, c.getCommentCONTENT());
            
           pst.setLong(2, staticpost.getPostID());
           pst.setLong(3, connectedUser.getId());
           
           
            
            
          
            pst.executeUpdate();
            ServicePost sp= new ServicePost();
            sp.plusonecomment(staticpost);
            
            System.out.println("comment added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

   

   
    
}

    @Override
    public void supprimer(comment t) {
              try {
            String requete = "DELETE FROM comment WHERE commentID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, t.getCommentID());
            pst.executeUpdate();
            ServicePost sp= new ServicePost();
            sp.minusonecomment(staticpost);
            System.out.println("comment deleted !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(comment t) {
         try {
            String requete = "UPDATE comment SET commentCONTENT=? WHERE commentID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, t.getCommentCONTENT());
            pst.setLong(2, t.getCommentID());
           
            pst.executeUpdate();
            System.out.println("Category modified !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<comment> afficher() {
         List<comment> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM comment";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new comment( rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getInt(5),rs.getTimestamp(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public ObservableList<comment> afficherpp(post p) {
        ObservableList<comment> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT comment.*, user.nom FROM comment JOIN user on comment.userID=user.idUtilisateur where postID =?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1,p.getPostID());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new comment( rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getInt(5),rs.getTimestamp(6),rs.getString(7)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    
    public void plusone(comment t) {
        try {
            String requete = "UPDATE comment SET commentVOTE=? WHERE commentID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setInt(1, t.getCommentVOTE()+1);
            pst.setLong(2, t.getCommentID());
         
            
            
           
            pst.executeUpdate();
            System.out.println("plus one  !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public void minusone(comment t) {
        try {
            String requete = "UPDATE comment SET commentVOTE=? WHERE commentID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setInt(1, t.getCommentVOTE()-1);
            pst.setLong(2, t.getCommentID());
            
            
           
            pst.executeUpdate();
            System.out.println("minus one  !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
   }
}