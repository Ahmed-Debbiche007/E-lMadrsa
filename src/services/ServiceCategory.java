/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entities.category;
import entities.post;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author SBS
 */
public class ServiceCategory  implements IService<category> {
    Connection cnx = DataSource.getInstance().getCnx();

    

    @Override
    public void ajouter(category c) {
        try {
            String requete = "INSERT INTO category (categoryNAME,categoryIMAGE) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, c.getCategoryNAME());
            pst.setString(2, c.getCategoryIMAGE());
          
            pst.executeUpdate();
            System.out.println("category added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public void supprimer(category t) {
        try {
            String requete = "DELETE FROM category WHERE categoryNAME=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getCategoryNAME());
            pst.executeUpdate();
            System.out.println("category deleted !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

   
    public void modifier(String s ,category t) {
       try {
            String requete = "UPDATE category SET categoryNAME=?,categoryIMAGE=? WHERE categoryNAME=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, t.getCategoryNAME());
            pst.setString(2, t.getCategoryIMAGE());
            pst.setString(3, s);
            pst.executeUpdate();
            System.out.println("Category modified !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<category> afficher() {
        ObservableList<category> list= FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM category";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new category( rs.getLong(1),rs.getString(2),rs.getString(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public void modifier(category t) {
        try {
            String requete = "UPDATE category SET categoryNAME=?,categoryIMAGE=? WHERE categoryID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(3, t.getCategoryID());
            pst.setString(1, t.getCategoryNAME());
            pst.setString(2, t.getCategoryIMAGE());
            pst.executeUpdate();
            System.out.println("Personne modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    

    
    
    
}
