/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Examen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class ExamenCardController implements Initializable {

    
    private Examen E ; 
    @FXML
    private Label ExamTttle;
    @FXML
    private Label nbq;

    public Label getExamTttle() {
        return ExamTttle;
    }

    public Label getNbq() {
        return nbq;
    }

    public void setE(Examen E) {
        this.E = E;
    }

    public void setExamTttle(Label ExamTttle) {
        this.ExamTttle = ExamTttle;
        this.ExamTttle.setText(this.E.getNomExamen());
     }

    public Examen getE() {
        return E;
    }

    public void setExamTttle(String ExamTttle) {
        this.ExamTttle.setText(ExamTttle) ;      
    }

    public void setNbq(String nbq) {
        this.nbq.setText(nbq) ;  
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
