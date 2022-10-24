/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author User
 */
public class User {
    public Long idUser;
    private String nom ;
    private String prenom;

    public User() {
    }

    public User(Long idUser, String nom, String prenom) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(Long idUser, String nom) {
        this.idUser = idUser;
        this.nom = nom;
    }
    
    
    

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
    
    
    
}
