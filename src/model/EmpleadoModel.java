package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Empleado;
import util.MySqlConexion;

public class EmpleadoModel {
	
	public static String sql="";


	/*----------------------------REGISTRAR-------------------*/
	
 	public int RegistrarEmpleado (Empleado emple){
 		
 		int salida= -1;
 		
 		Connection cn =  null;
 		PreparedStatement pstm = null;
 		
 		try {
 			cn = MySqlConexion.miConexion();
 			
 			
 			sql = "insert into tb_empleado values(?,?,?,?,?,?,?)";
 			
 			pstm = cn.prepareStatement(sql);
 			
 			pstm.setInt(1, emple.getCodEmpleado());
 			pstm.setString(2, emple.getNombres());
 			pstm.setString(3, emple.getApellidos());
 			pstm.setInt(4, emple.getdNI());
 			pstm.setString(5, emple.getTelefono());
 			pstm.setString(6, emple.getEmail());
 			pstm.setString(7, emple.getDireccion());
 			
 			salida= pstm.executeUpdate();
 			
			
		} catch (Exception e) {
		e.getMessage();
		}
 		finally{
 			try {
 				if(pstm!=null)pstm.close();
 				if(cn!=null)cn.close();
				
			} catch (Exception e2) {
			
			}
 		}
 		return salida;
 	}
 	
 	
 	/*----------------------------ELIMINAR-------------------*/
 	
 	public int eliminarEmpleado(int idEmpleado) {
 		int salida = -1; 
 		Connection conn = null; 
 		PreparedStatement pstm = null; 
 		
 		try {
 			conn = MySqlConexion.miConexion();
 			
 			sql = "delete from tb_empleado where CodEmpleado=?";
 			pstm = conn.prepareStatement(sql);
 			pstm.setInt(1, idEmpleado);
 			
 			salida = pstm.executeUpdate();
 		}
 		catch(Exception e) {
 			e.getMessage();
 		} finally {
 			try {
 				if(pstm!=null)
 					pstm.close();
 				if(conn!=null)
 					conn.close();
 			} catch (Exception e2) {
 			}
 		}
 		return salida;
 	}
 	
 	
 	/*----------------------------ACTUALIZAR-------------------*/
 	
 	
 	public int actualizarEmpleado(Empleado obj) {
 		int salida =-1;
 		Connection conn = null; 
 		PreparedStatement pstm = null; 
 		
 		try {
 			conn = MySqlConexion.miConexion();
 			sql = "update tb_empleado set Nombres=?,Apellidos=?,DNI=?,Telefono=?,Email=?,Direccion=? where codEmpleado=?";
 			pstm = conn.prepareStatement(sql);
 			pstm.setString(1, obj.getNombres());
 			pstm.setString(2, obj.getApellidos());
 			pstm.setInt(3, obj.getdNI());
 			pstm.setString(4, obj.getTelefono());
 			pstm.setString(5, obj.getEmail());
 			pstm.setString(6, obj.getDireccion());
 			pstm.setInt(7, obj.getCodEmpleado());
 			
 			salida = pstm.executeUpdate();
 		}
 		catch(Exception e) {
 			e.getMessage();
 		}
 		finally {
 			try {
 				if(conn!=null) conn.close();
 				if(pstm!=null) pstm.close();
 			}
 			catch(Exception e2) {
 			}
 		}
 		return salida;
 	}
 	
 	
 	
