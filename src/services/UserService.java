/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/**
 *
 * @author ahmed
 */
public class UserService {
 

    Connection cnx;

    public UserService() {
        cnx = MyDB.getInstance().getCnx();
    }
/*
    public void ajouterUser(User u) {
        try {
            String req = "INSERT INTO users(nom,prenom,age,mail) VALUES('" + u.getNom() + "','" + u.getPrenom() + "',"+u.get() + ")";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User added successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }
*/
    /*
    public void modifierUser(User u) {
        try {
            String req = "UPDATE user SET nom=?, prenom=?, age=?, email=? WHERE idUtilisateur=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, u.getNom());
            st.setString(2, u.getPrenom());
            st.setString(4, u.getemail());
            st.setLong(5, u.getId());
            st.executeUpdate();
            System.out.println("User modified successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }
*/
    public void supprimerUser(User u) {
        try {
            String req = "DELETE FROM user WHERE idUtilisateur=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1, u.getId());
            System.out.println("User deleted successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    public List<User> afficherUsers() {
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM user";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                User u = new User();
                u.setId(rs.getLong("idUtilisateur"));
                //u.setAge(rs.getInt("age"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setemail(rs.getString("email"));
                users.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return users;
    }
    
    public User getUserByID(long id){
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM user WHERE idUtilisateur= "+ id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
             User u = new User();
            while (rs.next()){
                
                u.setId(rs.getInt("idUtilisateur"));
               // u.setAge(rs.getInt("age"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setemail(rs.getString("email"));
               return u;
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
       return null;
    }
    
     public User getUserByName(String nom, String prenom){
        try {
            String req = "SELECT * FROM user WHERE nom = '"+ nom+"'"+"and prenom ="+prenom;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt("idUtilisateur"));
                //u.setAge(rs.getInt("age"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setmotDePasee(rs.getString("motDePasse"));
                u.setnomUtilisateur(rs.getString("nomUtilisateur"));
                u.setrole(rs.getString("role"));
                //u.setStatus(rs.getString("status"));
                u.setemail(rs.getString("email"));
               return u;
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return null;
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
