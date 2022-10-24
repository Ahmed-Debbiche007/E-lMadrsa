/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
//import entities.User;

import com.google.common.hash.Hashing;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.jfr.internal.tool.Main;

/**
 *
 * @author ahmed
 */
public class GUI extends Application {

    private ArrayList<Thread> threads1;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GestionCoursParticulier/gui/AjoutUser.fxml"));
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("../gui/AjoutUser.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("WorkShop PIDEV");
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
