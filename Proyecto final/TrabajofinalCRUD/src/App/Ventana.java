package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Ventana {

	JFrame frame;
	private static JTable Tabla;
	
	int idUsuario;
	static String nombre;
	static String apellido;
	static String clave;
	static String telefono;
	static String correo;
	private JTextField txt_buscar;
	private JTextField txt_Nombre;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 875, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		Tabla = new JTable();
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Clave", "Telefono", "Correo"
			}
		));
		
		scrollPane.setViewportView(Tabla);
		
		JPanel Pane_vajo = new JPanel();
		frame.getContentPane().add(Pane_vajo, BorderLayout.SOUTH);
		
		JButton boton1 = new JButton("Insertar");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Conectar();
				
				//llenar();
				
			}
		});
		Pane_vajo.add(boton1);
		
		JPanel Pane_1 = new JPanel();
		frame.getContentPane().add(Pane_1, BorderLayout.NORTH);
		
		JLabel lbl_ID = new JLabel("ID:");
		Pane_1.add(lbl_ID);
		
		txt_buscar = new JTextField();
		Pane_1.add(txt_buscar);
		txt_buscar.setColumns(10);
		
		JButton btn_buscar = new JButton("Buscar ID");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Buscar por ID
				
			}
		});
		Pane_1.add(btn_buscar);
		
		JLabel lbl_Nombre = new JLabel("New label");
		Pane_1.add(lbl_Nombre);
		
		txt_Nombre = new JTextField();
		Pane_1.add(txt_Nombre);
		txt_Nombre.setColumns(10);
		
		JButton btn_buscar_Nom = new JButton("Buscar Nombre");
		btn_buscar_Nom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Buscar por nombre
				
			}
		});
		Pane_1.add(btn_buscar_Nom);
	}
	
	public static void llenar() {
		
		int numCol = Tabla.getModel().getColumnCount();
		
		Object [] fila = new Object[numCol];
		
		fila[0] = nombre;
		fila[1] = apellido;
		fila[2] = clave;
		fila[3] = telefono;
		fila[4] = correo;
		
		
		/*id = null;
		titulo = null;
		dia = null;
		mes = null;
		ano = null;
		nota = null;*/
		
		((DefaultTableModel) Tabla.getModel()).addRow(fila);
		
	}
	
	public void Conectar() {
		
		Conexion conexion = new Conexion();
		
			Connection cn = null;//creamos el objeto cn para pasar la conexion 
		
			Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
		
			ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
		
			try {
			
				cn = conexion.Conectar();//metodo que retorna la conexion
				stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
				rs = stm.executeQuery("SELECT * FROM db_crud_final.usuarios;");//aqui dictamos la sentencia SQL
			
			
				while (rs.next()/**/) {
					idUsuario = rs.getInt(1);
					nombre = rs.getString(2);
					apellido = rs.getString(3);
					clave = rs.getString(4);
					telefono = rs.getString(5);
					correo = rs.getString(6);
					
					llenar();
					
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
