
 
package services;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import outils.MyDB;


public class UserService {
    Connection cnx ; 

    public UserService() {
    cnx = MyDB.getInstance().getCnx();
    }
    
    
    
    
    public void addUser(User u) {
        try {
            String req="insert into User(FirstName,LastName,age) values('"+u.getFirstName()+"','"+u.getLastName()+"',"+u.getAge()+")" ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

          public void updateUser(User u) {
        try {
            String req="update User SET FirstName=?,LastName=?,age=? where id=?" ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, u.getFirstName());
            st.setString(2, u.getLastName());
            st.setInt(3, u.getAge());
            st.setInt(4, u.getId());
            st.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }          
          
          public List<User> getAllUsers() {
         List<User> listUsers = new ArrayList<>();
        try {
            String req="select * from user" ;
            Statement st = cnx.createStatement(); 
            ResultSet rs = st.executeQuery(req) ;
            
            while(rs.next()) {
                User u = new User();
                u.setFirstName("ahmed");
                u.setLastName("mohamed");
                u.setAge(20);
                listUsers.add(u);
            }
           
        } catch (SQLException ex) {
                                    System.out.println("error occured ");

        }
              
             return listUsers ;  
          }
              
    
}
