/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

 
import entities.Option;
import entities.Question;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.OptionService;
import services.QuestionService;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutOptionController implements Initializable {

    @FXML
    private TextField tfNomOption;
    @FXML
    private TableView<Option> tvOptions;
    @FXML
    private TableColumn<Option,String> colNomOption;
    private TableColumn<Option,Long> colidQuestion;
    @FXML
    private TableView<Question> tvQuestions;
    @FXML
    private TableColumn<Question,String> colEnnonce;
    @FXML
    private RadioButton idbuttontrue;
    @FXML
    private RadioButton idbuttonFalse;
    @FXML
    private ToggleGroup optionStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               showOptions() ;
               showQuestions() ;

    }    

    @FXML
    private void ajuoterOption(ActionEvent event) {
        if (tfNomOption.getText().trim().equals(""))  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom option  ! ");
 
        else {
        OptionService  OS = new OptionService() ;
        Question q = tvQuestions.getSelectionModel().getSelectedItem() ;
        System.out.println("***********" + q.getIdQuestion()) ;
        OS.ajouter(new Option(  tfNomOption.getText() ,getStatus()  ,q.getIdQuestion() ) );
       showOptions() ;
        JOptionPane.showMessageDialog(null,"Option Ajoutée ! ");
    }
    }

    @FXML
    private void modifierOption(ActionEvent event) {
        Option o = tvOptions.getSelectionModel().getSelectedItem(); 
        OptionService  OS = new OptionService() ;
        System.out.println(o) ;
        OS.modifier(new Option( o.getIdOption(),  tfNomOption.getText()     ));
        JOptionPane.showMessageDialog(null,"Option modifié ! ");
               showOptions() ;
    }

    @FXML
    private void supprimerOption(ActionEvent event) {
        Option o = tvOptions.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        OptionService  SO = new OptionService() ;
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression Option intitulé : " + o.getOptionName());
        alert.setContentText("Avec confirmation cet option va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        SO.supprimer(o);
        JOptionPane.showMessageDialog(null,"Option supprimé ! ");
         showOptions() ;
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

    
    
       public void showOptions() {
        OptionService  SO = new OptionService() ;
        ObservableList<Option> list = SO.afficher() ;
        System.out.println(list ) ; 
        colNomOption.setCellValueFactory(new PropertyValueFactory<Option,String>("optionName"));
         System.out.println(list);
        tvOptions.setItems(list);
        
    }

    @FXML
    private void editOption(ActionEvent event) {
                     if(tvOptions.getSelectionModel().getSelectedItem()!=null) {
             Option o = tvOptions.getSelectionModel().getSelectedItem();
             tfNomOption.setText(o.getOptionName());

    }
    }
    
    
    
              public void showQuestions() {
        QuestionService QS = new QuestionService() ;
        ObservableList<Question> list = QS.afficher() ;
        System.out.println(list ) ; 
        colEnnonce.setCellValueFactory(new PropertyValueFactory<Question,String>("ennonce"));
         System.out.println(list);
        tvQuestions.setItems(list);        
    }


 

    @FXML
    private void buttonRadio(ActionEvent event) {
         if(idbuttonFalse.isSelected()){
             
         }   
         if(idbuttontrue.isSelected()){
             
         }
    }
    
    
    
    public int getStatus() {
                if(idbuttonFalse.isSelected()) 
                    return 0 ; 
                if(idbuttontrue.isSelected())
                    return 1 ;
                
                return -1 ;

    }
    
    
}