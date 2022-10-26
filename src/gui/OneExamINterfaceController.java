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
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class OneExamINterfaceController implements Initializable {

    @FXML
    private Label examName;
    @FXML
    private Label question11;
    @FXML
    private Label quiz1;
    @FXML
    private RadioButton option111;
    @FXML
    private RadioButton option112;
    @FXML
    private RadioButton option113;
    @FXML
    private Label question12;
    @FXML
    private RadioButton option121;
    @FXML
    private RadioButton option122;
    @FXML
    private RadioButton option123;
    @FXML
    private Label question21;
    @FXML
    private Label quiz2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setExamName(String examName) {
        this.examName.setText(examName) ; 
    }

    public void setQuestion11(Label question11) {
        this.question11 = question11;
    }

    public void setQuiz1(Label quiz1) {
        this.quiz1 = quiz1;
    }

    public void setOption111(RadioButton option111) {
        this.option111 = option111;
    }

    public void setOption112(RadioButton option112) {
        this.option112 = option112;
    }

    public void setOption113(RadioButton option113) {
        this.option113 = option113;
    }

    public void setQuestion12(Label question12) {
        this.question12 = question12;
    }

    public void setOption121(RadioButton option121) {
        this.option121 = option121;
    }

    public void setOption122(RadioButton option122) {
        this.option122 = option122;
    }

    public void setOption123(RadioButton option123) {
        this.option123 = option123;
    }

    public void setQuestion21(Label question21) {
        this.question21 = question21;
    }

    public void setQuiz2(Label quiz2) {
        this.quiz2 = quiz2;
    }

    public Label getExamName() {
        return examName;
    }

    public Label getQuestion11() {
        return question11;
    }

    public Label getQuiz1() {
        return quiz1;
    }

    public RadioButton getOption111() {
        return option111;
    }

    public RadioButton getOption112() {
        return option112;
    }

    public RadioButton getOption113() {
        return option113;
    }

    public Label getQuestion12() {
        return question12;
    }

    public RadioButton getOption121() {
        return option121;
    }

    public RadioButton getOption122() {
        return option122;
    }

    public RadioButton getOption123() {
        return option123;
    }

    public Label getQuestion21() {
        return question21;
    }

    public Label getQuiz2() {
        return quiz2;
    }
    
}
