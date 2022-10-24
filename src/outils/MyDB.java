/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;



/**
 *
 * @author ahmed
 */
public class MyDB {

    String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_El-Madrsa?useUnicode=true" + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + "serverTimezone=UTC";
    String user = "freedb_bradly";
    String password = "szRGyj$TzFRM77*";
    Connection cnx;
    static MyDB instance;

    private MyDB() {
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Mysql: Connected Successfully!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static MyDB getInstance() {
        if (instance == null) {
            instance = new MyDB();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

}
