package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Producto;
import util.MySqlConexion;

public class ProductoModel {
	
	private static String sql="";
	
	
	/*--------------------------------INSERTAR --- REGISTRAR --------------*/
	public int insertarProducto(Producto obj) {
		int salida = -1;
		Connection conn = null; 
		PreparedStatement pstm = null; 
		
		try {
			//OBTENER CONEXIÓN 
			conn = MySqlConexion.miConexion();
			
			sql = "insert into MEDICAMENTO values(?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdProducto());
			pstm.setString(2, obj.getNombre());
			pstm.setDouble(3, obj.getPrecio());
			pstm.setDate(4, obj.getFechaVencimiento());
			pstm.setInt(5, obj.getStock());
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null)conn.close();
			}
			catch(Exception e2) {
			}
		}
		return salida; 
	}
	
	/*--------------------------ELIMINAR----------------------------------*/
	
	public int eliminarProducto(int idProducto) {
		int salida = -1; 
		Connection conn = null; 
		PreparedStatement pstm = null; 
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql ="delete from MEDICAMENTO where CodMedicamento=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idProducto);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
			if(pstm !=null) 
				pstm.close();
			if(conn!=null) 
				conn.close();
		} catch(Exception e2) {
		}
	}
	return salida; 
}
	
	/*------------------------------ACTUALIZAR------------------------*/
	
	public int actualizarProducto(Producto obj) {
		int salida = -1; 
		Connection conn = null; 
		PreparedStatement pstm = null; 
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql = "update MEDICAMENTO set Nombre=?,Precio=?,FechaVencimiento=?,StockActual=? where CodMedicamento=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setDouble(2, obj.getPrecio());
			pstm.setDate(3, obj.getFechaVencimiento());
			pstm.setInt(4, obj.getStock());
			pstm.setInt(5, obj.getIdProducto());
			
			salida = pstm.executeUpdate();
		}
		catch(Exception e){
			e.getMessage();
		}
		finally {
			try {
				if(conn!=null)
					conn.close();
				if(pstm!=null)
					pstm.close();
			}
			catch (Exception e2) {
			}
		}
		return salida; 
	}
	
	/*---------------------------LISTAR PRODUCTO-------------------------*/
	
	public List<Producto> listaProducto(){
		ArrayList<Producto> salida = new ArrayList<Producto>();
		Connection con = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		
		try {
			con = MySqlConexion.miConexion();
			sql = "select * from MEDICAMENTO";
			pstm = con.prepareStatement(sql);
			System.out.println("SQL-->" + pstm);
			
			rs = pstm.executeQuery();
			Producto obj = null; 
			while (rs.next()) {
				obj = new Producto();
				obj.setIdProducto(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setFechaVencimiento(rs.getDate(4));
				obj.setStock(rs.getInt(5));
				salida.add(obj);
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(con != null) con.close();
			}
			catch (SQLException e) {
			}
		}
		return salida; 
	}
	
	/*-----------------------LISTA POR NOMBRE-----------------*/
	
	public List<Producto> listaProductoPorNombreLike(String filtro){
		ArrayList<Producto> salida = new ArrayList<>();
		
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql = "select * from MEDICAMENTO where Nombre like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			
			rs = pstm.executeQuery();
			Producto obj = null; 
			while(rs.next()) {
				obj = new Producto();
				obj.setIdProducto(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setFechaVencimiento(rs.getDate(4));
				obj.setStock(rs.getInt(5));
				salida.add(obj);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstm !=null) pstm.close();
				if(conn!=null) conn.close();
			} catch(Exception e2) {
			}
		}
		return salida;
	}
	
	/*------------------------------LISTAR TODOS-----------------------*/
	
	public List<Producto> listaTodos(){
		ArrayList<Producto> salida = new ArrayList<Producto>();
		
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null;
		
		try {
			conn = MySqlConexion.miConexion();
			
			sql = "select * from MEDICAMENTO";
			pstm = conn.prepareStatement(sql);
			
			
			rs = pstm.executeQuery();
			Producto obj = null; 
			while(rs.next()) {
				obj = new Producto();
				obj.setIdProducto(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setFechaVencimiento(rs.getDate(4));
				obj.setStock(rs.getInt(5));
				salida.add(obj);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(conn != null) conn.close();
			} catch(Exception e2) {
			}
		}
		return salida; 
	}
	
	/*--------------------------CONSULTA POR NOMBRE-------------------*/
	
	public List<Producto> consultaPorNombre(String nombre){
		ArrayList<Producto> data = new ArrayList<Producto>();
		Connection conn = null; 
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		try {
			
			conn = MySqlConexion.miConexion();
			
			sql = "select * from MEDICAMENTO where Nombre like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+nombre+"%");
			
			System.out.println("SQL -->" + pstm);
			
			rs = pstm.executeQuery();
			
			Producto obj = null; 
			while(rs.next()) {
				obj = new Producto();
				obj.setIdProducto(rs.getInt("CodMedicamento"));
				obj.setNombre(rs.getString("Nombre"));
				obj.setPrecio(rs.getDouble("Precio"));
				obj.setFechaVencimiento(rs.getDate("FechaVencimiento"));
				obj.setStock(rs.getInt("StockActual"));
				data.add(obj);
			}
		} catch(Exception e) {
			e.getMessage();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
			}
		}
		return data;
	}
}
