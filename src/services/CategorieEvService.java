/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.CategorieEv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import outils.MyDB;

/**
 *
 * @author lmol
 */
public class CategorieEvService {

    private final Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public CategorieEvService() {
        conn = MyDB.getInstance().getCnx();

    }

    public void insert(CategorieEv t) {
        String req;

        try {
            req = " insert into categorie_ev (type_evenement) values (?)";
            pst = conn.prepareStatement(req);
            pst.setString(1, t.getType_ev());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieEvService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void delete(int id) {
        String req = "DELETE FROM Categorie WHERE Id=?";
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieEvService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void update(CategorieEv t) {
        try {

            String req = "update Categorie set type_evenement=? where Id=?";
            pst = conn.prepareStatement(req);
            pst.setString(1, t.getType_ev());
            pst.setInt(2, t.getId_categorie());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategorieEvService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCat(CategorieEv t, String type) {
        try {

            String req = "update categorie_ev set type_evenement=? where Id=?";
            pst = conn.prepareStatement(req);
            System.out.println(t.getType_ev()+ " " +t.getId_categorie() + " " + type);
            pst.setInt(2, t.getId_categorie());
            pst.setString(1, type);
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategorieEvService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<CategorieEv> read() {
        String req;
        req = "select * from categorie_ev ";

        List<CategorieEv> list = new ArrayList<>();
        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);

            while (rs.next()) {
                list.add(new CategorieEv(rs.getInt("id"), rs.getString("type_evenement")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategorieEvService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public CategorieEv readById(int id) {

        String req = "select * from categorie_ev where Id=" + id;
        CategorieEv d = new CategorieEv();

        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                d.setId_categorie(rs.getInt("Id"));
                d.setType_ev(rs.getString("type_evenement"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieEvService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public CategorieEv readByName(String type_ev) {

        String req = "select * from categorie_ev where type_evenement LIKE '%" + type_ev + "%'";
        CategorieEv d = new CategorieEv();

        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                d.setId_categorie(rs.getInt("id"));
                d.setType_ev(rs.getString("type_evenement"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieEvService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public void deletename(String id) {
        String req = "DELETE FROM Categorie WHERE type_evenement=?";
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieEvService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
