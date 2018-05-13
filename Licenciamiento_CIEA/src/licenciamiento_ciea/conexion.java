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
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        //Metodo para realizar consultas a la base de datos
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
        
        static ResultSet res;
    
        
    //Método para cargar los datos de la BD en la tabla de la Interfaz
    public static void loadTable(String query, JTable nameModelTable, String [] columnas){
	DefaultTableModel modelo = (DefaultTableModel) nameModelTable.getModel();
	modelo.setRowCount(0);
	res = licenciamiento_ciea.conexion.Consulta(query);
	try{
		while(res.next()){
                        Vector v = new Vector();
                        for(int j = 0; j < columnas.length; j ++){
                                v.add(res.getString(columnas[j]));
                        }
                       modelo.addRow(v);
                       nameModelTable.setModel(modelo);
                }
	}catch(SQLException e){
            System.out.println("Error en la conexión, LoadTable");
	}

}

        
}
