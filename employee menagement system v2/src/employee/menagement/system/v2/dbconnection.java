/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.menagement.system.v2;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class dbconnection {
 public static Connection connect(){
        Connection conn = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost:3306/w.menag", "root", "");
            System.out.println("Connected");;
           
        }

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database connection error", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("The problem is" + e);

        }

        return conn;
}
}
