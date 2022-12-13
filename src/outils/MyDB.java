

package outils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class MyDB {
    
    String url ="jdbc:mysql://localhost:3306/springfever" ; 
    String user ="root"; 
    String password="password" ;
    Connection cnx  ; 
    static  MyDB instance ; 
    
    private MyDB() {
        try { 
            cnx = DriverManager.getConnection(url,user,password) ;
            System.out.println("connected ");
        } catch (SQLException ex) {
            System.out.println("not connected" + ex.getMessage());
        }
    }
    
    public static MyDB getInstance() {
        if(instance==null)
            instance = new MyDB();
        return instance ; 
    }

    public MyDB(Connection cnx) {
        this.cnx = cnx;
    }

    public Connection getCnx() {
        return cnx;
    }

}
