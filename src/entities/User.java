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
    private Date dateNaissance;
    private String image;
    private Role role;
    private boolean approved;
    private Double Resultat ; 

    public User() {

    }

    public User(long l, String azaz, String student) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getRole() {
        return role.name();
    }
    
    

    public User(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public User(Long idUtilisateur, String nom, String prenom, String nomUtilisateur, String tel, String email, String motDePasse, Date dateNaissance, String image, String role, boolean approved) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.tel = tel;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.image = image;

        this.approved = approved;
        boolean c = false;
        for (Role t : Role.values()) {
            if (t.name().equals(role)) {
                this.role = t;
                c = true;
            }
        }
        if (!c) {
            System.out.println("erroRoler");
        }
    }
    
     public Double getResultat() {
        return Resultat;
    }

    public void setResultat(Double Resultat) {
        this.Resultat = Resultat;
    }

    public User(String nom, String prenom, String nomUtilisateur, String tel, String email, String motDePasse, Date dateNaissance, String image, String role, boolean approved) {

        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.tel = tel;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.image = image;
        this.approved = approved;
        boolean c = false;
        for (Role t : Role.values()) {
            if (t.name().equals(role)) {
                this.role = t;
                c = true;
            }
        }
        if (!c) {
            System.out.println("erroRoler");
        }
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

    public Role getrole() {
        return role;
    }

    public void setRole(String role) {
        boolean c = false;
        for (Role t : Role.values()) {
            if (t.name().equals(role)) {
                this.role = t;
                c = true;
            }
        }
        if (!c) {
            System.out.println("erroRoler");
        }
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "user{" + "idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", nomUtilisateur=" + nomUtilisateur + ", tel=" + tel + ", email=" + email + ", motDePasse=" + motDePasse + ", dateNaissance=" + dateNaissance + ", image=" + image + ", role=" + role + '}';
    }

}
