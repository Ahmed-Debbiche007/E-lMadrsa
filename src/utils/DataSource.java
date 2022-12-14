/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aissa
 */
public class DataSource {

    private static DataSource instance;
    String url ="jdbc:mysql://localhost:3306/springfever" ; 
    String user ="root"; 
    String password="password" ;
    Connection cnx  ; 

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Conncting !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
