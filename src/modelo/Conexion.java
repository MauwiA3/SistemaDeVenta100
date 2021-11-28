package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MauwiA3
 * @version 25-11-2021
 */

public class Conexion{

    Connection con;

    public Connection getConnection(){
        
        try {
            String myBD = "jdbc:mysql://localhost:3306/venta?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

}
