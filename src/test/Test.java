
package test;
//import entities.User;
import entities.Examen;
import entities.Option;
import entities.Participation;
 import entities.Quiz;
import java.util.ArrayList;
import java.util.List;
import outils.MyDB ;
import services.ExamenService;
import services.OptionService;
import services.ParticipationsService;
import services.QuestionService;
import services.QuizService;
 
public class Test {
    public static void main (String args[]) {
        System.out.println(MyDB.getInstance());
        
        
        //User u = new User(1,"ahmed","gouiaa",23);
        //UserService us = new UserService() ;
        // creation du service Examen : 
        //ExamenService Es = new ExamenService() ; 
        // création d'un examen 1
        //Examen Ex1 = new Examen("symfony",12.0,60); 
        //Examen Ex2 = new Examen(2,"francais",20.10,120); 
        // test ajout examen :
        //Es.ajouter(Ex1);
       
        //System.out.println(Es.afficher());

        //Es.addExamen(Ex2);
        // test afficher la liste des users :
        //System.out.println(Es.getAllExamens());
        // add examen : 
       // Es.updateExamen( new Examen(1,"anglais",20.10,10));
       //Es.deleteExmaen(Ex2);
          /*
        QuizService Qs = new QuizService() ; 
        Quiz q1 = new Quiz(2,"html") ; 
        
        List<Quiz> l = new ArrayList<>(); 
        l.add(q1) ; 
        System.out.print(l);
         //Qs.addQuiz(q1) ;
         //Qs.deleteQuiz(q1); 
         //Qs.updateQuiz(new Quiz(1,"anglais"));
        // System.out.print(Qs.getAllQuiz());
         */
         /*
         Qs.deleteQuiz(q1);
         List<Quiz> l = Qs.getAllQuiz(); 
      System.out.println(l);

                 List<String> listOptions = new ArrayList<>();
                 listOptions.add("aa");
                 listOptions.add("bb");
*/
         
         /*
        Question question1 = new Question("html") ; 
        
        Qservice.addQuestion(question1);
        
                Option opt1 = new Option("a") ; 
                OptionService Os = new OptionService() ;
                Os.addOption(opt1);
        
 */
         
         /*
              QuestionService Qservice = new QuestionService() ;
               Question question1 = new Question(2,"html") ; 
              // Qservice.updateQuestion(new Question(1,"css"));
        System.out.println(Qservice.getAllQuestions());

        */
          
 
        /*
                      OptionService optservice = new OptionService() ;
             Option opt1 = new Option(1,"a") ; 

             //optservice.updateOption(new Option(1,"pp")) ; 
            // optservice.deleteOption(opt1);
            System.out.print(optservice.getAllOptions()
);
            
             */
        /*
         Quiz q1 = new Quiz(2,"html") ; 
         QuizService Qs = new QuizService() ; 
         Qs.ajouter(q1);
         
*/
        
        
        /*
         Quiz q1 = new Quiz(4,"symfony") ; 
         QuizService Qs = new QuizService() ; 
         //Qs.ajouter(q1);
         Qs.supprimer(q1);
         System.out.print(Qs.afficher()) ; 
        */
         Participation p1 = new Participation(50.0) ; 
         ParticipationsService Ps = new ParticipationsService() ;
         Ps.ajouter(p1);
        
    }
    
}
