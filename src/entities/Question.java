 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;
 
 
 

/**
 *
 * @author Msi
 */
public class Question {
    private Long idQuestion ; 
    private String ennonce ;
    private Long idQuiz ; 

     


    public Question() {
    }

 

    public Question(String ennonce, Long idQuiz) {
        this.ennonce = ennonce;
        this.idQuiz = idQuiz;
    }

    public Question(Long idQuestion, String ennonce, Long idQuiz) {
        this.idQuestion = idQuestion;
        this.ennonce = ennonce;
        this.idQuiz = idQuiz;
    }

    public Question(String ennonce, List<String> options, String OptionCorrecte) {
        this.ennonce = ennonce;
 
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public String getEnnonce() {
        return ennonce;
    }
 

 

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setEnnonce(String ennonce) {
        this.ennonce = ennonce;
    }

 
 

    public Question(Long idQuestion, String ennonce) {
        this.idQuestion = idQuestion;
        this.ennonce = ennonce;
    }

    public Question(String ennonce) {
        this.ennonce = ennonce;
    }

    public Long getIdQuizz() {
        return idQuiz;
    }

    public void setIdQuizz(Long idQuizz) {
        this.idQuiz = idQuizz;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Question{" + "idQuestion=" + idQuestion + ", ennonce=" + ennonce + ", idQuizz=" + idQuiz + '}';
    }

    
 

 

 
 
 

 
    
    
    
    
}
