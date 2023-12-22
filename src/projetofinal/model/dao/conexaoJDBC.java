/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal.model.dao;

 /**
 *
 * @author pedro
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexaoJDBC {
    
    public static Connection getConexao() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            return DriverManager.getConnection("jdbc:mysql://localhost/ranking", "root", "Example@2022#");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }   
        
    }  
}
