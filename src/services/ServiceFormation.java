/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entites.Formation;
import utiles.DataDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ServiceFormation {
    Connection cnx = DataDB.getInstance().getCnx();
    
    
     public void ajouter_formation(Formation F) {
        try {
            String requete = "INSERT INTO Formation (sujet,description,difficulté,durée,idPrerequis,idCompetence,idCategorie,idExamen) VALUES ('" + F.getSujet() + "','" + F.getDescription() +"','" + F.getDifficulté() + "','" + F.getDurée() + "','" + F.getIdPrerequis()
                    + "','" + F.getIdCompetence() + "','" + F.getIdCategorie() +  "','" + F.getIdExamen() +  "')";
            System.out.println("1");
            Statement st = cnx.createStatement();
            System.out.println("2");
            st.executeUpdate(requete);
            System.out.println("Formation ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
     
     public void modifier_formation(Formation F) {
        try {
            String requete = "UPDATE Formation SET sujet='" +F.getSujet()  +"',description='" + F.getDescription()+"',difficulté='" + F.getDifficulté()+"',durée='" + F.getDurée()+ "' WHERE idFormation=" + F.getIdFormation() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Formation modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      public void supprimer_formation(Formation F) {
        try {
            String requete = "DELETE FROM Formation WHERE idFormation=" + F.getIdFormation() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Formation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
      public List<Formation> afficher() {
        List<Formation> list = new ArrayList<>();

        try {
            String requete = "SELECT idFormation,sujet,description,difficulté,durée,idPrerequis,idCompetence,idExamen,idCategorie FROM Formation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Formation(rs.getLong("idFormation"), rs.getString("sujet"), rs.getString("description"),rs.getString("description"),rs.getInt("durée"),rs.getLong(6),rs.getLong(7),rs.getLong(8),rs.getLong(8)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
      public Formation VerifUninciteFormation( String sujet ) {
          
            try {
                String req = "SELECT  *  FROM Formation  where sujet=? ";
                PreparedStatement st = cnx.prepareStatement(req) ;
                            st.setString(1, sujet);

                ResultSet rs = st.executeQuery();
            while (rs.next()){
                Formation F = new Formation();
                F.setIdFormation(rs.getLong("idFormation"));
                F.setSujet(rs.getString("sujet"));
                F.setDescription(rs.getString("description"));
                F.setDifficulté(rs.getString("difficulté"));
                F.setIdPrerequis(rs.getLong("idPrerequis"));
                F.setIdCompetence(rs.getLong("idCompetence"));
                F.setIdExamen(rs.getLong("idExamen"));
                F.setIdCategorie(rs.getLong("idCategorie"));
                return F;
            }
            } catch (SQLException ex) {
                System.out.println("Formation Introuvable "  + ex.getMessage());

            }

            return null ;


}
    
    
}
