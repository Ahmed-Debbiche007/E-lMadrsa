/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author User
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

    public Examen(Long idExamen, String nomExamen, Double pourcentage, int DureeExamen, Long formationId, Long idCategorie, String nomCat, String nomFor) {
        this.idExamen = idExamen;
        this.nomExamen = nomExamen;
        this.pourcentage = pourcentage;
        this.DureeExamen = DureeExamen;
        this.formationId = formationId;
        this.idCategorie = idCategorie;
        this.nomCat = nomCat;
        this.nomFor = nomFor;
    }

    public Examen(String nomExamen, Double pourcentage, int DureeExamen, Long formationId, Long idCategorie, String nomCat, String nomFor) {
        this.nomExamen = nomExamen;
        this.pourcentage = pourcentage;
        this.DureeExamen = DureeExamen;
        this.formationId = formationId;
        this.idCategorie = idCategorie;
        this.nomCat = nomCat;
        this.nomFor = nomFor;
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

    public Examen(Long idExamen, String nomExamen) {
        this.idExamen = idExamen;
        this.nomExamen = nomExamen;
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
