/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Participation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utiles.DataDB;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LineChartController implements Initializable {

    @FXML
    private BarChart BarchartForm;
    Connection cnx = DataDB.getInstance().getCnx();
    @FXML
    private Button btRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showLineChart();
        
        // TODO
    }  
    public void showLineChart(){
        ObservableList<Participation> list2 = FXCollections.observableArrayList();
        int i;
        int j;
        i= list2.size();
        System.out.println(i);
         try {
            String requete = "SELECT *,COUNT(participation.idFormation) as nbParticipation  FROM participation JOIN formation ON participation.idFormation=formation.idFormation GROUP BY sujet ORDER BY COUNT(participation.idFormation) DESC ";
            PreparedStatement st = cnx.prepareStatement(requete) ;
            ResultSet rs = st.executeQuery(requete);
            
           
            System.out.println(rs);
            while (rs.next()) {
               
                
             
                list2.add(new Participation(rs.getLong("idParticipation"), rs.getLong("idUser"), rs.getLong("idFormation"),rs.getLong("resultat"),rs.getString("sujet"),rs.getInt("nbParticipation")));
               //System.out.println("heeeeeeeeeeey" + list2);
            
            
            }
            
            
            
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         XYChart.Series series1 = new XYChart.Series();
         String join1=list2.get(0).getSujet();
         System.out.println(join1);
         int  nb1 =  list2.get(0).getNbParticipation();
         System.out.println(nb1);
         series1.setName("partitcipation");
         
         
         for(j=0;j<list2.size();j++){
            String join=list2.get(j).getSujet();
            System.out.println(join);
            int  nb =  list2.get(j).getNbParticipation();
            
            series1.getData().add(new XYChart.Data(join,nb) );
            
            System.out.println(join);
            }
        BarchartForm.getData().setAll(series1);
    }

    @FXML
    private void RetourGestion(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("GestionAttestation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
