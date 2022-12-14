/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import entites.Categorie;
import services.ServiceCategorie;
import gui.AjoutCategorieController;


/**
 *
 * @author User
 */
public class gestionFormation extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException  {
        /*
        try{
        FXMLLoader loader = new FXMLLoader (getClass().getResource("../gui/welcome.fxml")) ; 
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
       
        primaryStage.setTitle("Entity Categorie ");
        primaryStage.show();
       
        }
        catch(Exception e){
            System.out.println("Underlying exception: " + e.getCause());
            System.out.println("Error Message");
            
        }
        */
               // FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Welcome.fxml")) ;
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/welcome.fxml")) ;
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
