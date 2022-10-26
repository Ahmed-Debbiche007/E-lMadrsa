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
public class Enseignant extends Utilisateur{
    private double rate;
    private long idFormation;
    
    
    
    public Enseignant (long idUtilisateur, String nom, String prenom, String nomUtilisateur, String email, String motDePasse, Date dateNaissance, String image, double rate, long idFormation){
    super(idUtilisateur, nom, prenom, nomUtilisateur, email, motDePasse, dateNaissance, image);
    this.rate = rate;
    this.idFormation = idFormation;
    }

    @Override
    public String toString() {
        return "Enseignant{" + "rate=" + rate + ", idFormation=" + idFormation + '}';
    }
    
    
}
