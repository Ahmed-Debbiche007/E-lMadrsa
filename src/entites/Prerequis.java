/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

/**
 *
 * @author User
 */
public class Prerequis {
    public Long idPrerequis; 
    private String nomPrerequis ;

    public Prerequis() {
    }

    public Prerequis(Long idPrerequis, String nomPrerequis) {
        this.idPrerequis = idPrerequis;
        this.nomPrerequis = nomPrerequis;
    }

    public Long getIdPrerequis() {
        return idPrerequis;
    }

    public void setIdPrerequis(Long idPrerequis) {
        this.idPrerequis = idPrerequis;
    }

    public String getNomPrerequis() {
        return nomPrerequis;
    }

    public void setNomPrerequis(String nomPrerequis) {
        this.nomPrerequis = nomPrerequis;
    }

    @Override
    public String toString() {
        return "Prerequis{" + "idPrerequis=" + idPrerequis + ", nomPrerequis=" + nomPrerequis + '}';
    }
    
    
}
