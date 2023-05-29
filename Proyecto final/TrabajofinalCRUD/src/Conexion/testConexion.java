package Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class testConexion {
	
	public static void main(String[] args) {
		/*creamos un objeto de tipo conexion 
		 * para utilisar la clase Conexion y
		 * obtener acceso a la bd
		 */
		Conexion conexion = new Conexion();
		
		Connection cn = null;//creamos el objeto cn para pasar la conexion 
		
		Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
		
		ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
		
		try {
			
			cn = conexion.Conectar();//metodo que retorna la conexion
			stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
			rs = stm.executeQuery("SELECT * FROM db_crud_final.usuarios;");//aqui dictamos la sentencia SQL
			
			
			while (rs.next()/**/) {
				int idUsuario = rs.getInt(1);
				String Nombre = rs.getString(2);
				String Apellido = rs.getString(3);
				String Clave = rs.getString(4);
				String Telefono = rs.getString(5);
				String Correo = rs.getString(6);
				
				System.out.println(idUsuario+" | "+Nombre+" | "+Apellido+" | "+Clave+" | "+Telefono+" | "+Correo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {//liveramos lo recursos
			
			try {
				
				if(rs != null) {
					rs.close();
				}
				
				if(stm != null) {
					stm.close();
				}
				
				if(cn != null) {
					cn.close();
				}
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
				
			}
			
		}
		
		
	}

}
