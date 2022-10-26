/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Categorie;
import entites.Formation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import services.ServiceCategorie;
import services.ServiceFormation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FiltrageController implements Initializable {

    @FXML
    private TextField tffiltrer;
    @FXML
    private Button btchercher;
    @FXML
    private FlowPane grid;
    @FXML
    private Button btretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chercherCategory(ActionEvent event) throws IOException {
          ServiceCategorie SC = new ServiceCategorie();
         ServiceFormation SF = new ServiceFormation();
         ObservableList<Categorie> ListCat1 =  SC.afficher() ;
          ObservableList<Formation> ListCat =  SF.afficher_catformation () ;
          
          int i,j,j1,i1 =0;
          int column =0;
          int row=1;
          Boolean test = false;
        /*Predicate<String> predicate = new Predicate<String>() {
            
            public boolean delegate(String value) {
                return value.matches(".+rice");
            }
        };
         ilteredObservableList<String> filteredList= createFilter(ListCat1, predicate);*/
        
        String ch= ListCat1.get(0).getNomCategorie();
        String ch1= "";
        i1=ListCat1.size();
        i=ListCat.size();
        List  l =ListCat1;
        Long m= Long.MIN_VALUE;
        Long m1 = Long.MIN_VALUE;
        
        for(j=0;j<i;j++){
            String join=ListCat.get(j).getSujet();
            System.out.println(join);
        }
        for(j=0;j<i1;j++){
            
            ch1= ListCat1.get(j).getNomCategorie();
            
            
            if(ch1.equals(tffiltrer.getText())){
                 test =true;
                System.out.println("true");
                m=ListCat1.get(j).getIdCategorie();
                ch1= ListCat1.get(j).getNomCategorie();
                System.out.println(m);
                System.out.println(ch1);
            }
                
                
                
                
                
           }
        if (test==false){
            JOptionPane.showMessageDialog(null," Pas des Formations dans cette catégorie ! ");
            grid.getChildren().clear();
            
            
            
            
        }
        else {
            
            while(j<=ListCat.size()){
                
                m1=ListCat.get(j).getIdCategorie();
                System.out.println(m1);
                
                if(m1!=m){
                    ListCat.remove(j)       ;
                    j++;
                    
                    
                }
            }
       
            
        
        for(j1=0;j1<ListCat.size();j1++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Item.fxml"));
            
            AnchorPane anchorpane = fxmlLoader.load();
            ItemController itemcontroller = fxmlLoader.getController();
            itemcontroller.setData(ListCat.get(j1));
            /*
            if (column == 3 ){
                row++;
            }
            */
            //grid.add(anchorpane, column++, row);
            /*grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
            */
            grid.getChildren().add(anchorpane);
            grid.setBorder(Border.EMPTY);
            
        }
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

