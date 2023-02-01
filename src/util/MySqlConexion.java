package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexion {
	
	public static Connection miConexion() {
		
		Connection cn=null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String cadena="jdbc:mysql://localhost/BD_FARMACIA?useTimezone=true&serverTimezone=America/Lima";
			String usuario="root";
			String password="mysql";
			
			cn=DriverManager.getConnection(cadena,usuario,password);
		} catch(ClassNotFoundException e) {
			System.out.println("Error del Driver.... no adicionado");
		} catch(SQLException e) {
			System.out.println("Error de conexión a la BD");
		} catch(Exception e) {
			System.out.println("Error..." + e.getMessage());
		}
		
		return cn;
	}
	
}
