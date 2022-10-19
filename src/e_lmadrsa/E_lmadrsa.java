/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e_lmadrsa;
import entites.Formation;
import entites.Attestation;
import entites.Competences;
import entites.Categorie;
import entites.Prerequis;
import entites.difficulté;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import services.ServiceFormation;
import services.ServiceAttestation;
import services.ServiceCategorie;
import services.ServiceCompetences;
import services.ServicePrerequis;
import java.util.ArrayList;
import java.util.List;

 import java.util.Date; 
/**
 *
 * @author User
 */
public class E_lmadrsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        /*System.out.println("in main");
        
        ServiceFormation sp = new ServiceFormation();
        System.out.println("création d'un objet Service Formation SUCCED");
        
        Formation F= new Formation();
        
        System.out.println(" objet Formation created SUCCED");
        //**********Ajouter Une Formation****************************
        F.setSujet("JAVA");
        System.out.println(" 11");
        F.setDescription("Cours de base de prog");
        System.out.println(" 12");
        F.setDifficulté(difficulté.DIFFICILE);
        System.out.println("13");
        F.setDurée(8);
        System.out.println("14");
        F.setIdPrerequis(Long.remainderUnsigned(3,3));
        System.out.println("15");
        F.setIdCompetence(Long.remainderUnsigned(2,8));
        System.out.println("16");
        F.setIdCategorie(Long.remainderUnsigned(1,7));
        System.out.println("17");
        F.setIdExamen(Long.remainderUnsigned(9,9));
        System.out.println("18");
        sp.ajouter_formation(F);*/
        
        
        
        
        //****************Modifier Une Formation **********************************
        //ServiceFormation sp = new ServiceFormation();
        //System.out.println("création d'un objet Service Formation SUCCED");
        
        //Formation F= new Formation();
        
        //System.out.println(" objet Formation created SUCCED");
        //F.setSujet("CSS");
        //F.setDescription("Manipulation des images avec python");
        //F.setIdFormation(F.getIdFormation());
        //sp.modifier_formation(F);
        
        
        //********************Supprimer Une Formation *****************************
        //sp.supprimer_formation(F);
        
        //*********************Afficher Une Formation ************
        /*ServiceFormation spA = new ServiceFormation();
        List<Formation> list = new ArrayList<>();
        System.out.println("création d'un objet Service Formation SUCCED");
        
        Formation F= new Formation();
        
        System.out.println(" objet Formation created SUCCED");
        
       list=spA.afficher();
       System.out.println(list);*/
        
        
        
        
        //****************Ajouter Une attestation ********************************
        /*ServiceAttestation spA= new ServiceAttestation();
        System.out.println("Service Attestation Created");
        Attestation A = new Attestation();
        System.out.println("object  Attestation Created");
        
        A.setIdParticipation(Long.remainderUnsigned(6,3)); 
        System.out.println("idParticipation work");
        
        //String date = request.getParameter("date");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse("2022-07-23");
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Date date = simpleDateFormat.parse("08/10/2022");
       
        
        A.setDateAcq(dateDB);
        System.out.println("Pas de problem !! ");
        spA.ajouter_attestation(A);*/
        
        
        
        
        //********************Modifier Une Attestation*******************************
        /*ServiceAttestation spAM= new ServiceAttestation();
        System.out.println("Service Attestation Created");
        Attestation A = new Attestation();
        System.out.println("object  Attestation Created");
        A.setIdParticipation(Long.remainderUnsigned(3,3));
        spAM.modifier_attestation(A);*/
        
        
        
        
        
        //***********************Supprimer Une attestation *******************************
        /*ServiceAttestation spAS= new ServiceAttestation();
        System.out.println("Service Attestation Created");
        Attestation A = new Attestation();
        System.out.println("object  Attestation Created");
        spAS.supprimer_attestation(A);*/
        
        
        
        //*****************Affichier Une Attestation ***************************
        /*ServiceAttestation spAA = new ServiceAttestation ();
        List<Attestation> list = new ArrayList<>();
        System.out.println("création d'un objet Service Formation SUCCED");
        
        Formation F= new Formation();
        
        System.out.println(" objet Formation created SUCCED");
        
       list=spAA.afficher();
       System.out.println(list);
        */
        
        //*******************Ajouter Une categorie ************************************
        /*ServiceCategorie spC= new ServiceCategorie();
        System.out.println("Service categorie Created");
        Categorie C = new Categorie();
        System.out.println("object  categorie Created");
        C.setNomCategorie("Probabilités et statitques ");
        spC.ajouter_categorie(C);*/
         
        
        
        //********************Modifier Une Categorie *************************************
        /*ServiceCategorie spCM= new ServiceCategorie() ;
        System.out.println("Service Categorie Created");
        Categorie C = new Categorie() ;
        System.out.println("object Categorie Created");
        C.setNomCategorie(" securité  ");
        spCM.modifier_categorie(C);*/
        
        
        //**********************Supprimer Une Categorie *********************************
        /*ServiceCategorie spCS= new ServiceCategorie() ;
        System.out.println("Service Categorie Created");
        Categorie C = new Categorie() ;
        System.out.println("object Categorie Created");
        C.setNomCategorie(" Adinistration Réseau  ");
        spCS.supprimer_categorie(C); */
        
        //*************Afficher Une Categorie ****************************************
        /*ServiceCategorie spAA = new ServiceCategorie ();
        List<Categorie> list = new ArrayList<>();
        System.out.println("création d'un objet Service Formation SUCCED");
        
       
        
        System.out.println(" objet Formation created SUCCED");
        
       list=spAA.afficher();
       System.out.println(list);*/
        
        
        
        
        
        //*************************Ajouter Une Competence *************
        /*ServiceCompetences spComp= new ServiceCompetences();
        System.out.println("Service competence Created");
        Competences Comp = new Competences ();
        System.out.println("object  competence Created");
        Comp.setNomCompetence(" CISCO   ");
        spComp.ajouter_competence(Comp);*/
        
        //********************Modifier Une Competence ********************
        
        /*ServiceCompetences spCompM= new ServiceCompetences();
        System.out.println("Service competence Created");
        Competences Comp = new Competences ();
        System.out.println("object  competence Created");
        Comp.setNomCompetence(" MySQL   ");
        spCompM.modifier_competence(Comp);*/
        
        
        
        //****************Supprimer Une Competence **************************
        
        /*ServiceCompetences spCompS= new ServiceCompetences();
        System.out.println("Service competence Created");
        Competences Comp = new Competences ();
        System.out.println("object  competence Created");
       
        spCompS.supprimer_competence(Comp);*/
        
        
        
        
        //**********************Afficher Une Competence ****************
        ServiceCompetences spAA = new ServiceCompetences ();
        List<Competences> list = new ArrayList<>();
        System.out.println("création d'un objet Service Formation SUCCED");
        
       
        
        System.out.println(" objet Formation created SUCCED");
        
       list=spAA.afficher();
       System.out.println(list);
        
        
        
        //*************Ajouter Un Prerequis *****************
        /*ServicePrerequis spP= new ServicePrerequis();
        System.out.println("Service prerequis Created");
        Prerequis P = new Prerequis();
        System.out.println("object  prerequis Created");
        P.setNomPrerequis("Les bases de programmation en C++   ");
        spP.ajouter_Prerequis(P);*/
        
        
        //*************Modifier Une prerequis ******************
        /*ServicePrerequis spPM= new ServicePrerequis();
        System.out.println("Service prerequis Created");
        Prerequis P = new Prerequis();
        System.out.println("object  prerequis Created");
        P.setNomPrerequis(" les lois usuelles de probabilté  ");
        spPM.modifier_prerequise(P);*/
        
        //**************Supprimer un prerequis***************
        /*ServicePrerequis spPS= new ServicePrerequis();
        System.out.println("Service prerequis Created");
        Prerequis P = new Prerequis();
        System.out.println("object  prerequis Created");
        
        spPS.supprimer_prerequis(P);
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        // TODO code application logic here
    }
    
}
