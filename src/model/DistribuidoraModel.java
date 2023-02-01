package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Distribuidora;
import util.MySqlConexion;

public class DistribuidoraModel {
	
	private static String sql="";
	
	/*---------------------INSERTAR O REGISTRAR------------------*/
	
	public int insertarDistribuidora(Distribuidora obj) {
		int salida = -1; 
		Connection conn = null; 
		PreparedStatement pstm = null; 
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql = "insert into tb_distribuidora values(?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdDistribuidora());
			pstm.setString(2, obj.getRaSocial());
			pstm.setString(3, obj.getRuc());
			pstm.setString(4, obj.getTipo());
			pstm.setString(5, obj.getTelefono());
			pstm.setString(6, obj.getEmail());
			pstm.setString(7, obj.getDireccion());
			
			salida = pstm.executeUpdate();
		} catch (Exception e){
			e.getMessage();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			}
			catch(Exception e2) {
			}
		}
		return salida; 
	}
	
	/*---------------------ELIMINAR------------------*/
	
	public int eliminarDistribuidora(int idDistribuidora) {
		int salida = -1; 
		Connection conn = null; 
		PreparedStatement pstm = null; 
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql="delete from tb_distribuidora where CodDistribuidora=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idDistribuidora);
			
			salida=pstm.executeUpdate();
		} catch(Exception e) {
			e.getMessage();
		} finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			} catch(Exception e2) {
			}
		}
		return salida;
	}

	
	/*---------------------ACTUALIZAR------------------*/
	
	public int actualizarDistribuidora(Distribuidora obj) {
		int salida = -1; 
		Connection conn = null; 
		PreparedStatement pstm = null; 
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql="update tb_distribuidora set RazonSocial=?,RUC=?,Tipo=?,Telefono=?,Email=?,Direccion=? where CodDistribuidora=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getRaSocial());
			pstm.setString(2, obj.getRuc());
			pstm.setString(3, obj.getTipo());
			pstm.setString(4, obj.getTelefono());
			pstm.setString(5, obj.getEmail());
			pstm.setString(6, obj.getDireccion());
			pstm.setInt(7, obj.getIdDistribuidora());
			
			salida=pstm.executeUpdate();
		} catch(Exception e) {
			e.getMessage();
		}
		finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null)pstm.close();
			}
			catch(Exception e2) {
			}
		}
		return salida; 
	}
	
	
	/*---------------------LISTAR DISTRIBUIDORA------------------*/
	
	public List<Distribuidora> listaDistribuidora(){
		ArrayList<Distribuidora> salida = new ArrayList<Distribuidora>();
		Connection con = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		
		try {
			con = MySqlConexion.miConexion();
			sql ="select * from tb_distribuidora";
			pstm = con.prepareStatement(sql);
			System.out.println("SQL-->" + pstm);
			
			rs = pstm.executeQuery();
			Distribuidora obj = null; 
			while(rs.next()) {
				obj = new Distribuidora();
				obj.setIdDistribuidora(rs.getInt(1));
				obj.setRaSocial(rs.getString(2));
				obj.setRuc(rs.getString(3));
				obj.setTipo(rs.getString(4));
				obj.setTelefono(rs.getString(5));
				obj.setEmail(rs.getString(6));
				obj.setDireccion(rs.getString(7));
				salida.add(obj);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(con !=null) con.close();
			}
			catch(SQLException e2) {
			}
		}
		return salida;
	}
	
	/*---------------------LISTAR POR RAZÓN SOCIAL------------------*/
	
	public List<Distribuidora> listaDistribuidoraPorRazonSocialLike(String filtro){
		ArrayList<Distribuidora> salida = new ArrayList<>();
		
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql="select * from tb_distribuidora where RazonSocial like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			
			rs=pstm.executeQuery();
			Distribuidora obj = null; 
			while(rs.next()) {
				obj = new Distribuidora();
				obj.setIdDistribuidora(rs.getInt(1));
				obj.setRaSocial(rs.getString(2));
				obj.setRuc(rs.getString(3));
				obj.setTipo(rs.getString(4));
				obj.setTelefono(rs.getString(5));
				obj.setEmail(rs.getString(6));
				obj.setDireccion(rs.getString(7));
				salida.add(obj);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			} catch(Exception e2) {
			}
		}
		return salida;
	}
	
	
	/*---------------------LISTAR TODOS------------------*/
	
	public List<Distribuidora> listaTodos(){
		ArrayList<Distribuidora> salida = new ArrayList<Distribuidora>();
		
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		
		try {
			conn=MySqlConexion.miConexion();
			
			sql="select * from tb_distribuidora";
			pstm = conn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			Distribuidora obj = null; 
			while(rs.next()) {
				obj = new Distribuidora();
				obj.setIdDistribuidora(rs.getInt(1));
				obj.setRaSocial(rs.getString(2));
				obj.setRuc(rs.getString(3));
				obj.setTipo(rs.getString(4));
				obj.setTelefono(rs.getString(5));
				obj.setEmail(rs.getString(6));
				obj.setDireccion(rs.getString(7));
				salida.add(obj);
			}
		}catch(Exception e) {
			e.getMessage();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch(Exception e2) {
			}
		}
		return salida; 
	}
	
	
	/*---------------------CONSULTA POR RAZÓN SOCIAL------------------*/
	
	public List<Distribuidora> consultaProRazonSocial(String razon){
		ArrayList<Distribuidora> data = new ArrayList<Distribuidora>();
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql="select * from tb_distribuidora where RazonSocial like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+razon+"%");
			
			System.out.println("SQL -->" + pstm);
			
			rs = pstm.executeQuery();
			
			Distribuidora obj = null; 
			while(rs.next()) {
				obj = new Distribuidora();
				obj.setIdDistribuidora(rs.getInt("CodDistribuidora"));
				obj.setRaSocial(rs.getString("RazonSocial"));
				obj.setRuc(rs.getString("RUC"));
				obj.setTipo(rs.getString("Tipo"));
				obj.setTelefono(rs.getString("Telefono"));
				obj.setEmail(rs.getString("Email"));
				obj.setDireccion(rs.getString("Direccion"));
				data.add(obj);
			}
		} catch(Exception e) {
			e.getMessage();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch(Exception e2) {
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
