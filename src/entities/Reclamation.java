/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;

/**
 *
 * @author Msi
 */
public class Reclamation {
    
    private Long idReclamation ; 
    private String sujet ; 
    private String Description ; 
    private Date dateRec ; 
    private Long UserId ; 
    private Long UserNom  ;

    public Reclamation(Long idReclamation, String sujet, String Description, Date dateRec, Long UserId) {
        this.idReclamation = idReclamation;
        this.sujet = sujet;
        this.Description = Description;
        this.dateRec = dateRec;
        this.UserId = UserId;
    }

    public Reclamation(Long idReclamation, String sujet, String Description, Date dateRec, Long UserId, Long UserNom) {
        this.idReclamation = idReclamation;
        this.sujet = sujet;
        this.Description = Description;
        this.dateRec = dateRec;
        this.UserId = UserId;
        this.UserNom = UserNom;
    }

    public Reclamation(String sujet, String Description, Date dateRec, Long UserId) {
        this.sujet = sujet;
        this.Description = Description;
        this.dateRec = dateRec;
        this.UserId = UserId;
    }

    public Reclamation(String sujet, String Description, Date dateRec) {
        this.sujet = sujet;
        this.Description = Description;
        this.dateRec = dateRec;
    }

    public Long getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Long idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDateRec() {
        return dateRec;
    }

    public void setDateRec(Date dateRec) {
        this.dateRec = dateRec;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public Long getUserNom() {
        return UserNom;
    }

    public void setUserNom(Long UserNom) {
        this.UserNom = UserNom;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", sujet=" + sujet + ", Description=" + Description + ", dateRec=" + dateRec + ", UserId=" + UserId + ", UserNom=" + UserNom + '}';
    }
    
    
    
    
    
    
}
