/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import static gui.CatController.connectedUser;


import entities.badge;
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
/**
 *
 * @author SBS
 */
public class ServiceBadge implements IService<badge>{
    Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(badge c) {
         try {
            String requete = "INSERT INTO badge (badgeTYPE,badgeIMAGE) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, c.getBadgeTYPE());
            pst.setString(2, c.getBadgeIMAGE());
          
            pst.executeUpdate();
            System.out.println("badge added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(badge t) {
      try {
            String requete = "DELETE FROM badge WHERE badgeID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, t.getBadgeID());
            pst.executeUpdate();
            System.out.println("badge deleted !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(badge t) {
        try {
            String requete = "UPDATE badge SET badgeTYPE=?,badgeIMAGE=? WHERE badgeID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, t.getBadgeTYPE());
            pst.setString(2, t.getBadgeIMAGE());
            pst.setLong(3, t.getBadgeID());
            pst.executeUpdate();
            System.out.println("badge modified !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<badge> afficher() {
        List<badge> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM badge";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new badge( rs.getLong(1),rs.getString(2),rs.getString(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}
