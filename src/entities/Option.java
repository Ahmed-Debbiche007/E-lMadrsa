/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Msi
 */
public class Option {
    private Long idOption ; 
    private String optionName ; 
    private int  etat ; 
    private Long idQuestion ; 

    public Option(String optionName, Long idQuestion) {
        this.optionName = optionName;
        this.idQuestion = idQuestion;
    }
    

    public Option(Long idOption, String optionName, Long idQuestion) {
        this.idOption = idOption;
        this.optionName = optionName;
        this.idQuestion = idQuestion;
    }
    


        public Option(Long idOption, String optionName, int etat) {
        this.idOption = idOption;
        this.optionName = optionName;
        this.etat = etat;
    }

    public Option(String optionName, int etat) {
        this.optionName = optionName;
        this.etat = etat;
    }
    
    

    public Option(Long idOption, String optionName, int etat, Long idQuestion) {
        this.idOption = idOption;
        this.optionName = optionName;
        this.etat = etat;
        this.idQuestion = idQuestion;
    }

    public Option(String optionName, int etat, Long idQuestion) {
        this.optionName = optionName;
        this.etat = etat;
        this.idQuestion = idQuestion;
    }
    
    

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }
    
    

  

   

 
    public Long getIdOption() {
        return idOption;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setIdOption(Long idOption) {
        this.idOption = idOption;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

   

    public Option(String optionName) {
        this.optionName = optionName;
    }

    @Override
    public String toString() {
        return "Option{" + "idOption=" + idOption + ", optionName=" + optionName + ", etat=" + etat + ", idQuestion=" + idQuestion + '}';
    }
 
 

    public Option() {
    }

    public Option(Long idOption, String optionName) {
        this.idOption = idOption;
        this.optionName = optionName;
        
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }



    
    
    
}
