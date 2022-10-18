package services;

 import entities.Option;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
  import java.sql.SQLException;
 import java.util.ArrayList;
import java.util.List;
  import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.MyDB;

/**
 *
 * @author Msi
 */
public class OptionService implements IService<Option> {
                public OptionService() {
    cnx = MyDB.getInstance().getCnx();
    }
    
    Connection cnx ; 
    
    
    /*
         public void addOption(Option o ) {
    
        try {
            String req = "insert into opt (optionName) values('"+ o.getOptionName()+ "');"  ;
            Statement st = cnx.createStatement();
            st.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(ExamenService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
        
            // update option 

            public void updateOption(Option o) {
            try {
                String req ="update opt set optionName=? where idOption=?" ;
                PreparedStatement st = cnx.prepareStatement(req); 
                st.setString(1, o.getOptionName());
                st.setDouble(2,o.getIdOption());
  
                st.executeUpdate();
                System.out.println("Option  updated");

            } catch (SQLException ex) {
                Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
        // delete question 

        public void deleteOption(Option o) {
    
        try {
            String req = "DELETE FROM opt WHERE idOption=? ;"  ;
            PreparedStatement st = cnx.prepareStatement(req); 
            st.setInt(1, o.getIdOption());
            st.executeUpdate();
            System.out.println("Option  deleted");

        } catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
        // list of questions 

    public List<Option> getAllOptions() {
           List<Option> listOption = new ArrayList<>();

            try {
                String req = "select * from opt" ;
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req) ;
                
                while(rs.next()) {
                Option o = new Option();
                o.setOptionName("a");
      
                listOption.add(o);
            }
                
                
            } catch (SQLException ex) {
                System.out.println("error occured");
                
            }
              return listOption ;
    

        
        
    }
        
        
        
        
        
        */

    @Override
    public void ajouter(Option o) {
                try {
            String req = "insert into opt (optionName) values(?);"  ;
            PreparedStatement st = cnx.prepareStatement(req); 
            st.setString(1, o.getOptionName());
            st.execute();
            System.out.println("option ajoutée ");
        } catch (SQLException ex) {
            System.out.println("Erreur ! option non ajoutée ");
        }
    }

    @Override
    public void supprimer(Option o) {
                try {
            String req = "DELETE FROM opt WHERE idOption=? ;"  ;
            PreparedStatement st = cnx.prepareStatement(req); 
            st.setLong(1, o.getIdOption());
            st.executeUpdate();
            System.out.println("Option  deleted");

        } catch (SQLException ex) {
            Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Option o) {
                    try {
                String req ="update opt set optionName=? where idOption=?" ;
                PreparedStatement st = cnx.prepareStatement(req); 
                st.setString(1, o.getOptionName());
                st.setDouble(2,o.getIdOption());
  
                st.executeUpdate();
                System.out.println("Option  updated");

            } catch (SQLException ex) {
                Logger.getLogger(OptionService.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public ObservableList<Option> afficher() {
                   ObservableList<Option> listOption = FXCollections.observableArrayList();

            try {
                String req = "select * from opt" ;
                PreparedStatement st = cnx.prepareCall(req);
                ResultSet rs = st.executeQuery() ;
                
                while(rs.next()) {
                Option o = new Option();
                o.setOptionName("a");
      
                listOption.add(o);
            }
                
                
            } catch (SQLException ex) {
                System.out.println("error occured");
                
            }
              return listOption ;
    }
        
    
}
