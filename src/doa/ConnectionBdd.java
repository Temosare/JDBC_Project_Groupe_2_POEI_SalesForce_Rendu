/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doa;
import java.sql.*;
/**
 *
 * @author Temosare
 */
public class ConnectionBdd {
    public static Connection connection() {
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
	String url="jdbc:mysql://localhost:3306/jdbcGroupe2";
        try {
            conn= DriverManager.getConnection(url,"root","");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("************Connection a la base jdbc impossible************");
            System.out.println("Veuillez relancer le serveur avant de relancer l'application");
            System.out.println("************************************************************");
            System.exit(0);
        }
        return conn;
    }
}
