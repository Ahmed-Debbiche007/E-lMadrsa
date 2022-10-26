/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

/**
 *
 * @author User
 */
public class Competences {
    public Long idCompetence;
    private String nomCompetence;

    public Competences() {
    }

    public Competences(Long idCompetence, String nomCompetence) {
        this.idCompetence = idCompetence;
        this.nomCompetence = nomCompetence;
    }

    public Long getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Long idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    @Override
    public String toString() {
        return "Competences{" + "idCompetence=" + idCompetence + ", nomCompetence=" + nomCompetence + '}';
    }
    
    
}
