/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.scene.control.TextArea;

/**
 *
 * @author ahmed
 */
public class TutorshipRequest {
        long idRequest, idStudent, idTutor;
        String requestBody, nomTut, nomStudent;
        RequestType requestType;
        Timestamp sessionDate;

    public TutorshipRequest(long idStudent, long idTutor, String requestBody, String requestType, Timestamp sessionDate) {
        boolean c = false;
        this.idStudent = idStudent;
        this.idTutor = idTutor;
        this.requestBody = requestBody;
        this.sessionDate = sessionDate;
        for (RequestType t : RequestType.values()) {
        if (t.name().equals(requestType)) {
           this.requestType = t;
           c= true;
        }
    }
        if (!c){
            System.out.println("Error!");
        }
    }
    
    public TutorshipRequest(long idRequest, long idStudent, long idTutor, String requestBody, String requestType, Timestamp sessionDate) {
        boolean c = false;
        this.idRequest = idRequest;
        this.idStudent = idStudent;
        this.idTutor = idTutor;
        this.requestBody = requestBody;
        this.sessionDate = sessionDate;
        for (RequestType t : RequestType.values()) {
        if (t.name().equals(requestType)) {
           this.requestType = t;
           c= true;
        }
    }
        if (!c){
            System.out.println("Error!");
        }
    }

    public TutorshipRequest() {
   
    }


    public long getIdRequest() {
        return idRequest;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public long getIdTutor() {
        return idTutor;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public Timestamp getSessionDate() {
        return sessionDate;
    }

    public void setIdRequest(long idRequest) {
        this.idRequest = idRequest;
    }
    
    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public void setIdTutor(long idTutor) {
        this.idTutor = idTutor;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    
    public void setRequestType(String requestType) {
        boolean c = false;
        for (RequestType t : RequestType.values()) {
        if (t.name().equals(requestType)) {
           this.requestType = t;
           c= true;
        }
    }
        if (!c){
            System.out.println("Error!");
        }
    }

    public void setSessionDate(Timestamp sessionDate) {
        this.sessionDate = sessionDate;
    }

    @Override
    public String toString() {
        return "TutorshipRequest{" + "idRequest=" + idRequest + ", idStudent=" + idStudent + ", idTutor=" + idTutor + ", requestBody=" + requestBody + ", requestType=" + requestType + ", sessionDate=" + sessionDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.idRequest ^ (this.idRequest >>> 32));
        hash = 67 * hash + (int) (this.idStudent ^ (this.idStudent >>> 32));
        hash = 67 * hash + (int) (this.idTutor ^ (this.idTutor >>> 32));
        hash = 67 * hash + Objects.hashCode(this.sessionDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TutorshipRequest other = (TutorshipRequest) obj;
        if (this.idRequest != other.idRequest) {
            return false;
        }
        if (this.idStudent != other.idStudent) {
            return false;
        }
        if (this.idTutor != other.idTutor) {
            return false;
        }
        return Objects.equals(this.sessionDate, other.sessionDate);
    }
    
    public List<String> decompose(){
      List<String> dates  = new  ArrayList<String>();
      String date = this.sessionDate.toLocalDateTime().toLocalDate().toString();
      String h = this.sessionDate.toString().split(" ")[1].split(":")[0];
      String m= this.sessionDate.toString().split(" ")[1].split(":")[1];
      dates.add(date);
      dates.add(h);
      dates.add(m);
      return dates;
    }

    public String getNomTut() {
        return nomTut;
    }

    public void setNomTut(String nomTut) {
        this.nomTut = nomTut;
    }

    public String getNomStudent() {
        return nomStudent;
    }

    public void setNomStudent(String nomStudent) {
        this.nomStudent = nomStudent;
    }
        
        
    
}
