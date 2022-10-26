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
public class User {
   private int id_user;
   private String nom;
   private String prenom;
   private String nomUtilisateur;
   private String tel;
   private String email;
   private String motDePasse;
   private Date dateNaissance ;
   private String image;

    public User() {
    }

    public User(int id_user) {
        this.id_user = id_user;
    }

    public User(int id_user, String nom, String prenom, String nomUtilisateur, String tel, String email, String motDePasse, Date dateNaissance, String image) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.tel = tel;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.image = image;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getImage() {
        return image;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return " " + nom ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id_user;
        hash = 11 * hash + Objects.hashCode(this.nom);
        hash = 11 * hash + Objects.hashCode(this.prenom);
        hash = 11 * hash + Objects.hashCode(this.nomUtilisateur);
        hash = 11 * hash + Objects.hashCode(this.tel);
        hash = 11 * hash + Objects.hashCode(this.email);
        hash = 11 * hash + Objects.hashCode(this.motDePasse);
        hash = 11 * hash + Objects.hashCode(this.dateNaissance);
        hash = 11 * hash + Objects.hashCode(this.image);
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
        final User other = (User) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.nomUtilisateur, other.nomUtilisateur)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.motDePasse, other.motDePasse)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return Objects.equals(this.dateNaissance, other.dateNaissance);
    }
   
   

}