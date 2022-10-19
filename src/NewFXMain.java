/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Msi
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/MainUI.fxml")) ;
            Parent root = loader.load() ;
            Scene scene = new Scene(root) ;
            primaryStage.setScene(scene);
            primaryStage.setTitle("Crud Examen ");
            primaryStage.show();
        } catch (IOException ex) {
System.out.println(ex.getCause()) ;         }
        }
    public static void main(String[] args) {
        launch(args);
    }
    
}
