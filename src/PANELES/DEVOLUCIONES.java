package PANELES;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import Conexion.Conexion;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class DEVOLUCIONES extends JPanel {
	private JTextField TF_NLIBRO;
	private JTextField TF_NUSUARIO;
	private JTextField txt_dia;
	private JTextField txt_mes;
	private JTextField txt_anios;
	//nuevos
	
	String nombre_us="", nombre_lib="";
	int dia1=0, mes1=0, ano1=0, Disponible1=0;
	String fecha_entrega;
	LocalDate fechaE, fechaHoy;

	/**
	 * Create the panel.
	 */
	public DEVOLUCIONES() {
		setLayout(null);
		
		JButton BT_DEVOLVER = new JButton("Devolver");
		BT_DEVOLVER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//devolver
				 nombre_us = TF_NUSUARIO.getText();
				 nombre_lib = TF_NLIBRO.getText();
				dia1 = Integer.parseInt(txt_dia.getText());
				mes1 =  Integer.parseInt(txt_mes.getText());
				ano1 =  Integer.parseInt(txt_anios.getText());
				Devolver();
				
			}
		});
		BT_DEVOLVER.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_DEVOLVER.setContentAreaFilled(false);
		BT_DEVOLVER.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_DEVOLVER.setBackground(Color.BLACK);
		BT_DEVOLVER.setBounds(278, 519, 222, 45);
		add(BT_DEVOLVER);
		
		TF_NLIBRO = new JTextField();
		TF_NLIBRO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_NLIBRO.setColumns(10);
		TF_NLIBRO.setBounds(278, 416, 222, 42);
		add(TF_NLIBRO);
		
		JLabel lblNombreDelLibro = new JLabel("Nombre del libro");
		lblNombreDelLibro.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblNombreDelLibro.setBounds(278, 380, 222, 33);
		add(lblNombreDelLibro);
		
		TF_NUSUARIO = new JTextField();
		TF_NUSUARIO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_NUSUARIO.setColumns(10);
		TF_NUSUARIO.setBounds(97, 297, 222, 42);
		add(TF_NUSUARIO);
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		lblNewLabel.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblNewLabel.setBounds(97, 253, 185, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Proyecto final\\Fotos\\Devoluciones.png"));
		lblNewLabel_1.setBounds(118, 35, 606, 128);
		add(lblNewLabel_1);
		
		txt_dia = new JTextField();
		txt_dia.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_dia.setColumns(10);
		txt_dia.setBounds(455, 297, 64, 42);
		add(txt_dia);
		
		JLabel lblFechaDe = new JLabel("Fecha del dia");
		lblFechaDe.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblFechaDe.setBounds(455, 253, 185, 33);
		add(lblFechaDe);
		
		txt_mes = new JTextField();
		txt_mes.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_mes.setColumns(10);
		txt_mes.setBounds(550, 297, 64, 42);
		add(txt_mes);
		
		txt_anios = new JTextField();
		txt_anios.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_anios.setColumns(10);
		txt_anios.setBounds(648, 297, 64, 42);
		add(txt_anios);
		
		JLabel lblFechaDe_1 = new JLabel("/");
		lblFechaDe_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 65));
		lblFechaDe_1.setBounds(523, 285, 27, 63);
		add(lblFechaDe_1);
		
		JLabel lblFechaDe_1_1 = new JLabel("/");
		lblFechaDe_1_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 65));
		lblFechaDe_1_1.setBounds(624, 285, 27, 63);
		add(lblFechaDe_1_1);

	}
	
	public void Devolver() {
		
		
		if(Actualizar_tb_libros() == true) {
			
			Evaluar_fecha();
			Actualizar_tb_prestamos();
			
		}
		
	}
	
	@SuppressWarnings("resource")
	public boolean Actualizar_tb_libros() {
		boolean A = false;
		
		Conexion conexion = new Conexion();
		
			Connection cn = null;//creamos el objeto cn para pasar la conexion 
		
			Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
		
			ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
		
			try {
			
				cn = conexion.Conectar();//metodo que retorna la conexion
				stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
				rs = stm.executeQuery("Select Disponibles from libros where (Titulo ='"+nombre_lib+"');");
				
				while (rs.next()/**/) {
					
					Disponible1 = rs.getInt(1)+1;
					
				}
				
				rs = stm.executeQuery("Select Cantidad from libros where (Titulo ='"+nombre_lib+"');");
				
				int total=0;
				while (rs.next()/**/) {
					
					total = rs.getInt(1);
					
				}
				
				
				if(Disponible1 <= total) {
					
					
					rs = stm.executeQuery("Select Titulo from libros where (Titulo ='"+nombre_lib+"');");
					String titulo="";
				
					while (rs.next()/**/) {
						titulo = rs.getString(1);	
					}
					
					
					if(titulo.equals(nombre_lib)) {
						A = true;
					
						stm.executeUpdate("UPDATE `db_crud_final`.`libros` SET `Disponibles` = '"+Disponible1+"' WHERE (`Titulo` = '"+nombre_lib+"');");//aqui dictamos la sentencia SQL
						JOptionPane.showMessageDialog(null, "Cambio realizado en libros.");
					
					}else {
						JOptionPane.showMessageDialog(null, "El libro no existe.");
						A = false;
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "no existen mas libros.");
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
			
			return A;
			
		}
	
	public void Evaluar_fecha() {
		
		Conexion conexion = new Conexion();
		
		Connection cn = null;//creamos el objeto cn para pasar la conexion 
	
		Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
	
		ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
	
		try {
		
			cn = conexion.Conectar();//metodo que retorna la conexion
			stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
			rs = stm.executeQuery("Select Dia_entrega from prestamos where(Nombre_usuario = '"+nombre_us+"');");
			
			while (rs.next()/**/) {
				
				fecha_entrega = rs.getString(1);
				
			}
			
			System.out.println(fecha_entrega+"\n");
			
			ALQUILER a = new ALQUILER();
			int  dia = a.getDia_e();
			
			if(dia1 > dia) {
				//JOptionPane.showMessageDialog(null, "Multa por tardanza.");
			}
			
			//fechaE = LocalDate.parse(fecha_entrega);
			//fechaHoy = LocalDate.parse(ano1+"-"+mes1+"-"+dia1);
			
			/*if(fechaHoy.isAfter(fechaE)) {
				JOptionPane.showMessageDialog(null, "Multa por tardanza.");
			}*/
			
		
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
	
	public void Actualizar_tb_prestamos() {
		
		
		Conexion conexion = new Conexion();
		
			Connection cn = null;//creamos el objeto cn para pasar la conexion 
		
			Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
		
			ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
		
			try {
			
				cn = conexion.Conectar();//metodo que retorna la conexion
				stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
				stm.executeUpdate("DELETE FROM `db_crud_final`.`prestamos` WHERE (`Nombre_usuario` = '"+nombre_us+"');");
				
				JOptionPane.showMessageDialog(null, "Cambio realizado en prestamos.");
				
			
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
