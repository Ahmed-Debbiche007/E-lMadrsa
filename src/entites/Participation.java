/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author User
 */
public class Participation {
    public Long idParticipation;
    private Long idUser;
    private Long idFormation;
    private double resultat;
    private String nom ;
    private String Prenom;
    private Date dateAcq;
    private String Sujet;
    private int nbParticipation;

    public Participation() {
    }

    public Participation(Long idParticipation, Long idUser, Long idFormation, double resultat) {
        this.idParticipation = idParticipation;
        this.idUser = idUser;
        this.idFormation = idFormation;
        this.resultat = resultat;
    }

    public Participation(Long idParticipation, Long idUser, Long idFormation, double resultat, String nom, String Prenom, Date dateAcq) {
        this.idParticipation = idParticipation;
        this.idUser = idUser;
        this.idFormation = idFormation;
        this.resultat = resultat;
        this.nom = nom;
        this.Prenom = Prenom;
        this.dateAcq = dateAcq;
    }

    public Participation(Long idParticipation, Long idUser, Long idFormation, double resultat, String nom, String Prenom) {
        this.idParticipation = idParticipation;
        this.idUser = idUser;
        this.idFormation = idFormation;
        this.resultat = resultat;
        this.nom = nom;
        this.Prenom = Prenom;
    }
     public Participation(Long idParticipation, Long idUser, Long idFormation, double resultat, String nom, String Prenom, String sujet) {
        this.idParticipation = idParticipation;
        this.idUser = idUser;
        this.idFormation = idFormation;
        this.resultat = resultat;
        this.nom = nom;
        this.Prenom = Prenom;
        this.Sujet=sujet;
    }

    public Participation(Long idParticipation, Long idUser, Long idFormation, double resultat, String Sujet, int nbParticipation) {
        this.idParticipation = idParticipation;
        this.idUser = idUser;
        this.idFormation = idFormation;
        this.resultat = resultat;
        this.Sujet = Sujet;
        this.nbParticipation = nbParticipation;
    }
     

    public Participation(Long idParticipation, Long idUser, Long idFormation, double resultat, String Sujet) {
        this.idParticipation = idParticipation;
        this.idUser = idUser;
        this.idFormation = idFormation;
        this.resultat = resultat;
        this.Sujet = Sujet;
    }
     
    
    

    public Long getIdParticipation() {
        return idParticipation;
    }
    

    public void setIdParticipation(Long idParticipation) {
        this.idParticipation = idParticipation;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public double getResultat() {
        return resultat;
    }

    public void setResultat(double resultat) {
        this.resultat = resultat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public Date getDateAcq() {
        return dateAcq;
    }

    public void setDateAcq(Date dateAcq) {
        this.dateAcq = dateAcq;
    }

    public String getSujet() {
        return Sujet;
    }

    public void setSujet(String Sujet) {
        this.Sujet = Sujet;
    }

    public int getNbParticipation() {
        return nbParticipation;
    }

    public void setNbParticipation(int nbParticipation) {
        this.nbParticipation = nbParticipation;
    }
    
    
    

    @Override
    public String toString() {
        return "Participation{" + "idParticipation=" + idParticipation + ", idUser=" + idUser + ", idFormation=" + idFormation + ", resultat=" + resultat + '}';
    }
    
    
    
    
    
}
