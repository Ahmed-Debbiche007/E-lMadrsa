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
    private difficulté difficulté ; 
    private int durée ; 
    private Long idPrerequis; 
    private Long idCompetence; 
    private Long idCategorie ;
    private Long idExamen;

    public Formation() {
    }

    public Formation(Long idFormation, String sujet, String description, difficulté difficulté, int durée, Long idPrerequis, Long idCompetence, Long idCategorie, Long idExamen) {
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

    public difficulté getDifficulté() {
        return difficulté;
    }

    public void setDifficulté(difficulté difficulté) {
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

    @Override
    public String toString() {
        return "Formation{" + "idFormation=" + idFormation + ", sujet=" + sujet + ", description=" + description + ", difficult\u00e9=" + difficulté + ", dur\u00e9e=" + durée + ", idPrerequis=" + idPrerequis + ", idCompetence=" + idCompetence + ", idCategorie=" + idCategorie + ", idExamen=" + idExamen + '}';
    }
    

   
    
    
}
