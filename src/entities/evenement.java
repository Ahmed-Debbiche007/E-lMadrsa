/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lmol
 */
public class evenement {
    private int id_ev;
    private CategorieEv id_categorie;
    private String nom_ev;
    private String desc_ev;
    private String image_ev;
    private User id_user;
    private Date date; 
    private String etat;

    public evenement() {
    }

    public evenement(int id_ev, CategorieEv id_categorie, String nom_ev, String desc_ev, String image_ev, User id_user, Date date, String etat) {
        this.id_ev = id_ev;
        this.id_categorie = id_categorie;
        this.nom_ev = nom_ev;
        this.desc_ev = desc_ev;
        this.image_ev = image_ev;
        this.id_user = id_user;
        this.date = date;
        this.etat = etat;
    }

    public int getId_ev() {
        return id_ev;
    }

    public evenement(CategorieEv id_categorie, String nom_ev, String desc_ev, String image_ev, User id_user, Date date, String etat) {
        this.id_categorie = id_categorie;
        this.nom_ev = nom_ev;
        this.desc_ev = desc_ev;
        this.image_ev = image_ev;
        this.id_user = id_user;
        this.date = date;
        this.etat = etat;
    }

    public CategorieEv getId_categorie() {
        return id_categorie;
    }

    public String getNom_ev() {
        return nom_ev;
    }

    public String getDesc_ev() {
        return desc_ev;
    }

    public String getImage_ev() {
        return image_ev;
    }

    public User getId_user() {
        return id_user;
    }

    public Date getDate() {
        return date;
    }

    public String getEtat() {
        return etat;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public void setId_categorie(CategorieEv id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setNom_ev(String nom_ev) {
        this.nom_ev = nom_ev;
    }

    public void setDesc_ev(String desc_ev) {
        this.desc_ev = desc_ev;
    }

    public void setImage_ev(String image_ev) {
        this.image_ev = image_ev;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return nom_ev;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id_ev;
        hash = 83 * hash + Objects.hashCode(this.id_categorie);
        hash = 83 * hash + Objects.hashCode(this.nom_ev);
        hash = 83 * hash + Objects.hashCode(this.desc_ev);
        hash = 83 * hash + Objects.hashCode(this.image_ev);
        hash = 83 * hash + Objects.hashCode(this.id_user);
        hash = 83 * hash + Objects.hashCode(this.date);
        hash = 83 * hash + Objects.hashCode(this.etat);
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
        final evenement other = (evenement) obj;
        if (this.id_ev != other.id_ev) {
            return false;
        }
        if (!Objects.equals(this.nom_ev, other.nom_ev)) {
            return false;
        }
        if (!Objects.equals(this.desc_ev, other.desc_ev)) {
            return false;
        }
        if (!Objects.equals(this.image_ev, other.image_ev)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.id_categorie, other.id_categorie)) {
            return false;
        }
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    
}