/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmed
 */
public class TutorshipSession {

    long idTutorshipSession, idTutor, idStudent, idRequest;
    String url, body;
    RequestType type;
    Timestamp date;
    private String nomTut, nomStudent;

    public TutorshipSession() {
    }

    public TutorshipSession(long idTutor, long idStudent, long idRequest, String url, RequestType type, Timestamp date) {
        this.idTutor = idTutor;
        this.idStudent = idStudent;
        this.idRequest = idRequest;
        this.url = url;
        this.type = type;
        this.date = date;
    }
    
    
    
    public TutorshipSession(long idTutor, long idStudent, long idRequest, String url, RequestType type, Timestamp date, String stud, String tut) {
        this.idTutor = idTutor;
        this.idStudent = idStudent;
        this.idRequest = idRequest;
        this.url = url;
        this.type = type;
        this.date = date;
        this.nomStudent=stud;
        this.nomTut=tut;
    }

    public TutorshipSession(long idTutorshipSession, long idTutor, long idStudent, long idRequest, String url, String type, Timestamp date) {
        boolean c = false;
        this.idTutorshipSession = idTutorshipSession;
        this.idTutor = idTutor;
        this.idStudent = idStudent;
        this.idRequest = idRequest;
        this.url = url;
        this.date = date;
        for (RequestType t : RequestType.values()) {
            if (t.name().equals(type)) {
                this.type = t;
                c = true;
            }
        }
    }

    public long getIdTutorshipSession() {
        return idTutorshipSession;
    }

    public long getIdTutor() {
        return idTutor;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public long getIdRequest() {
        return idRequest;
    }

    public String getUrl() {
        return url;
    }

    public void setIdTutorshipSession(long idTutorshipSession) {
        this.idTutorshipSession = idTutorshipSession;
    }

    public void setIdTutor(long idTutor) {
        this.idTutor = idTutor;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public void setIdRequest(long idRequest) {
        this.idRequest = idRequest;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RequestType getType() {
        return type;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setType(String requestType) {
        boolean c = false;
        for (RequestType t : RequestType.values()) {
            if (t.name().equals(requestType)) {
                this.type = t;
                c = true;
            }
        }
        if (!c) {
            System.out.println("Error!");
        }
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TutorshipSession{" + "idTutorshipSession=" + idTutorshipSession + ", idTutor=" + idTutor + ", idStudent=" + idStudent + ", idRequest=" + idRequest + ", url=" + url + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.idTutorshipSession ^ (this.idTutorshipSession >>> 32));
        hash = 89 * hash + (int) (this.idTutor ^ (this.idTutor >>> 32));
        hash = 89 * hash + (int) (this.idStudent ^ (this.idStudent >>> 32));
        hash = 89 * hash + (int) (this.idRequest ^ (this.idRequest >>> 32));
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
        final TutorshipSession other = (TutorshipSession) obj;
        if (this.idTutorshipSession != other.idTutorshipSession) {
            return false;
        }
        if (this.idTutor != other.idTutor) {
            return false;
        }
        if (this.idStudent != other.idStudent) {
            return false;
        }
        return this.idRequest == other.idRequest;
    }

    public List<String> decompose() {
        List<String> dates = new ArrayList<String>();
        String date = this.date.toLocalDateTime().toLocalDate().toString();
        String h = this.date.toString().split(" ")[1].split(":")[0];
        String m = this.date.toString().split(" ")[1].split(":")[1];
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
    

}
