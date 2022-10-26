/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class ProgressCircleFXMLController implements Initializable {

    @FXML
    private Circle circle;
    @FXML
    private Label number;


    public void setNumber(Integer number) {
        this.number.setText(number.toString());
    }

    public void setDefaultColor(){
        circle.setFill(Color.web("#DAE0E2"));
        number.setTextFill(Color.valueOf("black"));
    }

    public void setCurrentQuestionColor(){
        circle.setFill(Color.web("#0ABDE3"));
        number.setTextFill(Color.valueOf("white"));
    }

    public void setWrongAnsweredColor(){
        circle.setFill(Color.web("#EC4849"));
        number.setTextFill(Color.valueOf("white"));
    }


    public void setRightAnsweredColor(){
        circle.setFill(Color.web("#75DA8B"));
        number.setTextFill(Color.valueOf("white"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
}
