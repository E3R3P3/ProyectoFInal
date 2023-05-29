package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Conexion.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txt_nombre;
	private JTextField txt_Clave;
	
	private String nombre, clave;
	
	private String clave_db;
	
	JLabel lbl_Confirmacion;

	Login window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 235, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Titulo = new JLabel("Login");
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Titulo.setBounds(10, 23, 216, 23);
		frame.getContentPane().add(Titulo);
		
		txt_nombre = new JTextField();
		txt_nombre.setBounds(10, 77, 178, 23);
		frame.getContentPane().add(txt_nombre);
		txt_nombre.setColumns(10);
		
		txt_Clave = new JTextField();
		txt_Clave.setColumns(10);
		txt_Clave.setBounds(10, 138, 178, 23);
		frame.getContentPane().add(txt_Clave);
		
		JButton BTN_login = new JButton("Login");
		BTN_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nombre = txt_nombre.getText();
				clave = txt_Clave.getText();
				
				Consulta();

				Ventana Window = new Ventana();
				Window.frame.setVisible(true);

			}
		});
		BTN_login.setBounds(51, 198, 89, 23);
		frame.getContentPane().add(BTN_login);
		
		lbl_Confirmacion = new JLabel("");
		lbl_Confirmacion.setBounds(82, 23, 89, 28);
		frame.getContentPane().add(lbl_Confirmacion);
	}
	
	public void Consulta() {
		
		Conexion conexion = new Conexion();
		
			Connection cn = null;//creamos el objeto cn para pasar la conexion 
		
			Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
		
			ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
		
			try {
			
				cn = conexion.Conectar();//metodo que retorna la conexion
				stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
				rs = stm.executeQuery("Select Clave from usuarios where Nombre = '"+nombre+"';");//aqui dictamos la sentencia SQL
				
				
				while (rs.next()/**/) {
					
					clave_db = rs.getString(1);
					System.out.println(clave_db);
				}
				
				int C =0 , Cdb = 0;

				C = Integer.parseInt(clave);
				Cdb = Integer.parseInt(clave_db);
				
				// evaluamos las claves

				if(C == Cdb) {
					lbl_Confirmacion.setText("Exito");
				}else {
					lbl_Confirmacion.setText("error");
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
