/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITU
 */
package accessToDB;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ITU
 */
public class ConnectTo {
    public static Connection oracle() throws Exception{
        Connection newCon = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            newCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","scott","tiger");
        } catch (Exception e) {System.out.println(e);
            throw e;
        }		
        return newCon;
    }
    
    public static Connection postgreS() throws Exception{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/poketra","poketra","poketra");
  
        } catch (Exception e) {
            throw e;
        }  
       return connection;
    }
}
