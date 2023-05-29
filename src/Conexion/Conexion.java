package Conexion;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexion {
	//atributos nesesarios para la conexion con la bd
	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "Jdbc:mysql://localhost:3306/db_crud_final";
	private static final String Usuario = "root";
	private static final String Clave = "1303";
	
	/*Static que se ejecutara si imporque que llamen al metodo 
	 * Conectar para cargar el controlador al iniciar el programa
	 */
	static {
		
		try {
			
			Class.forName(controlador);
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
			
		}
	}
	
	/*
	 * metodo conectar que permite realizar la conexion
	 * con la bd
	 */
	public Connection Conectar() {
		
		Connection Conexion = null;//objeto de tipo Connection que se utilizara para pasar la conexion
		
		try {
			//pasamos la consulta de la conexion al objeto conexion
			Conexion = DriverManager.getConnection(URL,Usuario,Clave);
			
			System.out.println("Conexion realizada.");
			
			} catch(SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
			
			}
			//retornamos el objeto conexion
			return Conexion;
		
	 	}


}
