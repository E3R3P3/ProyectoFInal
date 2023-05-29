package PANELES;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import Conexion.Conexion;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LIBROS extends JPanel {
	private JTextField TF_TITULO;
	private JTextField TF_IDIOMA;
	private JTextField TF_AUTOR;
	private JTextField TF_PAGINAS;
	private JTextField TF_CATEGORIA;
	private JTextField TF_EDICION;
	private JTextField TF_CANTIDAD;
	private JTextField TF_DISPONIBILIDAD;
	private JTextField txt_dia;
	private JTextField txt_mes;
	private JTextField txt_anios;
	//Nuevos
	String Titulo;
	String Autor;
	String dia;
	String mes;
	String ano;
	String Categoria;
	String Idioma;
	String Paginas;
	String Edicion;
	String Cantidad;
	String Disponibles;
	

	/**
	 * Create the panel.
	 */
	public LIBROS() {
		setLayout(null);
		
		TF_TITULO = new JTextField();
		TF_TITULO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_TITULO.setColumns(10);
		TF_TITULO.setBounds(32, 238, 222, 42);
		add(TF_TITULO);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblTitulo.setBounds(32, 194, 185, 33);
		add(lblTitulo);
		
		TF_IDIOMA = new JTextField();
		TF_IDIOMA.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_IDIOMA.setColumns(10);
		TF_IDIOMA.setBounds(537, 238, 222, 42);
		add(TF_IDIOMA);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblIdioma.setBounds(537, 194, 185, 33);
		add(lblIdioma);
		
		TF_AUTOR = new JTextField();
		TF_AUTOR.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_AUTOR.setColumns(10);
		TF_AUTOR.setBounds(32, 345, 222, 42);
		add(TF_AUTOR);
		
		JLabel lblAutor = new JLabel(" Autor del libro");
		lblAutor.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblAutor.setBounds(32, 301, 185, 33);
		add(lblAutor);
		
		TF_PAGINAS = new JTextField();
		TF_PAGINAS.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_PAGINAS.setColumns(10);
		TF_PAGINAS.setBounds(537, 345, 222, 42);
		add(TF_PAGINAS);
		
		JLabel lblPaginas = new JLabel("Paginas");
		lblPaginas.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblPaginas.setBounds(537, 301, 185, 33);
		add(lblPaginas);
		
		JLabel lblFechaDePublicacion = new JLabel("Fecha de publicacion");
		lblFechaDePublicacion.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblFechaDePublicacion.setBounds(285, 194, 185, 33);
		add(lblFechaDePublicacion);
		
		TF_CATEGORIA = new JTextField();
		TF_CATEGORIA.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_CATEGORIA.setColumns(10);
		TF_CATEGORIA.setBounds(285, 345, 222, 42);
		add(TF_CATEGORIA);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblCategoria.setBounds(285, 301, 185, 33);
		add(lblCategoria);
		
		JLabel lblEdicion = new JLabel("Edicion");
		lblEdicion.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblEdicion.setBounds(32, 415, 185, 33);
		add(lblEdicion);
		
		TF_EDICION = new JTextField();
		TF_EDICION.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_EDICION.setColumns(10);
		TF_EDICION.setBounds(32, 459, 222, 42);
		add(TF_EDICION);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblCantidad.setBounds(285, 415, 185, 33);
		add(lblCantidad);
		
		TF_CANTIDAD = new JTextField();
		TF_CANTIDAD.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_CANTIDAD.setColumns(10);
		TF_CANTIDAD.setBounds(285, 459, 222, 42);
		add(TF_CANTIDAD);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 16));
		lblDisponibilidad.setBounds(537, 415, 185, 33);
		add(lblDisponibilidad);
		
		TF_DISPONIBILIDAD = new JTextField();
		TF_DISPONIBILIDAD.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_DISPONIBILIDAD.setColumns(10);
		TF_DISPONIBILIDAD.setBounds(537, 459, 222, 42);
		add(TF_DISPONIBILIDAD);
		
		JButton BT_Register = new JButton("Agregar libro");
		BT_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Agregar Libor
				Titulo = TF_TITULO.getText();
				Idioma = TF_IDIOMA.getText();
				Autor = TF_AUTOR.getText();
				Paginas = TF_PAGINAS.getText();
				Categoria = TF_CATEGORIA.getText();
				Edicion = TF_EDICION.getText();
				Cantidad = TF_CANTIDAD.getText();
				Disponibles = TF_DISPONIBILIDAD.getText();
				dia = txt_dia.getText();
				mes = txt_mes.getText();
				ano = txt_anios.getText();
				
				RegistrarLibor();
				
			}
		});
		BT_Register.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_Register.setContentAreaFilled(false);
		BT_Register.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_Register.setBackground(Color.BLACK);
		BT_Register.setBounds(285, 529, 222, 45);
		add(BT_Register);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("Proyecto final\\Fotos\\NUEVO LIBRO.png"));
		lblNewLabel_1_1.setBounds(189, 23, 385, 160);
		add(lblNewLabel_1_1);
		
		txt_dia = new JTextField();
		txt_dia.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_dia.setColumns(10);
		txt_dia.setBounds(275, 238, 64, 42);
		add(txt_dia);
		
		JLabel lblFechaDe_1 = new JLabel("/");
		lblFechaDe_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 65));
		lblFechaDe_1.setBounds(341, 227, 20, 63);
		add(lblFechaDe_1);
		
		txt_mes = new JTextField();
		txt_mes.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_mes.setColumns(10);
		txt_mes.setBounds(363, 238, 64, 42);
		add(txt_mes);
		
		JLabel lblFechaDe_1_1 = new JLabel("/");
		lblFechaDe_1_1.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 65));
		lblFechaDe_1_1.setBounds(430, 227, 20, 63);
		add(lblFechaDe_1_1);
		
		txt_anios = new JTextField();
		txt_anios.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txt_anios.setColumns(10);
		txt_anios.setBounds(450, 238, 64, 42);
		add(txt_anios);

	}
	
	public void RegistrarLibor() {
		
		int X = 0;
		
		Conexion conexion = new Conexion();
		
			Connection cn = null;//creamos el objeto cn para pasar la conexion 
		
			Statement stm = null;//Creamos un objeto Statemen para dictar una sentencia sql
		
			ResultSet rs = null;//Creamos un objeto rs para pasar valores de la consulta a una variable
		
			try {
			
				cn = conexion.Conectar();//metodo que retorna la conexion
				stm = cn.createStatement();//le pasamos el objeto cn al stm para poder dictar instruciones
				//rs = stm.executeQuery("INSERT INTO `db_crud_final`.`usuarios` (`Nombre`, `Apellido`, `Clave`, `Telefono`, `Correo`) VALUES ('"+nombre+"', '"+apellido+"', '"+claveF+"', '"+telefono+"', '"+correo+"');");//aqui dictamos la sentencia SQL
				stm.executeUpdate("INSERT INTO `db_crud_final`.`libros` (`Titulo`, `Autor`, `Publicacion`, `Categoria`, `Idioma`, `Paginas`, `Edicion`, `Cantidad`, `Disponibles`) VALUES ('"+Titulo+"', '"+Autor+"', '"+ano+"-"+mes+"-"+dia+"', '"+Categoria+"', '"+Idioma+"', '"+Paginas+"', '"+Edicion+"', '"+Cantidad+"', '"+Disponibles+"');");
				
				JOptionPane.showMessageDialog(null, "Registrado.");
				
				
			
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al registrar.");
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
