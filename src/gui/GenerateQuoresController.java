/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class GenerateQuoresController implements Initializable {

    @FXML
    private Label lbQuote;

    /**
     * Initializes the controller class.
     */
    @Override
    
    
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            HttpResponse<JsonNode> apiResponse = Unirest.get("https://api.adviceslip.com/advice").asJson();
             String responseJsonAsString = apiResponse.getBody().toString();
           String quote = apiResponse.getBody().getObject().getJSONObject("slip").getString("advice") ;
           System.out.print(quote);
             lbQuote.setText(quote);             

            
        } catch (UnirestException ex) {
            Logger.getLogger(GenerateQuoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
 

             
            
            
        
        
        
        
        
    }    

    public Label getLbQuote() {
        return lbQuote;
    }

    public void setLbQuote(String lbQuote) {
        this.lbQuote.setText(lbQuote);
    }

    @FXML
    private void backTomain(ActionEvent event) throws IOException {
    Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
        
    }
    
}
