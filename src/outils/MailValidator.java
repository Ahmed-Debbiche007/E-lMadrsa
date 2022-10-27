/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author ahmed
 */
public class MailValidator {

    public MailValidator() {
    }
    
    public boolean validationEmail(String s) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher match = pattern.matcher(s);
        if (match.find() && match.group().equals(s)) {
            return true;
        } else {

            Alert alerto = new Alert(Alert.AlertType.ERROR);
            alerto.setTitle("Eror Message");
            alerto.setHeaderText(null);
            alerto.setContentText("Invalid Email!");
            alerto.showAndWait();
            return false;
        }
    }
    
}
