/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

/**
 *
 * @author User
 */
public class Formation {
    public Long idFormation ; 
    private String sujet ;
    private String description ;
    private String difficulté ; 
    private int durée ; 
    private Long idPrerequis; 
    private Long idCompetence; 
    private Long idCategorie ;
    private Long idExamen;
    private String nomCategorie;
    private String nomCompetence;
    private String nomPrerequis;
    private String nomExamen ; 
    

    public Formation() {
    }

    public Formation(Long idFormation, String sujet, String description, String difficulté, int durée, Long idPrerequis, Long idCompetence, Long idCategorie) {
        this.idFormation = idFormation;
        this.sujet = sujet;
        this.description = description;
        this.difficulté = difficulté;
        this.durée = durée;
        this.idPrerequis = idPrerequis;
        this.idCompetence = idCompetence;
        this.idCategorie = idCategorie;
    }

    public Formation(Long idFormation, String sujet, String description, String difficulté, int durée, Long idPrerequis, Long idCompetence, Long idCategorie, Long idExamen) {
        this.idFormation = idFormation;
        this.sujet = sujet;
        this.description = description;
        this.difficulté = difficulté;
        this.durée = durée;
        this.idPrerequis = idPrerequis;
        this.idCompetence = idCompetence;
        this.idCategorie = idCategorie;
        this.idExamen = idExamen;
    }
    public Formation(Long idFormation, String sujet, String description, String difficulté, int durée, Long idPrerequis, Long idCompetence, Long idCategorie, Long idExamen, String nomCategorie,String nomCompetence) {
        this.idFormation = idFormation;
        this.sujet = sujet;
        this.description = description;
        this.difficulté = difficulté;
        this.durée = durée;
        this.idPrerequis = idPrerequis;
        this.idCompetence = idCompetence;
        this.idCategorie = idCategorie;
        this.idExamen = idExamen;
        this.nomCategorie=nomCategorie;
        this.nomCompetence=nomCompetence;
    }
    public Formation(Long idFormation, String sujet, String description, String difficulté, int durée,  String nomCompetence,String nomCategorie) {
        this.idFormation = idFormation;
        this.sujet = sujet;
        this.description = description;
        this.difficulté = difficulté;
        this.durée = durée;
        this.nomCompetence=nomCompetence;
         this.nomCompetence=nomCategorie;
        
        
        
    }


    public Formation(Long idFormation, String sujet, String description, int durée, Long idPrerequis, Long idCompetence, Long idCategorie, Long idExamen) {
        this.idFormation = idFormation;
        this.sujet = sujet;
        this.description = description;
        this.durée = durée;
        this.idPrerequis = idPrerequis;
        this.idCompetence = idCompetence;
        this.idCategorie = idCategorie;
        this.idExamen = idExamen;
    }


    public Formation(String sujet, String description) {
        this.sujet = sujet;
        this.description = description;
    }
    



    public Formation(String sujet) {
        this.sujet=sujet ; //To change body of generated methods, choose Tools | Templates.
    }

    public Formation(Long idFormation, String sujet, String description, String difficulté, int durée, Long idPrerequis, Long idCompetence, Long idCategorie, Long idExamen, String nomCategorie, String nomCompetence, String nomPrerequis, String nomExamen) {
        this.idFormation = idFormation;
        this.sujet = sujet;
        this.description = description;
        this.difficulté = difficulté;
        this.durée = durée;
        this.idPrerequis = idPrerequis;
        this.idCompetence = idCompetence;
        this.idCategorie = idCategorie;
        this.idExamen = idExamen;
        this.nomCategorie = nomCategorie;
        this.nomCompetence = nomCompetence;
        this.nomPrerequis = nomPrerequis;
        this.nomExamen = nomExamen;
    }
    
    

   

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulté() {
        return difficulté;
    }

    public void setDifficulté(String difficulté) {
        this.difficulté = difficulté;
    }

    public int getDurée() {
        return durée;
    }

    public void setDurée(int durée) {
        this.durée = durée;
    }

    public Long getIdPrerequis() {
        return idPrerequis;
    }

    public void setIdPrerequis(Long idPrerequis) {
        this.idPrerequis = idPrerequis;
    }

    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    public String getNomPrerequis() {
        return nomPrerequis;
    }

    public void setNomPrerequis(String nomPrerequis) {
        this.nomPrerequis = nomPrerequis;
    }

    public String getNomExamen() {
        return nomExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }
    
    

   
    

   
    
    
}