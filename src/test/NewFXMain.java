/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package test;

 import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Msi
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
      
        Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(1000);
        stage.setHeight(1000);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("taux des réponses vrais",10 ),
                        
                new PieChart.Data("taux des réponses fausses", 50));
  
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Résultat Examen : ");
  
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
         /*
                Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(1000);
        stage.setHeight(1000);
        QuickChart qc = new QuickChart() ; 
        qc.setWidth(1000);
        
               
        stage.setScene(scene);
        stage.show();
        */
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
