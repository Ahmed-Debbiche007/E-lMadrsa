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

    public Participation(Long idUser, Long idFormation) {
        this.idUser = idUser;
        this.idFormation = idFormation;
    }

    public Participation(Double resultat, Long idUser, Long idFormation) {
        this.resultat = resultat;
        this.idUser = idUser;
        this.idFormation = idFormation;
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

    @Override
    public String toString() {
        return "Participation{" + "idParticipation=" + idParticipation + ", resultat=" + resultat + ", idUser=" + idUser + ", idFormation=" + idFormation + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}




 	
