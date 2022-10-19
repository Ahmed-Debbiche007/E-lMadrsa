/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

 import entities.Participation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/**
 *
 * @author Msi
 */
public class ParticipationService implements IService<Participation> {
        public ParticipationService() {
    cnx = MyDB.getInstance().getCnx();
    }
    
    Connection cnx ; 
    @Override
    public void ajouter(Participation t) {
     }

    @Override
    public void supprimer(Participation t) {
     }

    @Override
    public void modifier(Participation t) {
     }

    @Override
    public ObservableList<Participation> afficher() {
                    ObservableList<Participation> list =FXCollections.observableArrayList();

            try {
                String req = "select * from Participation" ;
                PreparedStatement st = cnx.prepareStatement(req) ; 
                 ResultSet rs = st.executeQuery(req) ;
                
                while(rs.next()) {
                list.add(new Participation(  rs.getLong("idParticipation") , rs.getDouble("resultat") , rs.getLong("idUser") , rs.getLong("idFormation") ));

            }
                
                
            } catch (SQLException ex) {
                System.out.println("error occured");
                
            }
              return list ; 

     }

 
    
}
