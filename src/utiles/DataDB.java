/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DataDB {
    
    private static DataDB instance;
    private Connection cnx;
    String url ="jdbc:mysql://localhost/E_lmadrsa11";
    String user="root";
    String password="";
    
    private DataDB() {
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Conncting !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static DataDB getInstance() {
        if(instance==null)
        {
            instance = new DataDB();
        }
        return instance; 
    }
    
    public Connection getCnx() {
        return cnx;
    }
    
}
