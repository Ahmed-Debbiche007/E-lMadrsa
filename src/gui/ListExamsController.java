/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
import entities.Examen;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import services.ExamenService;
import services.ServiceCategorie;
 
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


    @FXML
    private TableView<Categorie> tabviewcategorie;
    @FXML
    private TableColumn<Categorie, String> nomcatcol;
   
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        showcategorie();

      
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
    
            public void showcategorie(){
            ServiceCategorie SC = new ServiceCategorie() ;
        ObservableList<Categorie> ListCat =  SC.afficher() ; 
        nomcatcol.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nomCategorie"));
        tabviewcategorie.setItems(ListCat);
        System.out.print("*****" + ListCat);  
    }

    @FXML
    private void chercherparcategorie(ActionEvent event) {
        
        Categorie t = tabviewcategorie.getSelectionModel().getSelectedItem();
        Long idcategorie = t.getIdCategorie() ; 
        flowpanel.getChildren().clear();
        
         ExamenService Es = new ExamenService() ; 

        
        ObservableList<Examen> allexamsbycat = Es.getAllWithQuestionCountbycategorieid(idcategorie);
        System.out.println("ddd" +allexams) ; 
  
        allexamsbycat.forEach((e) -> {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("ExamenCard.fxml"));
            try {

                Node node = loader.load();
                ExamenCardController examcardcontroller = loader.getController();
                examcardcontroller.setE(e);
                examcardcontroller.setExamTttle(e.getNomExamen());
                //examcardcontroller.setNbq(allexams.get(e)+"");
                System.out.println("nom ::::::" +e.getNomExamen());
                
                flowpanel.getChildren().add(node) ; 
                

            } catch (IOException ex) {
                Logger.getLogger(ListExamsController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }); {
 
    }
        
    }
    
}
