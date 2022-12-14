/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import Controller.QRcodeController;
import entities.Reservation;
import entities.evenement;
import java.io.File;
import java.io.IOException;
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
public class ReservationService {
    
    
    private final Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public ReservationService(){
    
        conn = MyDB.getInstance().getCnx();
    }

   
    public void insert(Reservation t) {
        
        String req;
             

        
        try {
                  req = " insert into reservation (date_reservation, id_evenement,id_utilisateur) values (now(),?,?)";
                  pst = conn.prepareStatement(req);
                  pst.setInt(2, 1);
                  pst.setInt(1, t.getId_ev().getId_ev());
                  pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        
        }

    public void delete(int id) {
  
        String req = "DELETE FROM reservation WHERE id_reservation=?";
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


    public void update(Reservation t) {

        try{  
                   
              
                  String req = "update reservation set  date_reservation=now(),id_evenement=?,id_utilisateur=? where id_reservation=?";
                  pst = conn.prepareStatement(req);
                  
                  pst.setInt(1, t.getId_ev().getId_ev());
                  pst.setInt(2, (int) (long) t.getId_user().getId());
                  pst.setInt(3, t.getId_reservation());
                  pst.executeUpdate();
                              pst.close();

                  
                  
                
             }catch(SQLException ex){ Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);}
    
    }


    public List<Reservation> read() {
        String req;
        req = "select * from reservation ";
        
        UtilisateurService us = new UtilisateurService();
        event_service ev = new event_service();

                    List<Reservation> list=new ArrayList<>();
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);

            while(rs.next()){
                list.add(new Reservation(rs.getInt("id_reservation"), rs.getDate("date_reservation"), (evenement) ev.readById(rs.getInt("id_evenement")),us.getByUserId(rs.getInt("id_utilisateur"))));
            }
                
                
            }
         catch (SQLException ex) {
  Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);         }
        return list;    
    }
    
    public Reservation getLatest() {
        String req;
        req = "select * from reservation order by id_reservation desc limit 1";
        
        UtilisateurService us = new UtilisateurService();
        event_service ev = new event_service();

 
        try {
            ste=conn.createStatement();
            rs= ste.executeQuery(req);

            while(rs.next()){
                Reservation res = new Reservation(rs.getInt("id_reservation"), rs.getDate("date_reservation"), (evenement) ev.readById(rs.getInt("id_evenement")),us.getByUserId(rs.getInt("id_utilisateur")));
                System.out.println(rs.toString());
                return res;
                
            }
                
                
            }
         catch (SQLException ex) {
  Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);         }
        return null;   
    }


    public Reservation readById(int id) {
    
        String req = "select * from reservation where id_reservation="+id;
        Reservation r = new Reservation();
        UtilisateurService us = new UtilisateurService();
        event_service ev = new event_service();
        
        

        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                r.setId_reservation(rs.getInt("id_reservation"));
                r.setDateReservation(rs.getDate("date_reservation"));
                r.setId_ev(ev.readById(rs.getInt("id_evenement")) );
                r.setId_user(us.getByUserId(rs.getInt("id_utilisateur")));
               
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
     public Reservation readByName(String name) {
    
        String req = "select * from reservation where id_reservation LIKE '%"+name+"%'";
        Reservation r = new Reservation();
        UtilisateurService us = new UtilisateurService();
        event_service ev = new event_service();
        
        

        try {
            ste = conn.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                r.setId_reservation(rs.getInt("id_reservation"));
                r.setDateReservation(rs.getDate("date_reservation"));
                r.setId_ev(ev.readById(rs.getInt("id_evenement")) );
                r.setId_user(us.getByUserId(rs.getInt("id_utilisateur")));
               
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public void readQR(int id){
    ReservationService ts = new ReservationService();
//        event_service es = new event_service();
        Reservation rs=ts.readById(id);
        System.out.println(ts.readById(id));
        String data = rs.toString();
        String path = System.getProperty("user.dir")+"/src/images/eve"+id+".jpg";
        
        BitMatrix mx = null;
        try {
            mx = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
                        
        } catch (WriterException ex) {
            Logger.getLogger(QRcodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            MatrixToImageWriter.writeToFile(mx, "jpg", new File(path) );
        } catch (IOException ex) {
            Logger.getLogger(QRcodeController.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    
}
