/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package test;

 import java.io.IOException;
import javafx.application.Application;
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
public class MainProgGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
         // eli amelneh fel classe  : 
    /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajoutPersonne.fxml")) ;
        Parent root = loader.load() ; 
        Scene scene = new Scene(root) ;
        primaryStage.setScene(scene);
        primaryStage.setTitle("add user");
        primaryStage.show();
        */
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/MainUI.fxml")) ;
        Parent root = loader.load() ; 
        Scene scene = new Scene(root) ;
        primaryStage.setScene(scene);
        primaryStage.setTitle("Crud Examen ");
        primaryStage.show();
 
    
    }
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
