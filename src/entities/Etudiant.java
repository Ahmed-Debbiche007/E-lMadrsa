/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Nour
 */
public class Etudiant extends Utilisateur {
 private long idFormation;
    public Etudiant() {
    }

    
    public Etudiant(long idFormation) {
        this.idFormation = idFormation;
    }

    public Etudiant(long idFormation, Long idUtilisateur) {
        super(idUtilisateur);
        this.idFormation = idFormation;
    }

    public Etudiant(long idFormation, Long idUtilisateur, String nom, String prenom, String nomUtilisateur, String email, String motDePasse, Date dateNaissance, String image) {
        super(idUtilisateur, nom, prenom, nomUtilisateur, email, motDePasse, dateNaissance, image);
        this.idFormation = idFormation;
    }

    public long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(long idFormation) {
        this.idFormation = idFormation;
    }
    
    


    
    
    
}
