package PANELES;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import Conexion.Conexion;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class ALQUILER extends JPanel {
	private JTextField TF_NUSUARIO;
	private JTextField TF_NLIBRO;
	private JTextField txt_dia;
	private JTextField txt_mes;
	private JTextField txt_anios;
	// nuevos
	
	String nombre_us="", nombre_lib="";
	int dia=0, mes=0, ano=0, Disponible=0;
	int dia_e=0, mes_e=0,ano_e=0;
	
	LocalDate fecha1;

	/**
	 * Create the panel.
	 */
	public ALQUILER() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		lblNewLabel.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblNewLabel.setBounds(103, 228, 185, 33);
		add(lblNewLabel);
		
		TF_NUSUARIO = new JTextField();
		TF_NUSUARIO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_NUSUARIO.setBounds(103, 272, 222, 42);
		add(TF_NUSUARIO);
		TF_NUSUARIO.setColumns(10);
		
		JLabel lblNombreDelLibro = new JLabel("Nombre del libro");
		lblNombreDelLibro.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblNombreDelLibro.setBounds(287, 355, 222, 33);
		add(lblNombreDelLibro);
		
		TF_NLIBRO = new JTextField();
		TF_NLIBRO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_NLIBRO.setColumns(10);
		TF_NLIBRO.setBounds(287, 391, 222, 42);
		add(TF_NLIBRO);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Proyecto final\\Fotos\\PRESTAR LIBROS.png"));
		lblNewLabel_1.setBounds(158, 32, 480, 158);
		add(lblNewLabel_1);
		
		JButton BT_Register = new JButton("Prestar");
		BT_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 nombre_us = TF_NUSUARIO.getText();
				 nombre_lib = TF_NLIBRO.getText();
				dia = Integer.parseInt(txt_dia.getText());
				mes =  Integer.parseInt(txt_mes.getText());
				ano =  Integer.parseInt(txt_anios.getText());
				
				Prestamo();
				
			}
		});
		BT_Register.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_Register.setContentAreaFilled(false);
		BT_Register.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_Register.setBackground(Color.BLACK);
		BT_Register.setBounds(287, 494, 222, 45);
		add(BT_Register);
		
		JLabel lblFechaDe = new JLabel("Fecha");
		lblFechaDe.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblFechaDe.setBounds(461, 219, 185, 33);
		add(lblFechaDe);
		
		txt_dia = new JTextField();
		txt_dia.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_dia.setColumns(10);
		txt_dia.setBounds(461, 263, 64, 42);
		add(txt_dia);
		
		JLabel lblFechaDe_1 = new JLabel("/");
		lblFechaDe_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 65));
		lblFechaDe_1.setBounds(529, 251, 27, 63);
		add(lblFechaDe_1);
		
		txt_mes = new JTextField();
		txt_mes.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_mes.setColumns(10);
		txt_mes.setBounds(556, 263, 64, 42);
		add(txt_mes);
		
		JLabel lblFechaDe_1_1 = new JLabel("/");
		lblFechaDe_1_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 65));
		lblFechaDe_1_1.setBounds(630, 251, 27, 63);
		add(lblFechaDe_1_1);
		
		txt_anios = new JTextField();
		txt_anios.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_anios.setColumns(10);
		txt_anios.setBounds(654, 263, 64, 42);
		add(txt_anios);

	}
	
	public void Prestamo() {
		
		if(Actualizar_tb_libros() == true) {
			Calcula_fecha_entrega();
		
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
					
					Disponible = rs.getInt(1)-1;
					
				}
				
				rs = stm.executeQuery("Select Titulo from libros where (Titulo ='"+nombre_lib+"');");
				String titulo="";
				
				while (rs.next()/**/) {
					titulo = rs.getString(1);	
				}
				
				if(Disponible >= 0) {
					
					if(titulo.equals(nombre_lib)) {
						A = true;
					
						stm.executeUpdate("UPDATE `db_crud_final`.`libros` SET `Disponibles` = '"+Disponible+"' WHERE (`Titulo` = '"+nombre_lib+"');");//aqui dictamos la sentencia SQL
						JOptionPane.showMessageDialog(null, "Cambio realizado en libros.");
					
					}else {
						JOptionPane.showMessageDialog(null, "El libro no existe.");
						A = false;
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "no hay Libros disponibles.");
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
	
	public void Actualizar_tb_prestamos() {
		
		
		Conexion conexion = new Conexion();
		
			Connection cn = null;//creamos el objeto cn para pasar la conexion 
		
			Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
		
			ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
		
			try {
			
				cn = conexion.Conectar();//metodo que retorna la conexion
				stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
				stm.executeUpdate("INSERT INTO `db_crud_final`.`prestamos` (`Dia_prestamo`, `Dia_entrega`, `Nombre_libro`, `Nombre_usuario`, `Cantidad_prestada`) VALUES ('"+ano+"-"+mes+"-"+dia+"', '"+ano_e+"-"+mes_e+"-"+dia_e+"', '"+nombre_lib+"', '"+nombre_us+"', '"+1+"');");
				
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
	
	public void Calcula_fecha_entrega() {
		
		dia_e = dia+7;
		mes_e = mes;
		ano_e = ano;
			
		String fecha = ano+"-"+mes+"-"+dia;
		
		//fecha1 = LocalDate.parse(fecha);

       // fecha1 = fecha1.plusDays(7);
        
		
		
	}

	public int getDia_e() {
		return dia_e;
	}

	public void setDia_e(int dia_e) {
		this.dia_e = dia_e;
	}
	
	
}
