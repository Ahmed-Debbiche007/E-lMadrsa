/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author SBS
 */
public class category {
    public long categoryID ;
    private String categoryNAME;
    private String categoryIMAGE;
    private ImageView image;

    public void setImage(ImageView image) {
        this.image = image;
    }

    public ImageView getImage() {
        return image;
    }
    
    
    

    public category() {
    }

    public category(String categoryNAME, String categoryIMAGE) {
        this.categoryNAME = categoryNAME;
        this.categoryIMAGE = categoryIMAGE;
    }

    public category(long categoryID, String categoryNAME, String categoryIMAGE) {
        this.categoryID = categoryID;
        this.categoryNAME = categoryNAME;
        this.categoryIMAGE = categoryIMAGE;
    }

    public category(long categoryID, String categoryNAME, String categoryIMAGE, ImageView image) {
        this.categoryID = categoryID;
        this.categoryNAME = categoryNAME;
        this.categoryIMAGE = categoryIMAGE;
        this.image = image;
    }
    

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryNAME() {
        return categoryNAME;
    }

    public void setCategoryNAME(String categoryNAME) {
        this.categoryNAME = categoryNAME;
    }

    public String getCategoryIMAGE() {
        return categoryIMAGE;
    }

    public void setCategoryIMAGE(String categoryIMAGE) {
        this.categoryIMAGE = categoryIMAGE;
    }

    @Override
    public String toString() {
        return "category{" + "categoryID=" + categoryID + ", categoryNAME=" + categoryNAME + ", categoryIMAGE=" + categoryIMAGE + ", image=" + image + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.categoryID ^ (this.categoryID >>> 32));
        hash = 97 * hash + Objects.hashCode(this.categoryNAME);
        hash = 97 * hash + Objects.hashCode(this.categoryIMAGE);
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
        final category other = (category) obj;
        if (this.categoryID != other.categoryID) {
            return false;
        }
        if (!Objects.equals(this.categoryNAME, other.categoryNAME)) {
            return false;
        }
        return Objects.equals(this.categoryIMAGE, other.categoryIMAGE);
    }
    
    
}
