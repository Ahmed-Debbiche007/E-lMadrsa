/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;
import javafx.scene.image.ImageView;

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
    private ImageView img;

    public User() {

    }

    public User(long l, String username, String role) {
        boolean c = false ; 
        this.idUtilisateur = l ; 
        this.nomUtilisateur = username ; 
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

    public Role getRole() {
        return role;
    }

    public User(Long idUtilisateur, String nomUtilisateur, String role) {
        boolean c = false;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
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

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasee(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
    
    

}