/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;

/**
 *
 * @author ahmed
 */
public class Messages {

    long idMessage, idSession, idSender;
    String Message;
    Status status;
    Date statusDate;

    public Messages() {
    }

    public Messages(long idSession, long idSender, String Message, Status status, Date statusDate) {
        this.idSession = idSession;
        this.idSender = idSender;
        this.Message = Message;
        this.status = status;
        this.statusDate = statusDate;
    }

    public long getIdMessage() {
        return idMessage;
    }

    public long getIdSession() {
        return idSession;
    }

    public long getIdSender() {
        return idSender;
    }

    public String getMessage() {
        return Message;
    }

    public Status getStatus() {
        return status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setIdMessage(long idMessage) {
        this.idMessage = idMessage;
    }

    public void setIdSession(long idSession) {
        this.idSession = idSession;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setStatus(String status) {
        boolean c = false;
        for (Status t : Status.values()) {
            if (t.name().equals(status)) {
                this.status = t;
                c = true;
            }
        }
        if (!c) {
            System.out.println("Error!");
        }
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "Messages{" + "idMessage=" + idMessage + ", idSession=" + idSession + ", idSender=" + idSender + ", Message=" + Message + ", status=" + status + ", statusDate=" + statusDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.idMessage ^ (this.idMessage >>> 32));
        hash = 29 * hash + (int) (this.idSession ^ (this.idSession >>> 32));
        hash = 29 * hash + (int) (this.idSender ^ (this.idSender >>> 32));
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
        final Messages other = (Messages) obj;
        if (this.idMessage != other.idMessage) {
            return false;
        }
        if (this.idSession != other.idSession) {
            return false;
        }
        return this.idSender == other.idSender;
    }

}
