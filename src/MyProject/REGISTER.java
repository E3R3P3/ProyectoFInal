package MyProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import Conexion.Conexion;

import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.DropMode;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class REGISTER extends JFrame {

	private JPanel contentPane;
	private JTextField TF_NOMBRE;
	private JTextField TF_NUMTELEFONO;
	private JTextField TF_CORREO;
	private JTextField TF_LASTNAME;
	private JPasswordField TF_passwordField1;
	private JPasswordField TF_passwordField2;
	//Nuevos
	String nombre, apellido,claveF="" , telefono, correo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGISTER frame = new REGISTER();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public REGISTER() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 297, 588);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Proyecto final\\Fotos\\LOGO.png"));
		lblNewLabel.setBounds(60, 211, 166, 146);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Proyecto final\\Fotos\\Name 1.png"));
		lblNewLabel_1.setBounds(531, 11, 330, 119);
		contentPane.add(lblNewLabel_1);
		
		TF_NOMBRE = new JTextField();
		TF_NOMBRE.setName("");
		TF_NOMBRE.setToolTipText("");
		TF_NOMBRE.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_NOMBRE.setBounds(376, 200, 224, 40);
		contentPane.add(TF_NOMBRE);
		TF_NOMBRE.setColumns(10);
		
		TF_NUMTELEFONO = new JTextField();
		TF_NUMTELEFONO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_NUMTELEFONO.setColumns(10);
		TF_NUMTELEFONO.setBounds(376, 359, 224, 40);
		contentPane.add(TF_NUMTELEFONO);
		
		TF_CORREO = new JTextField();
		TF_CORREO.setBackground(new Color(255, 255, 255));
		TF_CORREO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_CORREO.setColumns(10);
		TF_CORREO.setBounds(790, 200, 224, 40);
		contentPane.add(TF_CORREO);
		
		TF_LASTNAME = new JTextField();
		TF_LASTNAME.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_LASTNAME.setColumns(10);
		TF_LASTNAME.setBounds(376, 282, 224, 40);
		contentPane.add(TF_LASTNAME);
		
		JButton BT_REGISTER = new JButton("REGISTER");
		BT_REGISTER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nombre = TF_NOMBRE.getText();
				apellido = TF_LASTNAME.getText();
				correo = TF_CORREO.getText();
				telefono = TF_NUMTELEFONO.getText();
				
				String clave1="",clave2="";
				
				char[] pasword1 = TF_passwordField1.getPassword();
				
				for(int i = 0; i < pasword1.length; i++) {
						clave1 += pasword1[i];
				}
				
				char[] pasword2 = TF_passwordField2.getPassword();
				
				for(int i = 0; i < pasword2.length; i++) {
						clave2 += pasword2[i];
				}
				
				
				int a=0, b=0;
				
				a = Integer.parseInt(clave1);
				b = Integer.parseInt(clave2);
				
				System.out.print(a+" "+b+"\n");
				
				if(a == b) {
					//JOptionPane.showMessageDialog(null, "registrado.");
					claveF = clave1;
					Registrar();
				}else {
					JOptionPane.showMessageDialog(null, "Pasword error.");
				}
				
				
				
			}
		});
		BT_REGISTER.setContentAreaFilled(false);
		BT_REGISTER.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_REGISTER.setBackground(new Color(0, 0, 0));
		BT_REGISTER.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_REGISTER.setBounds(580, 443, 232, 50);
		contentPane.add(BT_REGISTER);
		
		JButton BT_SINGIN_2 = new JButton("SING IN");
		BT_SINGIN_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Login Pestaña = new Login();
				//Pestaña.setVisible(true);
				
				
			}

			
		});
		BT_SINGIN_2.setContentAreaFilled(false);
		BT_SINGIN_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_SINGIN_2.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_SINGIN_2.setBackground(new Color(0, 0, 0));
		BT_SINGIN_2.setBounds(580, 505, 232, 50);
		//contentPane.add(BT_SINGIN_2);
		
		TF_passwordField1 = new JPasswordField();
		TF_passwordField1.setBounds(790, 278, 224, 40);
		contentPane.add(TF_passwordField1);
		
		TF_passwordField2 = new JPasswordField();
		TF_passwordField2.setBounds(790, 360, 224, 40);
		contentPane.add(TF_passwordField2);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(790, 248, 104, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Repeat password");
		lblNewLabel_2_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(790, 329, 161, 19);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Name");
		lblNewLabel_2_2.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 17));
		lblNewLabel_2_2.setBounds(376, 170, 104, 19);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Last name");
		lblNewLabel_2_2_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 17));
		lblNewLabel_2_2_1.setBounds(376, 252, 104, 19);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("EMAIL");
		lblNewLabel_2_2_2.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 17));
		lblNewLabel_2_2_2.setBounds(790, 170, 104, 19);
		contentPane.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Phone number");
		lblNewLabel_2_2_1_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 17));
		lblNewLabel_2_2_1_1.setBounds(376, 329, 166, 19);
		contentPane.add(lblNewLabel_2_2_1_1);
	}
	
	public void Registrar() {
		
		int X = 0;
		
		Conexion conexion = new Conexion();
		
			Connection cn = null;//creamos el objeto cn para pasar la conexion 
		
			Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
		
			ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
		
			try {
			
				cn = conexion.Conectar();//metodo que retorna la conexion
				stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
				//rs = stm.executeQuery("INSERT INTO `db_crud_final`.`usuarios` (`Nombre`, `Apellido`, `Clave`, `Telefono`, `Correo`) VALUES ('"+nombre+"', '"+apellido+"', '"+claveF+"', '"+telefono+"', '"+correo+"');");//aqui dictamos la sentencia SQL
				stm.executeUpdate("INSERT INTO `db_crud_final`.`usuarios` (`Nombre`, `Apellido`, `Clave`, `Telefono`, `Correo`) VALUES ('"+nombre+"', '"+apellido+"', '"+claveF+"', '"+telefono+"', '"+correo+"');");
				
				JOptionPane.showMessageDialog(null, "Registrado.");
				
				
			
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
