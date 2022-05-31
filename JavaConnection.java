/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustp_directory;

/**
 *
 * @author LAB1-PC#83
 */

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
public class JavaConnection {
    
    Connection conn;
    
    public static java.sql.Connection ConnectDB(){
        try{
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ustep_data","root","");
            return conn;
        }
        catch(Exception e){
            
        }
        return null;
    }
    
}
