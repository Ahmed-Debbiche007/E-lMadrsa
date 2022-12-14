/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

import entities.Participation;
import java.util.Date;

/**
 *
 * @author User
 */
public class Attestation {
    
    public Long idAttestation;
    private Long idParticipation ;
    private Date dateAcq; 
    private int participation;
    private String nom, prenom;

    public Long getIdAttestation() {
        return idAttestation;
    }

    public void setIdAttestation(Long idAttestation) {
        this.idAttestation = idAttestation;
    }

    public Long getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(Long idParticipation) {
        this.idParticipation = idParticipation;
    }

    public Date getDateAcq() {
        return dateAcq;
    }

    public void setDateAcq(Date dateAcq) {
        this.dateAcq = dateAcq;
    }

    public int getParticipation() {
        return participation;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }

    public Attestation() {
    }

    public Attestation(Long idAttestation, Long idParticipation, Date dateAcq, int participation) {
        this.idAttestation = idAttestation;
        this.idParticipation = idParticipation;
        this.dateAcq = dateAcq;
        this.participation = participation;
    }

    public Attestation(Long idParticipation, Date dateAcq, int participation) {
        this.idParticipation = idParticipation;
        this.dateAcq = dateAcq;
        this.participation = participation;
    }

    public Attestation(Long idParticipation, Date dateAcq) {
        this.idParticipation = idParticipation;
        this.dateAcq = dateAcq;
    }
    
    public Attestation(Long idAttestation, Long idParticipation, Date dateAcq) {
        this.idAttestation = idAttestation;
        this.idParticipation = idParticipation;
        this.dateAcq = dateAcq;
    }
    
     public Attestation(Long idAttestation, Long idParticipation, Date dateAcq, String nom, String prenom) {
        this.idAttestation = idAttestation;
        this.idParticipation = idParticipation;
        this.dateAcq = dateAcq;
        this.nom = nom;
        this.prenom= prenom;
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
        return "Attestation{" + "idAttestation=" + idAttestation + ", idParticipation=" + idParticipation + ", dateAcq=" + dateAcq + ", participation=" + participation + '}';
    }
    
    
    
      
}
