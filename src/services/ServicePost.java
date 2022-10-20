/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entities.category;
import entities.post;
import static gui.CatController.staticcat;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author SBS
 */
public class ServicePost implements IService<post>{
    Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(post c) {
       try {
            String requete = "INSERT INTO post (postTITLE,postCONTENT,categoryID,postDate) VALUES (?,?,?,now())";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, c.getPostTITLE());
            pst.setString(2, c.getPostCONTENT());
            pst.setLong(3, staticcat.getCategoryID());
            //pst.setLong(3, c.getUserID());
            //pst.setInt(5, c.getPostVOTE());
            //pst.setInt(6, c.getPostNBCOM());
            
          
            pst.executeUpdate();
            System.out.println("post added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    @Override
    public void supprimer(post t) {
              try {
            String requete = "DELETE FROM post WHERE postID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, t.getPostID());
            pst.executeUpdate();
            System.out.println("post deleted !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(post t) {
        try {
            String requete = "UPDATE post SET postTITLE=?,postCONTENT=? WHERE postID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, t.getPostTITLE());
            pst.setString(2, t.getPostCONTENT());
            pst.setLong(3, t.getPostID());
            
            
           
            pst.executeUpdate();
            System.out.println("Category modified !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<post> afficher() {
        List<post> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM post";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new post( rs.getLong(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getLong(5),rs.getInt(6),rs.getInt(7),rs.getTimestamp(8)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    public ObservableList<post> afficherpp(category c) {
        ObservableList<post> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM post where categoryID =?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1,c.getCategoryID());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new post( rs.getLong(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getLong(5),rs.getInt(6),rs.getInt(7),rs.getTimestamp(8)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    
    
}
