/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Msi
 */
public class Examen {
    
   private Long idExamen ; 
   private String nomExamen ;  
   private Double pourcentage  ; 
   private int DureeExamen ;  
   private Long formationId ;
   private Long idCategorie ;
   private String nomCat  ;
   private  String nomFor ; 

   
   
   
   
       public Examen() {}
       
    public Examen(Long idExamen, String nomExamen, Double pourcentage, int DureeExamen) {
        this.idExamen = idExamen;
        this.nomExamen = nomExamen;
        this.pourcentage = pourcentage;
        this.DureeExamen = DureeExamen;
    }
           
       public Examen( String nomExamen, Double pourcentage, int DureeExamen) {
        this.nomExamen = nomExamen;
        this.pourcentage = pourcentage;
        this.DureeExamen = DureeExamen;
    }

    public Examen(Long idExamen, String nomExamen, Double pourcentage, int DureeExamen, Long formationId, Long idCategorie) {
        this.idExamen = idExamen;
        this.nomExamen = nomExamen;
        this.pourcentage = pourcentage;
        this.DureeExamen = DureeExamen;
        this.formationId = formationId;
        this.idCategorie = idCategorie;
    }

    public Examen(String nomExamen, Double pourcentage, int DureeExamen, Long formationId, Long idCategorie) {
        this.nomExamen = nomExamen;
        this.pourcentage = pourcentage;
        this.DureeExamen = DureeExamen;
        this.formationId = formationId;
        this.idCategorie = idCategorie;
    }

    public String getNomCat() {
        return nomCat;
    }

    public String getNomFor() {
        return nomFor;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public void setNomFor(String nomFor) {
        this.nomFor = nomFor;
    }

 
       
       

    public Long getIdExamen() {
        return idExamen;
    }

    public String getNomExamen() {
        return nomExamen;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

    public int getDureeExamen() {
        return DureeExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public void setDureeExamen(int DureeExamen) {
        this.DureeExamen = DureeExamen;
    }

    public Long getFormationId() {
        return formationId;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setFormationId(Long formationId) {
        this.formationId = formationId;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    
    
    @Override
    public String toString() {
        return "Examen{" + "idExamen=" + idExamen + ", nomExamen=" + nomExamen + ", pourcentage=" + pourcentage + ", DureeExamen=" + DureeExamen + ", formationId=" + formationId + ", idCategorie=" + idCategorie + '}';
    }

 

}
