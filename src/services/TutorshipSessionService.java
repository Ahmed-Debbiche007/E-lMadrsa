/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.ChatSession;
import entities.TutorshipSession;
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
public class TutorshipSessionService implements GenericService<TutorshipSession> {

    Connection cnx;

    public TutorshipSessionService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void add(TutorshipSession t) {
        try {
            String req = "INSERT INTO tutorshipSessions(idStudent,idTutor,idRequest,url,type,date) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1, t.getIdStudent());
            st.setLong(2, t.getIdTutor());
            st.setLong(3, t.getIdRequest());
            st.setString(4, t.getUrl());
            st.setString(5, t.getType().name());
            st.setTimestamp(6, t.getDate());
            st.executeUpdate();
            System.out.println("Session added successfully!");
            if (t.getType().name() == "MessagesChat") {
                TutorshipSession ts = this.getLatest();
                ChatSessionService cs = new ChatSessionService();
                ChatSession session = new ChatSession(ts.getIdTutorshipSession());
                cs.add(session);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public void update(TutorshipSession t) {
        try {
            String req = "UPDATE tutorshipSessions SET idStudent=?, idTutor=?, idRequest=?, url=?, type=?, date=? WHERE idSession=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1, t.getIdStudent());
            st.setLong(2, t.getIdTutor());
            st.setLong(3, t.getIdRequest());
            st.setString(4, t.getUrl());
            st.setString(5, t.getType().name());
            st.setTimestamp(6, t.getDate());
            st.setLong(7, t.getIdTutorshipSession());
            st.executeUpdate();
            System.out.println("Request modified successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public void delete(TutorshipSession t) {
        try {
            String req = "DELETE FROM tutorshipSessions WHERE idSession=" + t.getIdTutorshipSession();
            Statement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("Request deleted successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public ObservableList<TutorshipSession> getAll() {
        ObservableList<TutorshipSession> tutorshipSessions = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM tutorshipSessions";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                TutorshipSession t = new TutorshipSession();
                t.setIdRequest(rs.getLong("idRequest"));
                t.setIdStudent(rs.getLong("idStudent"));
                t.setIdTutor(rs.getLong("idTutor"));
                t.setIdTutorshipSession(rs.getLong("idSession"));
                t.setUrl(rs.getString("url"));
                t.setDate(rs.getTimestamp("date"));
                t.setType(rs.getString("type"));
                tutorshipSessions.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return tutorshipSessions;
    }

    @Override
    public ObservableList<TutorshipSession> getSingle(String query, int filter) {
        ObservableList<TutorshipSession> tutorshipSessions = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM tutorshipSessions WHERE " + query + "=" + filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                TutorshipSession t = new TutorshipSession();
                t.setIdRequest(rs.getLong("idRequest"));
                t.setIdStudent(rs.getLong("idStudent"));
                t.setIdTutor(rs.getLong("idTutor"));
                t.setIdTutorshipSession(rs.getLong("idSession"));
                t.setUrl(rs.getString("url"));
                t.setDate(rs.getTimestamp("date"));
                t.setType(rs.getString("type"));
                tutorshipSessions.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return tutorshipSessions;
    }

    @Override
    public ObservableList<TutorshipSession> getSingle(String query, String filter) {
        ObservableList<TutorshipSession> tutorshipSessions = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM tutorshipSessions WHERE " + query + "=" + filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                TutorshipSession t = new TutorshipSession();
                t.setIdRequest(rs.getLong("idRequest"));
                t.setIdStudent(rs.getLong("idStudent"));
                t.setIdTutor(rs.getLong("idTutor"));
                t.setIdTutorshipSession(rs.getLong("idSession"));
                t.setUrl(rs.getString("url"));
                t.setDate(rs.getTimestamp("date"));
                t.setType(rs.getString("type"));
                tutorshipSessions.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return tutorshipSessions;
    }

    public TutorshipSession getLatest() {
        ObservableList<TutorshipSession> tutorshipSessions = FXCollections.observableArrayList();

        try {
            String req = "SELECT * FROM tutorshipSessions ORDER BY idSession DESC LIMIT 1 ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                TutorshipSession t = new TutorshipSession();
                t.setIdRequest(rs.getLong("idRequest"));
                t.setIdStudent(rs.getLong("idStudent"));
                t.setIdTutor(rs.getLong("idTutor"));
                t.setIdTutorshipSession(rs.getLong("idSession"));
                t.setUrl(rs.getString("url"));
                t.setDate(rs.getTimestamp("date"));
                t.setType(rs.getString("type"));
                return t;
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return null;
    }

    public ObservableList<TutorshipSession> getList(String query, int filter) {
        ObservableList<TutorshipSession> tutorshipSessions = FXCollections.observableArrayList();
        try {
            String req = "select users.nom, tutorshipSessions.*, u.nom as tutor from users join tutorshipSessions on tutorshipSessions.idStudent=users.id join users as u on u.id=tutorshipSessions.idTutor WHERE " + query + "=" + filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                TutorshipSession t = new TutorshipSession();
                t.setIdRequest(rs.getLong("idRequest"));
                t.setIdStudent(rs.getLong("idStudent"));
                t.setIdTutor(rs.getLong("idTutor"));
                t.setIdTutorshipSession(rs.getLong("idSession"));
                t.setUrl(rs.getString("url"));
                t.setDate(rs.getTimestamp("date"));
                t.setType(rs.getString("type"));
                t.setNomTut(rs.getString("tutor"));
                t.setNomStudent(rs.getString("nom"));
                tutorshipSessions.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return tutorshipSessions;
    }
}
