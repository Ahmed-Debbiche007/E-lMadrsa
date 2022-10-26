/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lmol
 */
public class MyDB {
    
    
    String url="jdbc:mysql://localhost:3306/pi";
    String user= "root";
    String password= "";
    Connection cnx;
    private static MyDB instance;

    private MyDB() {
        
        try {
            cnx=DriverManager.getConnection(url, user, password);
            System.out.println("Connection établie");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    
    public static MyDB getInstance(){
        if(instance == null) {
           instance = new MyDB();
        }
        return instance;
    
    }
    public Connection getCnx() {
        return cnx;
    }
    
    
}
