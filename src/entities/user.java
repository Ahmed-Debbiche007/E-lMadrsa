/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Nour
 */
public class User {
    
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String tel;
    private String email;
    private String motDePasse;
    private Date dateNaissance ;
    private String image;
    private String role;
    
    

    public User() {
        
    }

    public User(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public User(Long idUtilisateur, String nomUtilisateur, String role) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.role = role;
    }
    

    public User(Long idUtilisateur, String nom, String prenom, String nomUtilisateur,String tel, String email, String motDePasse, Date dateNaissance, String image, String role) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.tel = tel;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.image = image;
        this.role = role;
    }

     public User( String nom, String prenom, String nomUtilisateur,String tel, String email, String motDePasse, Date dateNaissance, String image , String role) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.tel = tel;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.image = image;
        this.role = role;
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
    
    public String gettel() {
        return tel;
    }

    public void settel(String tel) {
        this.tel = tel;
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
    
    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "user{" + "idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", nomUtilisateur=" + nomUtilisateur + ", tel=" + tel + ", email=" + email + ", motDePasse=" + motDePasse + ", dateNaissance=" + dateNaissance + ", image=" + image +", role=" + role + '}';
    }

   


    
}