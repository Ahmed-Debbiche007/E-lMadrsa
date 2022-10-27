/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author lmol
 */
public class CategorieEv {
    
    private int id_categorie;
    private String type_ev;

    public CategorieEv() {
    }

    public CategorieEv(String type_ev) {
        this.type_ev = type_ev;
    }

    public CategorieEv(int id_categorie, String type_ev) {
        this.id_categorie = id_categorie;
        this.type_ev = type_ev;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public String getType_ev() {
        return type_ev;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setType_ev(String type_ev) {
        this.type_ev = type_ev;
    }

    @Override
    public String toString() {
        return type_ev;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_categorie;
        hash = 97 * hash + Objects.hashCode(this.type_ev);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategorieEv other = (CategorieEv) obj;
        if (this.id_categorie != other.id_categorie) {
            return false;
        }
        return Objects.equals(this.type_ev, other.type_ev);
    }
    
    

 

   
}


