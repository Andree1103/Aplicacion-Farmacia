package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidades.usuario;
import util.MySqlConexion;

public class GestionUsuario {
	
	public usuario obtenerUsuario(usuario usu) {
		usuario usua = null; 
		
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		
		try {
			
			conn = MySqlConexion.miConexion();
			
			String sql = "select * from tb_usuario where usuario=? and pass=?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usu.getUser());
			pstm.setString(2, usu.getPass());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				usua = new usuario(rs.getString(1), rs.getString(2));
			}
			
		}catch(Exception e) {
			System.out.println("Error en obtener usuario");
		}
		
		return usua;
	}
	
	

}
