/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.User;
import entities.Recup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/**
 *
 * @author ahmed
 */
public class RecupService implements IService<Recup> {

    Connection cnx = MyDB.getInstance().getCnx();

    @Override
    public void ajouter(Recup n) {
        try {
            String requete = "INSERT INTO recup (Iduser, code) VALUES(?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, n.getIdUser());
            pst.setString(2, n.getCode());

            pst.executeUpdate();
            System.out.println("user ajouté");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Recup n) {
        try {
            String requete = "DELETE FROM recup WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, n.getId());
            pst.executeUpdate();
            System.out.println("user supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Recup n) {
        try {
            String requete = "UPDATE recup SET iduser=?, code=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, n.getIdUser());
            pst.setString(2, n.getCode());

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Recup> afficher() {
        ObservableList<Recup> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM recup";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getLong("Iduser"), rs.getString("nom"), rs.getString("prenom"), rs.getString("nomUtilisateur"), rs.getString("tel"), rs.getString("email"), rs.getString("motDePasse"), rs.getDate("dateNaissance"), rs.getString("image"), rs.getString("role"), rs.getBoolean("approved"));
                
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    public Recup getByUserId(long id) {

        try {
            String requete = "select * from recup where iduser=? order by id desc limit 1";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Recup u = new Recup(rs.getLong("id"), id, rs.getString("code"));
                System.out.println(u.toString());
                return u;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

}
