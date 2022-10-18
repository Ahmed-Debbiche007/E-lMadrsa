package services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import entities.Personne;
  import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import outils.MyDB;
import services.IService;

/**
 *
 * @author aissa
 */
public class ServicePersonne implements IService<Personne> {

        Connection cnx ; 

    public ServicePersonne() {
    cnx = MyDB.getInstance().getCnx();
    }
    public void ajouter(Personne t) {
        try {
            String requete = "INSERT INTO personne (nom,prenom) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.executeUpdate();
            System.out.println("Personne ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Personne t) {
        try {
            String requete = "DELETE FROM personne WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Personne supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Personne t) {
        try {
            String requete = "UPDATE personne SET nom=?,prenom=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(3, t.getId());
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.executeUpdate();
            System.out.println("Personne modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Personne> afficher() {
        List<Personne> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM personne";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Personne(rs.getInt(1), rs.getString(2), rs.getString("prenom")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
}
