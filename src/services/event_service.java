/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import entities.CategorieEv;
import entities.evenement;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import outils.MyDB;

/**
 *
 * @author lmol
 */
public class event_service {

    private final Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public event_service(){
    conn = MyDB.getInstance().getCnx();
        
}
    
  
    public void insert(evenement t) {
            String req;
                    java.sql.Date DateEv = new java.sql.Date(t.getDate().getTime());

        
        try {
                  req = " insert into evenement (id_Cat, nom_evenement,description,image,id_utilisateur,date,etat_evenement) values (?,?,?,?,?,?,?)";
                  pst = conn.prepareStatement(req);
                  pst.setObject(1,t.getId_categorie().getId_categorie());
                  pst.setString(2, t.getNom_ev());
                  pst.setString(3,t.getDesc_ev());
                  pst.setString(4, t.getImage_ev());
                  pst.setObject(5, t.getId_user());
                  pst.setDate(6, DateEv);
                  pst.setString(7,t.getEtat() );
                  pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(event_service.class.getName()).log(Level.SEVERE, null, ex);
        
        }    }
    
   
        public List<evenement> read() {
                          String req;
        req = "select * from evenement ";
        //DemandeService ds = new DemandeService();
        //event_service es = new event_service();
        //ReservationService r = new ReservationService();
                CategorieEvService cs = new CategorieEvService();

        UtilisateurService us = new UtilisateurService();

                    List<evenement> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);

            while(rs.next()){
                list.add(new evenement(rs.getInt("id_evenement"), cs.readById(rs.getInt("id_Cat")), rs.getString("nom_evenement"),rs.getString("description"),rs.getString("image"),us.getByUserId(rs.getInt("id_utilisateur")),rs.getDate("date"),rs.getString("etat_evenement")));
            }   
            }
         catch (SQLException ex) {
  Logger.getLogger(event_service.class.getName()).log(Level.SEVERE, null, ex);         }
        return list;
 
   
    
}
public Map<String,Integer> readStat() {
      Map list=new HashMap<String,Integer>();
                          String req;
        req = "SELECT cat.type_evenement as type,count(*) as nbr FROM `evenement` as ev INNER join categorie_ev as cat on cat.id_Cat=ev.id_Cat group by cat.type_evenement";
        //DemandeService ds = new DemandeService();
        //event_service es = new event_service();
        //ReservationService r = new ReservationService();
                CategorieEvService cs = new CategorieEvService();

        UtilisateurService us = new UtilisateurService();

                  
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);

            while(rs.next()){
                list.put(rs.getString("type"),rs.getInt("nbr") );
            }   
            }
         catch (SQLException ex) {
  Logger.getLogger(event_service.class.getName()).log(Level.SEVERE, null, ex);         }
        return list;
 
   
    
}

    public void delete(int id) {
        String req = "DELETE FROM evenement WHERE id_evenement=?";
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(event_service.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void update(evenement t) {
        try{  
                  java.sql.Date DateEv = new java.sql.Date(t.getDate().getTime());
              
                  String req = "update evenement set id_Cat=? , nom_evenement=?,description=?,image=? , id_utilisateur=? , date=?  , etat_evenement=? where id_evenement=?";
                  pst = conn.prepareStatement(req);
                  pst.setObject(1,t.getId_categorie().getId_categorie());
                  pst.setString(2, t.getNom_ev());
                  pst.setString(3,t.getDesc_ev());
                  pst.setString(4, t.getImage_ev());
                  pst.setObject(5, t.getId_user());
                  pst.setDate(6, DateEv);
                  pst.setString(7, t.getEtat());
                  pst.setInt(8, t.getId_ev());
                  pst.executeUpdate();
                              pst.close();

                  
                  
                
             }catch(SQLException ex){ Logger.getLogger(event_service.class.getName()).log(Level.SEVERE, null, ex);}
    }

  
    public evenement readById(int id) {
        
    String req = "select * from evenement where id_evenement="+id;
        evenement e = new evenement();
        UtilisateurService us = new UtilisateurService();
        CategorieEvService cs = new CategorieEvService();

        

        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                e.setId_ev(rs.getInt("id_evenement"));
                e.setId_categorie(cs.readById(rs.getInt("id_Cat")));
                e.setNom_ev(rs.getString("nom_evenement"));
                e.setDesc_ev(rs.getString("description"));
                e.setImage_ev(rs.getString("image"));
                e.setId_user(us.getByUserId(rs.getInt("id_utilisateur")));
                e.setDate(rs.getDate("date"));
                e.setEtat(rs.getString("etat_evenement"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(event_service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;     
    }
    public evenement readByName(String name) {
        
    String req = "select * from evenement where nom_evenement LIKE '%"+name+"%'";
        evenement e = new evenement();
        UtilisateurService us = new UtilisateurService();
        CategorieEvService cs = new CategorieEvService();

        

        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                e.setId_ev(rs.getInt("id_evenement"));
                e.setId_categorie(cs.readById(rs.getInt("id_Cat")));
                e.setNom_ev(rs.getString("nom_evenement"));
                e.setDesc_ev(rs.getString("description"));
                e.setImage_ev(rs.getString("image"));
                e.setId_user(us.getByUserId(rs.getInt("id_utilisateur")));
                e.setDate(rs.getDate("date"));
                e.setEtat(rs.getString("etat_evenement"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(event_service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;     
    }
}
