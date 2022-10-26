/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Msi
 */
public class Quiz {
    private Long idQuizz ; 
    private String nameQuizz ; 
    private Long idExamen ;

    public Quiz() {
    }

    public Quiz(Long idQuizz, String nameQuizz, Long idExamen) {
        this.idQuizz = idQuizz;
        this.nameQuizz = nameQuizz;
        this.idExamen = idExamen;
    }

    public Quiz(String nameQuizz, Long idExamen) {
        this.nameQuizz = nameQuizz;
        this.idExamen = idExamen;
    }
    

    public Quiz(Long idQuizz, String nameQuizz) {
        this.idQuizz = idQuizz;
        this.nameQuizz = nameQuizz;
    }

    public Quiz(String nameQuizz) {
        this.nameQuizz = nameQuizz;
    }

    public Long getIdQuizz() {
        return idQuizz;
    }

    public String getNameQuizz() {
        return nameQuizz;
    }

    public void setIdQuizz(Long idQuizz) {
        this.idQuizz = idQuizz;
    }

    public void setNameQuizz(String nameQuizz) {
        this.nameQuizz = nameQuizz;
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }
    
    

    @Override
    public String toString() {
        return "Quiz{" + "idQuizz=" + idQuizz + ", nameQuizz=" + nameQuizz + ", idExamen=" + idExamen + '}';
    }

 
    
    
}