 	/*----------------------------LISTAR EMPLEADO-------------------*/
 	public List<Empleado> listaEmpleado(){
 		ArrayList<Empleado> salida = new ArrayList<Empleado>();
 		Connection con = null; 
 		PreparedStatement pstm = null; 
 		ResultSet rs = null; 
 		
 		try {
 			con = MySqlConexion.miConexion();
 			sql ="select * from tb_empleado";
 			pstm = con.prepareStatement(sql);
 			System.out.println("SQL-->" + pstm);
 			
 			rs = pstm.executeQuery();
 			Empleado obj = null; 
 			while(rs.next()) {
 				obj = new Empleado();
 				obj.setCodEmpleado(rs.getInt(1));
 				obj.setNombres(rs.getString(2));
 				obj.setApellidos(rs.getString(3));
 				obj.setdNI(rs.getInt(4));
 				obj.setTelefono(rs.getString(5));
 				obj.setEmail(rs.getString(6));
 				obj.setDireccion(rs.getString(7));
 				salida.add(obj);
 			}
 		} catch(Exception e) {
 			e.getMessage();
 		}
 		finally {
 			try {
 				if(rs!=null)rs.close();
 				if(pstm!=null)pstm.close();
 				if(con!=null)con.close();
 			}
 			catch(SQLException e) {
 			}
 		} return salida;
 	}
 	
 	/*----------------------------LISTA POR NOMBRE-------------------*/
 	
 	public List<Empleado> listaEmpleadoPorNombreLike(String filtro){
 		ArrayList<Empleado> salida = new ArrayList<>();
 		
 		Connection conn = null; 
 		PreparedStatement pstm = null; 
 		ResultSet rs = null; 
 		
 		try {
 			conn = MySqlConexion.miConexion();
 			
 			sql = "select * from tb_empleado where Nombres like ?";
 			pstm = conn.prepareStatement(sql);
 			pstm.setString(1, filtro + "%");
 			
 			rs = pstm.executeQuery();
 			Empleado obj = null; 
 			while(rs.next()) {
 				obj = new Empleado();
 				obj.setCodEmpleado(rs.getInt(1));
 				obj.setNombres(rs.getString(2));
 				obj.setApellidos(rs.getString(3));
 				obj.setdNI(rs.getInt(4));
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
 		} return salida; 
 	}
 	
 	
 	/*----------------------------LISTAR TODOS-------------------*/
 	
 	public List<Empleado> listaTodos(){
 		ArrayList<Empleado> salida = new ArrayList<Empleado>();
 		
 		Connection conn = null; 
 		PreparedStatement pstm = null; 
 		ResultSet rs = null; 
 		
 		try {
 			conn = MySqlConexion.miConexion();
 			
 			sql = "select * from tb_empleado";
 			pstm = conn.prepareStatement(sql);
 			
 			rs = pstm.executeQuery();
 			Empleado obj = null; 
 			while(rs.next()) {
 				obj = new Empleado();
 				obj.setCodEmpleado(rs.getInt(1));
 				obj.setNombres(rs.getString(2));
 				obj.setApellidos(rs.getString(3));
 				obj.setdNI(rs.getInt(4));
 				obj.setTelefono(rs.getString(5));
 				obj.setEmail(rs.getString(6));
 				obj.setDireccion(rs.getString(7));
 				salida.add(obj);
 			}
 		} catch(Exception e) {
 			e.getMessage();
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
 	
 	/*----------------------------CONSULTA POR NOMBRE-------------------*/
 	
 	public List<Empleado> consultaPorNombre(String nombre){
 		ArrayList<Empleado> data = new ArrayList<Empleado>();
 		Connection conn = null; 
 		PreparedStatement pstm = null; 
 		ResultSet rs = null; 
 		
 		try {
 			conn = MySqlConexion.miConexion();
 			
 			sql="select * from tb_empleado where Nombres like ?";
 			pstm = conn.prepareStatement(sql);
 			pstm.setString(1, "%"+nombre+"%");
 			
 			System.out.println("SQL -->"+pstm);
 			
 			rs = pstm.executeQuery();
 			
 			Empleado obj = null; 
 			while(rs.next()) {
 				obj = new Empleado();
 				obj.setCodEmpleado(rs.getInt("CodEmpleado"));
 				obj.setNombres(rs.getString("Nombres"));
 				obj.setApellidos(rs.getString("Apellidos"));
 				obj.setdNI(rs.getInt("DNI"));
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
 				if(pstm!=null) pstm.close();
 				if(conn!=null) conn.close();
 			} catch(Exception e2) {
 			}
 		}
 		return data;
 	}
 	
 	}

