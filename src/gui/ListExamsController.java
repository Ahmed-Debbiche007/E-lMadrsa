/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Examen;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import services.ExamenService;
 
/**
 * FXML Controller class
 *
 * @author Msi
 */
public class ListExamsController implements Initializable {

    @FXML
    private FlowPane flowpanel;

     Map<Examen , Integer> allexams = null;
   // private NewScreenListener screenListener;
    private Set<Examen> keys ;

 
/*
    public void setScreenListener(NewScreenListener screenListener) {
        this.screenListener = screenListener;

    }

*/
    /*
    public  void setCards(){

        for(Examen e : keys){
             FXMLLoader loader = new FXMLLoader(getClass().getResource("ExamenCard.fxml"));
            try {
                Node node ;  
                node = loader.load();
                
                ExamenCardController examcardcontroller = loader.getController();
                examcardcontroller.setE(e);
                flowpanel.getChildren().add(node);

 
 
            }
        catch (IOException ey) {
                ey.printStackTrace();
            }
        }
    }
 
    
    
    */
   
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        for(int i= 0 ; i<20 ; i++) {
 
            try {
                Parent root = FXMLLoader.load(getClass().getResource("ExamenCard.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ListExamsController.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }
 */
        
        /*

        */
      
         ExamenService Es = new ExamenService() ; 

        
        allexams = Es.getAllWithQuestionCount();
        System.out.println("ddd" +allexams) ; 
        keys = allexams.keySet();
 
                for(Examen e : keys) {
 
                                           FXMLLoader loader = new FXMLLoader(getClass().getResource("ExamenCard.fxml"));
                
 

            try {

                                    
                
                                  Node node = loader.load();
                                  ExamenCardController examcardcontroller = loader.getController();
                                  examcardcontroller.setE(e);
                                  examcardcontroller.setExamTttle(e.getNomExamen());
                                  examcardcontroller.setNbq(allexams.get(e)+"");
                                  System.out.println("nom ::::::" +e.getNomExamen());
                                  flowpanel.getChildren().add(node) ; 

            } catch (IOException ex) {
                Logger.getLogger(ListExamsController.class.getName()).log(Level.SEVERE, null, ex);
            }
         
               
            
        }
        // TODO
    }    
    
}
