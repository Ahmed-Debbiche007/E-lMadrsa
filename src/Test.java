
package test;
//import entities.User;
import entities.Examen;
import outils.MyDB ;
import services.ExamenService;
import services.UserService;

public class Test {
    public static void main (String args[]) {
        System.out.println(MyDB.getInstance());
        //User u = new User(1,"ahmed","gouiaa",23);
        UserService us = new UserService() ;
        // creation du service Examen : 
        ExamenService Es = new ExamenService() ; 
        // création d'un examen 1
        Examen Ex1 = new Examen("francais",12.0,60); 
        // test ajout examen :
        Es.addExamen(Ex1);
        // test afficher la liste des users :
        System.out.println(us.getAllUsers());
    }
}
