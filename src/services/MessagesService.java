/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Messages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/**
 *
 * @author ahmed
 */
public class MessagesService implements GenericService<Messages> {
    
    Connection cnx;
    
    public MessagesService(){
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void add(Messages t) {
       try {
            String req = "INSERT INTO messages(idSession, idSender, staus, body) VALUES(?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1,t.getIdSession());
            st.setLong(2,t.getIdSender());
            st.setString(3, t.getStatus().name());
            st.setString(4, t.getMessage());
            st.executeUpdate();
            System.out.println("Request added successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public void update(Messages t) {
       try {
             String req = "UPDATE messages SET idSession=?, idSender=?, staus=?, body=? WHERE idMessage=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1,t.getIdSession());
            st.setLong(2,t.getIdSender());
            st.setString(3, t.getStatus().name());
            st.setString(4, t.getMessage());
            st.setLong(5, t.getIdMessage());
            st.executeUpdate();
            System.out.println("Request added successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Messages t) {
        try {
            String req = "DELETE FROM messages WHERE idRequest="+t.getIdMessage();
            Statement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("Request deleted successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public ObservableList<Messages> getAll() {
        ObservableList<Messages> messages = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM requests";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                Messages t = new Messages();
                t.setIdMessage(rs.getLong("IdMessage"));
                t.setIdSession(rs.getLong("IdSession"));
                t.setIdSender(rs.getLong("idSender"));
                t.setMessage(rs.getString("body"));
                t.setStatus(rs.getString("status"));
                t.setStatusDate(rs.getDate("statusDate"));
                messages.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return messages;
    }

    @Override
    public ObservableList<Messages> getSingle(String query, int filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<Messages> getSingle(String query, String filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
