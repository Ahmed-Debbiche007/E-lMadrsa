/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ahmed
 */
public class ChatSession {
    long idChatSession, idTutorshipSession;

    public ChatSession() {
    }

    public ChatSession(long idTutorshipSession) {
        this.idTutorshipSession = idTutorshipSession;
    }
    
    public ChatSession(long idChatSession, long idTutorshipSession) {
        this.idTutorshipSession = idTutorshipSession;
        this.idChatSession= idChatSession;
    }

    public long getIdChatSession() {
        return idChatSession;
    }
    
     public void setIdChatSession(long idChatSession) {
        this.idChatSession = idChatSession;
    }

    public long getIdTutorshipSession() {
        return idTutorshipSession;
    }

    public void setIdTutorshipSession(long idTutorshipSession) {
        this.idTutorshipSession = idTutorshipSession;
    }

    @Override
    public String toString() {
        return "ChatSession{" + "idChatSession=" + idChatSession + ", idTutorshipSession=" + idTutorshipSession + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.idChatSession ^ (this.idChatSession >>> 32));
        hash = 23 * hash + (int) (this.idTutorshipSession ^ (this.idTutorshipSession >>> 32));
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
        final ChatSession other = (ChatSession) obj;
        if (this.idChatSession != other.idChatSession) {
            return false;
        }
        return this.idTutorshipSession == other.idTutorshipSession;
    }
    
    
    
}
