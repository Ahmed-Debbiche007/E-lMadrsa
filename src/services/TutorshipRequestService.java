/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entities.TutorshipRequest;
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
public class TutorshipRequestService implements GenericService<TutorshipRequest> {
    Connection cnx;
    
    public TutorshipRequestService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void add(TutorshipRequest t) {
          try {
            String req = "INSERT INTO requests(id_tutor_id,id_student_id,type,body,date) VALUES(?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1,t.getIdStudent());
            st.setLong(2, t.getIdTutor());
            st.setString(3, t.getRequestType().name());
            st.setString(4, t.getRequestBody());
            st.setTimestamp(5, t.getSessionDate());
            st.executeUpdate();
            System.out.println("Request added successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public void update(TutorshipRequest t) {
           try {
            String req = "UPDATE requests SET id_student_id=?, id_tutor_id=?, body=?, date=?, type=? WHERE id=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setLong(1,t.getIdStudent());
            st.setLong(2, t.getIdTutor());
            st.setString(3, t.getRequestBody());
            st.setTimestamp(4, t.getSessionDate());
            st.setString(5, t.getRequestType().name());
            st.setLong(6, t.getIdRequest());
            st.executeUpdate();
            System.out.println("Request modified successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public void delete(TutorshipRequest t) {
         try {
            String req = "DELETE FROM requests WHERE id="+t.getIdRequest();
            Statement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("Request deleted successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    @Override
    public ObservableList<TutorshipRequest> getAll() {
        ObservableList<TutorshipRequest> requests =FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM requests";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                TutorshipRequest t = new TutorshipRequest();
                t.setIdRequest(rs.getLong("id"));
                t.setIdStudent(rs.getLong("id_student_id"));
                t.setIdTutor(rs.getLong("id_tutor_id"));
                t.setRequestBody(rs.getString("body"));
                t.setSessionDate(rs.getTimestamp("date"));
                t.setRequestType(rs.getString("type"));
                requests.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return requests;
    }
    
    public String get (){
        return"Hello";
    }

    @Override
    public ObservableList<TutorshipRequest> getSingle(String query, int filter) {
        ObservableList<TutorshipRequest> requests = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM requests WHERE "+query+"="+filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                TutorshipRequest t = new TutorshipRequest();
                t.setIdRequest(rs.getLong("id"));
                t.setIdStudent(rs.getLong("id_student_id"));
                t.setIdTutor(rs.getLong("id_tutor_id"));
                t.setRequestBody(rs.getString("body"));
                t.setSessionDate(rs.getTimestamp("date"));
                t.setRequestType(rs.getString("type"));
                requests.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return requests;
    }

    @Override
    public ObservableList<TutorshipRequest> getSingle(String query, String filter) {
        ObservableList<TutorshipRequest> requests = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM requests WHERE "+query+"="+filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                TutorshipRequest t = new TutorshipRequest();
                t.setIdRequest(rs.getLong("id"));
                t.setIdStudent(rs.getLong("id_student_id"));
                t.setIdTutor(rs.getLong("id_tutor_id"));
                t.setRequestBody(rs.getString("body"));
                t.setSessionDate(rs.getTimestamp("date"));
                t.setRequestType(rs.getString("type"));
                requests.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return requests;
    }
    
    public ObservableList<TutorshipRequest> getList(String query, long filter) {
        ObservableList<TutorshipRequest> requests = FXCollections.observableArrayList();
        try {
            String req = "select user.nom, requests.*, u.nom as tutor from user join requests on requests.id_student_id=user.id join user as u on u.id=requests.id_tutor_id WHERE " + query + "=" + filter;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                TutorshipRequest t = new TutorshipRequest();
                t.setIdRequest(rs.getLong("id"));
                t.setIdStudent(rs.getLong("id_student_id"));
                t.setIdTutor(rs.getLong("id_tutor_id"));
                t.setRequestBody(rs.getString("body"));
                t.setSessionDate(rs.getTimestamp("date"));
                t.setRequestType(rs.getString("type"));
                t.setNomTut(rs.getString("tutor"));
                t.setNomStudent(rs.getString("nom"));
                requests.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return requests;
    }
    
}
