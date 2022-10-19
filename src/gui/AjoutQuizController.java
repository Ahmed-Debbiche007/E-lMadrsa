package gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import entities.Examen;
import entities.Option;
import entities.Question;
import entities.Quiz;
import entities.Quiz;
import entities.Quiz;
import entities.Quiz;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import outils.MyDB;
import services.ExamenService;
import services.OptionService;
import services.QuizService;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutQuizController implements Initializable {

    @FXML
    private TableView<Quiz> tvQuiz;
    @FXML
    private TextField lbNomQuiz;
    @FXML
    private TableColumn<Quiz,String> colnq;
    @FXML
    private TableView<Examen> tvExams;
    @FXML
    private TableColumn<Examen,String> colNomExamen;
    @FXML
    private TableColumn<Examen,Double> colPourcentage;
    @FXML
    private TableColumn<Examen,Integer> colDureeExmaen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showQuiz();
        showExams() ;
        // TODO
    }    

    @FXML
    private void ajuoterQuiz(ActionEvent event) {
 
        
        
                if (lbNomQuiz.getText().trim().equals(""))  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom quiz ! ");
 
                else {
                QuizService  QS = new QuizService() ;
                Examen e   = tvExams.getSelectionModel().getSelectedItem() ;
                System.out.println("**************//////////"+ e) ; 
                QS.ajouter(new Quiz(  lbNomQuiz.getText()  , e.getIdExamen()  ) );
                showQuiz() ;
                JOptionPane.showMessageDialog(null,"qUIZ Ajoutée ! ");
            }
        
        
        
    }

    @FXML
    private void modifierQuiz(ActionEvent event) {
        Quiz q = tvQuiz.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        QuizService  SQ = new QuizService() ;
        SQ.modifier(new Quiz( q.getIdQuizz(),lbNomQuiz.getText()));
        JOptionPane.showMessageDialog(null,"Quiz modifié ! ");
        showQuiz() ;
    }

    @FXML
    private void supprimerQuiz(ActionEvent event) {
                Quiz z = tvQuiz.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        QuizService  SQ = new QuizService() ;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression Quiz intitulé : " + z.getNameQuizz());
        alert.setContentText("Avec confirmation cet Quiz va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        SQ.supprimer(z);
        JOptionPane.showMessageDialog(null,"Quiz supprimé ! ");
        showQuiz() ;
        alert.hide();
         } else {
            alert.hide();
        }
        
    }

    @FXML
    private void BackToMain(ActionEvent event) throws IOException {
                Stage stage ;
                Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
    }

                  public void showQuiz() {
                    QuizService QS= new QuizService() ;
                    ObservableList<Quiz> list = QS.afficher() ;
                    System.out.println(list ) ; 
                    colnq.setCellValueFactory(new PropertyValueFactory<Quiz,String>("nameQuizz"));
                    System.out.println(list);
                    tvQuiz.setItems(list);
                    System.out.println("pppppppppppp"  +  list ) ;
        
    }

    @FXML
    private void editQuiz(ActionEvent event) {
    }
    
    
    
          public void showExams() {
        ExamenService ES = new ExamenService() ; 
        ObservableList<Examen> list = ES.afficher() ;
        System.out.println(list ) ; 
        colNomExamen.setCellValueFactory(new PropertyValueFactory<Examen,String>("nomExamen"));
        colPourcentage.setCellValueFactory(new PropertyValueFactory<Examen,Double>("Pourcentage"));
        colDureeExmaen.setCellValueFactory(new PropertyValueFactory<Examen,Integer>("DureeExamen"));
        System.out.println(list);
        tvExams.setItems(list);
        
    }
}



  