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
    private String option1 ; 
    private String option2 ; 
    private String option3 ; 
    private String answer ; 
    private Long idExamen ; 

    public Question(Long idQuestion, String ennonce, String option1, String option2, String option3, String answer, Long idExamen) {
        this.idQuestion = idQuestion;
        this.ennonce = ennonce;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
        this.idExamen = idExamen;
    }

    public Question(String ennonce, String option1, String option2, String option3, String answer, Long idExamen) {
        this.ennonce = ennonce;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
        this.idExamen = idExamen;
    }

    public Question(String ennonce, String option1, String option2, String option3, String answer) {
        this.ennonce = ennonce;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
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

 
 

    
 

    public Long getidExamen() {
        return idExamen ; 
    }

    public void setidExamen(Long idExamen) {
        this.idExamen= idExamen;
    }

    @Override
    public String toString() {
        return "Question{" + "idQuestion=" + idQuestion + ", ennonce=" + ennonce + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", answer=" + answer + ", idExamen=" + idExamen + '}';
    }
    
    
    
    
 
    
 

 

 
 
 

 
    
    
    
    
}
