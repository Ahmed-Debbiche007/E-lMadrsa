/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import entitie.evenement;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import services.event_service;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class StatisticsController implements Initializable {

    @FXML
    private BarChart<String, Number> stat;
    @FXML
    private NumberAxis fxevents;
    @FXML
    private CategoryAxis fxusers;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        event_service es=new event_service();
          Map list=new HashMap<String,Integer>();
          list=es.readStat();
     long i = 0;
     stat.setScaleX(1);
     stat.setScaleY(1);
     
     
     
     
     
     
Iterator<Map.Entry<Integer, Integer>> it = list.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<Integer, Integer> pair = it.next();
    System.out.println(pair.getValue());
    System.out.println(pair.getKey());
     XYChart.Series series1 = new XYChart.Series();
          
        series1.getData().add(new XYChart.Data( pair.getKey(),pair.getValue()));
           stat.getData().add(series1);
}
          
          
          
          
          
          
          
    
       
      
              
    
    }    
    
}
