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
            String req = "INSERT INTO messages(idsession_id, idsender, body, statusDate) VALUES(?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1,t.getIdSession());
            st.setLong(2,t.getIdSender());
            st.setString(3, t.getMessage());
            st.setTimestamp(4, t.getStatusDate());
            st.executeUpdate();
            System.out.println("Message added successfully!");
        } catch (SQLException ex) {
            System.out.println("InsertError!");
            System.out.println(ex);
        }
    }

    @Override
    public void update(Messages t) {
       try {
             String req = "UPDATE messages SET idsession_id=?, idsender=?, body=? WHERE idmessage=?";
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
            String req = "SELECT * FROM messages";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                Messages t = new Messages();
                t.setIdMessage(rs.getLong("Idmessage"));
                t.setIdSession(rs.getLong("idsession_id"));
                t.setIdSender(rs.getLong("idsender"));
                t.setMessage(rs.getString("body"));
                t.setStatusDate(rs.getTimestamp("statusDate"));
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
       ObservableList<Messages> messages = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM messages WHERE idsession_id="+filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                Messages t = new Messages();
                t.setIdMessage(rs.getLong("Idmessage"));
                t.setIdSession(rs.getLong("idsession_id"));
                t.setIdSender(rs.getLong("idsender"));
                t.setMessage(rs.getString("body"));
                t.setStatusDate(rs.getTimestamp("statusDate"));
                messages.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("GetSingleError!");
            System.out.println(ex);
        }
        return messages;
    }

    @Override
    public ObservableList<Messages> getSingle(String query, String filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
