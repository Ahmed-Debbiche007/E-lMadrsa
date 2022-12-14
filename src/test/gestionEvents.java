/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Reservation;
import java.io.IOException;
import java.text.ParseException;
import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.CategorieEvService;
import services.ReservationService;

/**
 *
 * @author lmol
 */
public class gestionEvents extends Application{
    
   

    @Override
    public void start(Stage primaryStage) throws IOException, Exception {
       
      /*  
       
      
       */
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/AfficherEv.fxml")) ;
        Parent root = loader.load() ; 
        Scene scene = new Scene(root) ;
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ajouter Evenement ");
        primaryStage.show();
  
    }
     public static void main(String[] args)  throws ParseException{
          launch(args);
          CategorieEvService cs = new CategorieEvService();
          ReservationService r = new ReservationService();
          Reservation res = r.getLatest();
//          System.out.println(res.toString());
          
    
    }
}

