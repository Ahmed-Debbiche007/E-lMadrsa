/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.ChatSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/**
 *
 * @author ahmed
 */
public class ChatSessionService implements GenericService<ChatSession> {
    Connection cnx;
    public ChatSessionService (){
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void add(ChatSession t) {
         try {
            String req = "INSERT INTO chatSessions(idTutorshipSession) VALUES(?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1,t.getIdTutorshipSession());
            st.executeUpdate();
            System.out.println("Chat added successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public void update(ChatSession t) {
        try {
           String req = "UPDATE chatSessions SET idTutorshipSession=? WHERE idSession=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1,t.getIdTutorshipSession());
            st.setLong(2,t.getIdChatSession());
            st.executeUpdate();
            System.out.println("Request added successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public void delete(ChatSession t) {
        try {
            String req = "DELETE FROM chatSessions WHERE idSession="+t.getClass();
            Statement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("Request deleted successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public ObservableList<ChatSession> getAll() {
       ObservableList<ChatSession> tutorshipSessions = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM chatSessions";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                ChatSession t = new ChatSession();
                t.setIdChatSession(rs.getLong("idSession"));
                t.setIdTutorshipSession(rs.getLong("idTutorshipSession"));
                
                tutorshipSessions.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return tutorshipSessions;
    }

    @Override
    public ObservableList<ChatSession> getSingle(String query, int filter) {
      ObservableList<ChatSession> chatSessions = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM chatSessions WHERE "+query+"="+filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                ChatSession t = new ChatSession();
                t.setIdChatSession(rs.getLong("idSession"));
                t.setIdTutorshipSession(rs.getLong("idTutorshipSession"));
                chatSessions.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return chatSessions;
    }

    @Override
    public ObservableList<ChatSession> getSingle(String query, String filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ChatSession getSession(String query, int filter) {
        try {
            String req = "SELECT * FROM chatSessions WHERE "+query+"="+filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                ChatSession t = new ChatSession();
                t.setIdChatSession(rs.getLong("idSession"));
                t.setIdTutorshipSession(rs.getLong("idTutorshipSession"));
                return t;
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return null;
    }
    
}
