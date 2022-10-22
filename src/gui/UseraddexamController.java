/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
import entites.Formation;
import entities.Examen;
import entities.Question;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import services.ExamenService;
import services.ServiceCategorie;
import services.ServiceFormation;

 
/**
 * FXML Controller class
 *
 * @author Msi
 */
public class UseraddexamController implements Initializable {
    @FXML
    private TreeView treeView;
    @FXML
    private ToggleGroup options;
    @FXML
    private TextField tfNomExamen;
    @FXML
    private TextField tfPourcentageExamen;
    @FXML
    private TextField tfDureeExamen;
    @FXML
    private TableView<Categorie> tvCategories;
    @FXML
    private TableView<Formation> tvFormations;
    @FXML
    private TextField lboption1;
    @FXML
    private TextField lboption3;
    @FXML
    private TextField lboption2;
    @FXML
    private RadioButton option1;
    @FXML
    private RadioButton option2;
    @FXML
    private RadioButton option3;
    @FXML
    private TextField lbEnnonce;
    @FXML
    private TableColumn<Categorie, String> colNomCategorie;
    @FXML
    private TableColumn<Formation, String> colSujetFormation;

        // my Variable
    private Examen examen = null;
    private ArrayList<Question> questions = new ArrayList<>();
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        radioButtonSetup();
        showcategorie() ;
        showformation() ;
        //renderTreeView() ;
        RadioButtonSetup() ;
        // TODO
    }    
        private void radioButtonSetup(){
        options = new ToggleGroup();
        option1.setToggleGroup(options);
        option2.setToggleGroup(options);
        option3.setToggleGroup(options);
     }
            public void  RadioButtonSetup() {
        
        options = new ToggleGroup();
        option1.setToggleGroup(options);
        option2.setToggleGroup(options);
        option3.setToggleGroup(options);
    }
    
    private void renderTreeView(){
         ExamenService Es = new ExamenService() ;
        Map<Examen , List<Question>> data = Es.getAll();
        Set<Examen> setExams = data.keySet();

        TreeItem root = new TreeItem("exams");
        for(Examen e : setExams){
            TreeItem quizTreeItem = new TreeItem(e);

            List<Question> questions = data.get(e);
            for(Question question : questions){
                TreeItem questionTreeItem = new TreeItem(question);
                questionTreeItem.getChildren().add(new TreeItem("A : " + question.getOption1()));
                questionTreeItem.getChildren().add(new TreeItem("B : " +question.getOption2()));
                questionTreeItem.getChildren().add(new TreeItem("C : " +question.getOption3()));
                questionTreeItem.getChildren().add(new TreeItem("Ans : " +question.getAnswer()));
                quizTreeItem.getChildren().add(questionTreeItem);
            }

            quizTreeItem.setExpanded(true);
            root.getChildren().add(quizTreeItem);
        }

        root.setExpanded(true);
        this.treeView.setRoot(root);
    }
    
    private boolean addQuestions(){
         boolean valid = true ;
        Question question = new Question();
        if(valid){
            //save  
            question.setOption1(option1.getText().trim());
            question.setOption2(option2.getText().trim());
            question.setOption3(option3.getText().trim());
            Toggle selectedOption = options.getSelectedToggle() ; 
            String ans = "";
            if(selectedOption == option1){
                ans = lboption1.getText().trim();
            }else if(selectedOption == option2){
                ans = lboption2.getText().trim();
            }
            else if(selectedOption == option3){
                ans = lboption3.getText().trim();
            }
 
            question.setAnswer(ans);
            question.setEnnonce(this.lbEnnonce.getText().trim());
           
            //this.questions.clear();
            lbEnnonce.clear();
            lboption1.clear();
            lboption2.clear();
            lboption3.clear();
            ExamenService Es = new ExamenService() ; 
            this.examen = Es.getLatest() ;
            question.setIdExamen(this.examen.getIdExamen());
            questions.add(question);

            System.out.println("Save Question...");
            System.out.println("Array of questions ::::::: dans le gui "+questions);
            System.out.println("examen dans le gui "+examen);
        }
        
        return valid;
    }
    @FXML
    private void backtommain(ActionEvent event) throws IOException {
     Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
     }

    @FXML
    private void ajuoterExamen(ActionEvent event) {
        
        
                ExamenService Es = new ExamenService() ; 

        
        
        
                if(tfNomExamen.getText().trim().isEmpty()){
            Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                     .text("Enter valid Exam Title")
                    .title("Exam Title").showError();
            }
                
                
                if(Es.countExams(tfNomExamen.getText().trim())!=null)
                {
                                Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                    .text("this exam name already exist")
                    .title("Exam Title").showError();
                }
                
                else {
                    
                               
                    Formation f =  tvFormations.getSelectionModel().getSelectedItem() ;
                   Categorie c =  tvCategories.getSelectionModel().getSelectedItem() ; 
                   Examen newExam = new Examen(  tfNomExamen.getText()  ,   Double.parseDouble(tfPourcentageExamen.getText())     , Integer.parseInt(tfDureeExamen.getText() )    , f.getIdFormation() , c.getIdCategorie()   ) ; 
                   Es.ajouter(newExam);
                   JOptionPane.showMessageDialog(null,"examen Ajoutée ! "); 
                    
                }
                
                
                
                
        
             /*   
        if (tfNomExamen.getText().trim().equals(""))  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom examen ! ");
        if (tfPourcentageExamen.getText().trim().isEmpty())  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs pourcentage ! ");
        if (tfDureeExamen.getText().trim().isEmpty())  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs durée examen ! ");
 
        */
        
        
        
        
        

        
 
            
            
            
 
        
        
        
        
        
        
        
    
    }

    @FXML
    private void addNextQuestion(ActionEvent event) {
        addQuestions() ; 
    }

    @FXML
     public void submitExam(ActionEvent event) {
         
         
         boolean flag = addQuestions();
         ExamenService Es = new ExamenService() ; 
         Es.save(questions);
                     Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                     .text("examen ajouté wiririiririir")
                    .title("Exam Title").showError();
         
         
         
         
    }
    
            public void showcategorie(){
            ServiceCategorie SC = new ServiceCategorie() ;
        ObservableList<Categorie> ListCat =  SC.afficher() ; 
        colNomCategorie.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nomCategorie"));
        tvCategories.setItems(ListCat);
    }
        
        public void showformation(){
        ServiceFormation SF = new ServiceFormation() ;
        ObservableList<Formation> ListCat =  SF.afficher() ; 
        colSujetFormation.setCellValueFactory(new PropertyValueFactory<Formation,String>("Sujet"));
        tvFormations.setItems(ListCat);

    }


 
    
}
