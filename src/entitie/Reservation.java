/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitie;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lmol
 */
public class Reservation {
    private int id_reservation;
    private Date dateReservation;
    private evenement id_ev;
    private User id_user;

    public Reservation( evenement id_ev, User id_user) {
        this.id_ev = id_ev;
        this.id_user = id_user;
    }
 public Reservation(int id_reservation,Date dateReservation, evenement id_ev, User id_user) {
     this.id_reservation=id_reservation;
        this.dateReservation = dateReservation;
        this.id_ev = id_ev;
        this.id_user = id_user;
    }

    public Reservation(int id_reservation, evenement id_ev, User id_user) {
        this.id_reservation = id_reservation;
        this.id_ev = id_ev;
        this.id_user = id_user;
    }

    public Reservation() {
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public evenement getId_ev() {
        return id_ev;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setId_ev(evenement id_ev) {
        this.id_ev = id_ev;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", dateReservation=" + dateReservation + ", id_ev=" + id_ev + ", id_user=" + id_user + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_reservation;
        hash = 89 * hash + Objects.hashCode(this.dateReservation);
       
        hash = 89 * hash + Objects.hashCode(this.id_user);
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
        final Reservation other = (Reservation) obj;
        if (this.id_reservation != other.id_reservation) {
            return false;
        }
        if (this.id_ev != other.id_ev) {
            return false;
        }
        if (!Objects.equals(this.dateReservation, other.dateReservation)) {
            return false;
        }
        return Objects.equals(this.id_user, other.id_user);
    }
    
    
    
}
