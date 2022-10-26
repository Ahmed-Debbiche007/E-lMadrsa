/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

public class Participation {
    private Long idParticipation ;
    private Double    resultat ; 
    private Long idUser ; 
    private Long idFormation ;
    private String nomUser ; 
    private String nomFormation ;
    private String nom ;
    private String Prenom;
    private String Sujet;
    private int nbParticipation;

    public Participation(Long idParticipation, Double resultat, Long idUser, Long idFormation) {
        this.idParticipation = idParticipation;
        this.resultat = resultat;
        this.idUser = idUser;
        this.idFormation = idFormation;
    }

    public Participation(Long idParticipation, Double resultat) {
        this.idParticipation = idParticipation;
        this.resultat = resultat;
    }
    public Participation(Long idParticipation, Long idUser, Long idFormation, double resultat, String Sujet, int nbParticipation) {
        this.idParticipation = idParticipation;
        this.idUser = idUser;
        this.idFormation = idFormation;
        this.resultat = resultat;
        this.Sujet = Sujet;
        this.nbParticipation = nbParticipation;
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

    public Participation(Long idUser, Long idFormation) {
        this.idUser = idUser;
        this.idFormation = idFormation;
    }

    public Participation(Double resultat, Long idUser, Long idFormation) {
        this.resultat = resultat;
        this.idUser = idUser;
        this.idFormation = idFormation;
    }
    public Participation(Long idParticipation, Long idUser, Long idFormation, double resultat, String Sujet) {
        this.idParticipation = idParticipation;
        this.idUser = idUser;
        this.idFormation = idFormation;
        this.resultat = resultat;
        this.Sujet = Sujet;
    }

    public Participation(Double resultat) {
        this.resultat = resultat;
    }

    public Participation() {
     }

    public Long getIdParticipation() {
        return idParticipation;
    }

    public Double getResultat() {
        return resultat;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdParticipation(Long idParticipation) {
        this.idParticipation = idParticipation;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
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
        return "Participation{" + "idParticipation=" + idParticipation + ", resultat=" + resultat + ", idUser=" + idUser + ", idFormation=" + idFormation + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}




 	
