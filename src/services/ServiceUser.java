/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entities.category;
import entities.post;
import entities.user;
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
public class ServiceUser implements IService<user>{
  Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(user c) {
        try {
            String requete = "INSERT INTO user (userNAME,badgeID,karmaCOUNT,userIMAGE) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            pst.setString(1, c.getUserNAME());
            pst.setLong(2, c.getBadgeID());
            pst.setInt(3, c.getKarmaCOUNT());
            pst.setString(4, c.getUserIMAGE());
          
            pst.executeUpdate();
            System.out.println("user added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(user t) {
              try {
            String requete = "DELETE FROM user WHERE userID=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, t.getUserID());
            pst.executeUpdate();
            System.out.println("user deleted !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(user t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<user> afficher() {
        List<user> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM user";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new user( rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getInt(4),rs.getString(5)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}
