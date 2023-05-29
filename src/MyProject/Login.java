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
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Conexion.Conexion;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField TF_Usuario;
	private JPasswordField TF_passwordField;
	JButton BT_Register;
	JLabel lblNewLabel_2_2_1;
	JLabel lblNewLabel_2_2;
	JLabel lblNewLabel_1;
	JPanel panel;
	JLabel lblNewLabel;
	JButton BT_Singin;
	REGISTER form;
	Login frame;
	//nuevos
	
	String nombre="", clave_db="";
	int cl ,db_cl;
	boolean log;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 297, 469);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Proyecto final\\Fotos\\LOGO.png"));
		lblNewLabel.setBounds(61, 155, 166, 146);
		panel.add(lblNewLabel);
		
		TF_Usuario = new JTextField();
		TF_Usuario.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_Usuario.setBounds(417, 213, 311, 50);
		contentPane.add(TF_Usuario);
		TF_Usuario.setColumns(10);
		
		BT_Singin = new JButton("LOGIN");
		BT_Singin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clave="";
				
				nombre = TF_Usuario.getText();
				
				char[] pasword = TF_passwordField.getPassword();
				
				for(int i = 0; i < pasword.length; i++) {
						clave += pasword[i];
				}
				System.out.print(clave+"\n");
				Logeo(clave);
				if(log == true) {
					Dashboard Frame = new Dashboard();
					Frame.setVisible(true);
				}
				
				
				
			}
		});
		BT_Singin.setForeground(new Color(0, 0, 0));
		BT_Singin.setBackground(new Color(0, 0, 0));
		BT_Singin.setContentAreaFilled(false);
		BT_Singin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_Singin.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_Singin.setBounds(638, 395, 172, 45);
		contentPane.add(BT_Singin);
		
		BT_Register = new JButton("REGISTER");
		BT_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				form = new REGISTER();
				form.setVisible(true);
			}
		});
		BT_Register.setContentAreaFilled(false);
		BT_Register.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_Register.setBackground(new Color(0, 0, 0));
		BT_Register.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_Register.setBounds(349, 395, 172, 45);
		contentPane.add(BT_Register);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Proyecto final\\Fotos\\Name 1.png"));
		lblNewLabel_1.setBounds(411, 30, 330, 119);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2_2 = new JLabel("User");
		lblNewLabel_2_2.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 17));
		lblNewLabel_2_2.setBounds(417, 183, 104, 19);
		contentPane.add(lblNewLabel_2_2);
		
		lblNewLabel_2_2_1 = new JLabel("Password");
		lblNewLabel_2_2_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 17));
		lblNewLabel_2_2_1.setBounds(417, 277, 104, 19);
		contentPane.add(lblNewLabel_2_2_1);
		
		TF_passwordField = new JPasswordField();
		TF_passwordField.setBounds(417, 307, 311, 50);
		contentPane.add(TF_passwordField);
	}
	
	public int Logeo(String clave) {
		
		int X = 0;
		
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
					//System.out.println(clave_db);
				}
				
				int C =0 , Cdb = 0;

				C = Integer.parseInt(clave);
				Cdb = Integer.parseInt(clave_db);
				
				// evaluamos las claves

				if(C == Cdb) {
					JOptionPane.showMessageDialog(null, "Logueado.");
					log = true;
				}else {
					JOptionPane.showMessageDialog(null, "Error.");
					log = false;
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
			
			return 0;
		}
	
}
