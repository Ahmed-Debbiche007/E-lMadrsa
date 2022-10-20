/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.category;
import entities.post;
import entities.badge;
import entities.user;
import entities.comment;
import services.ServiceBadge;
import services.ServiceCategory;
import services.ServiceComment;
import services.ServicePost;
import services.ServiceUser;
import gui.CatController;
import static gui.CatController.staticcat;

/**
 *
 * @author SBS
 */
public class MainProg {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       ///////////////////////////////////test category////////////////////////////////////////////////
       /*    
       //category cat=new category("hhhhhhhhh","aaaaaaaaaaaaa");
       //category catt=new category("kkkkkkkkkk","kkkkkkkkk");
       category cat2=new category("aaaaaaaaaaaa","bbbbbbbbbbbbbbbbb");
       ServiceCategory sc = new ServiceCategory();
       //sc.ajouter(cat);
       //sc.ajouter(catt);
       //sc.supprimer(cat2);
       sc.modifier("kkkkkkkkkk",cat2);
       sc.afficher().forEach(System.out::println);
       
       ///////////////////////////////////test post////////////////////////////////////////////////
        user userr=new user("aymen",1L,1,"sdghfjihgf");
        post postt=new post("post1","bhazvbdeahgezau",1L,3L,5,6);
        badge badgee=new badge("gold","sghhjdaqjksd");
        ServiceBadge sb =new ServiceBadge();
        sb.ajouter(badgee);
        ServiceUser su = new ServiceUser();
        su.ajouter(userr);
        ServicePost sp = new ServicePost();
        sp.ajouter(postt);
*/
       
       ServiceCategory sc = new ServiceCategory();
       //sc.afficher().forEach(System.out::println);
       user userr=new user("hamma",1L,1,"sdghfjihgf");
       //comment commentt=new comment("auzeghfujqgsfhjkqGKHQGFHQGSKFGQHJKGSFKQJHSFGHK",1L,2L,555);
      // post postt=new post(4L,"postaaaaaaaaaaaaaa","bhazvbdeahgezau",1L,3L,5,6);
        badge badgee=new badge("silverrrrrrrrr","sghhjdaqjksd");
        
        // scom.ajouter(commentt);
        post postt=new post("post1","bhazvbdeahgezau",1L,1L,5,6);
        post postt2=new post("post2","bhazvbdeahgezau",1L,1L,5,6);
       
         ServiceBadge sb =new ServiceBadge();
         ServiceUser su = new ServiceUser();
        
         //sp.ajouter(postt);
        // sp.ajouter(postt2);
       // sp.ajouter(postt3);
         //sb.ajouter(badgee);
         //su.ajouter(userr);
         // sp.supprimer(postt);
       // sp.afficher().forEach(System.out::println);
        //sb.afficher().forEach(System.out::println);
        //su.afficher().forEach(System.out::println);
        //scom.afficher().forEach(System.out::println);
         post postt3=new post("YALLA","PLZ");
        
         
         staticcat=new category(5L,"hhhhhhhhh","aaaaaaaaaaaaa");
         System.out.println(staticcat);
         ServicePost sp = new ServicePost();
         //sp.ajouter(postt3);
         //sp.afficher().forEach(System.out::println);
         comment commentt=new comment("comment3",1L,30L,555);
         ServiceComment scom =new ServiceComment();
         scom.ajouter(commentt);
         scom.afficher().forEach(System.out::println);
         
         
         
         
    }
    
    
    
    
}
