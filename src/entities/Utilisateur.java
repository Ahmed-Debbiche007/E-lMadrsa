/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author aissa
 */
public class Utilisateur {

    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String email;
    private String motDePasse;
    private Date dateNaissance ;
    private String image;
    
    
    

    public Utilisateur() {
        
    }

    public Utilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(Long idUtilisateur, String nom, String prenom, String nomUtilisateur, String email, String motDePasse, Date dateNaissance, String image) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.image = image;
    }

     public Utilisateur( String nom, String prenom, String nomUtilisateur, String email, String motDePasse, Date dateNaissance, String image) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.image = image;
    }

    public Long getId() {
        return idUtilisateur;
    }

    public void setId(long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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
    
    public String getnomUtilisateur() {
        return nomUtilisateur;
    }
    
    public void setnomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    public String getmotDePasse() {
        return motDePasse;
    }

    public void setmotDePasee(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    public Date getdateNaissance() {
        return dateNaissance;
    }

    public void setdateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ",nomUtilisateur=" + nomUtilisateur + ",email=" + email + "motDePasse=" + motDePasse + "dateNaissance=" + dateNaissance + "image=" + image+ '}';
    }

    public void setDateAcq(Date dateDB) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nour
 */

