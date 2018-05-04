/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licenciamiento_ciea;

/**
 *
 * @author Sal
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.sql.Statement;

public class conexion {
      static Connection contacto = null;

	public static Connection getConexion(){
            
		String url = "jdbc:sqlserver://ALFRED:1433;databaseName=LICENCIAMIENTO";
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		}catch (ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion... Revisar Driver" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
		}
		try{
			contacto = DriverManager.getConnection(url,"Admin_Licenciamiento","Pemsa12345!");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
		}
		
		return contacto;

	}

	public static ResultSet Consulta(String consulta){

		Connection con = getConexion();
		Statement declara;
		
		try{
			declara = con.createStatement();
			ResultSet respuesta = declara.executeQuery(consulta);
			return respuesta;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
		}

		return null;
	}

}
