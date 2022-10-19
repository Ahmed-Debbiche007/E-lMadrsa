/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

import java.util.Date;

/**
 *
 * @author User
 */
public class Attestation {
    
    public Long idAttestation;
    private Long idParticipation ;
    private Date dateAcq; 

    public Attestation() {
    }

    public Attestation(Long idAttestation, Long idParticipation, Date dateAcq) {
        this.idAttestation = idAttestation;
        this.idParticipation = idParticipation;
        this.dateAcq = dateAcq;
    }

    public Attestation(Long idAttestation, Long idParticipation) {
        this.idAttestation = idAttestation;
        this.idParticipation = idParticipation;
    }
    

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

    @Override
    public String toString() {
        return "Attestation{" + "idAttestation=" + idAttestation + ", idParticipation=" + idParticipation + ", dateAcq=" + dateAcq + '}';
    }
    
    
}
