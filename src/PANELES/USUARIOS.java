package PANELES;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Conexion.Conexion;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class USUARIOS extends JPanel {
	private JTextField TF_BUSUARIO;
	private JTextField TF_BLIBRO;
	private JTable TABLA_USUARIO;
	//nuevos
	int UsorLib = 0;
	

	/**
	 * Create the panel.
	 */
	public USUARIOS() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Proyecto final\\Fotos\\USUARIO.png"));
		lblNewLabel_1.setBounds(206, 11, 396, 118);
		add(lblNewLabel_1);
		
		JButton BT_BUSUARIO = new JButton("Buscar usuario");
		BT_BUSUARIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nusuario = TF_BUSUARIO.getText();
				UsorLib = 0;
				Refrescar();
				Select_Usuario(Nusuario);
				
			}
		});
		BT_BUSUARIO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_BUSUARIO.setContentAreaFilled(false);
		BT_BUSUARIO.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_BUSUARIO.setBackground(Color.BLACK);
		BT_BUSUARIO.setBounds(136, 174, 222, 45);
		add(BT_BUSUARIO);
		
		JButton BT_BLIBRO = new JButton("Buscar libro");
		BT_BLIBRO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nlibro = TF_BLIBRO.getText();
				UsorLib = 1;
				Refrescar();
				Select_Usuario(Nlibro);
				
			}
		});
		BT_BLIBRO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_BLIBRO.setContentAreaFilled(false);
		BT_BLIBRO.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_BLIBRO.setBackground(Color.BLACK);
		BT_BLIBRO.setBounds(447, 174, 222, 45);
		add(BT_BLIBRO);
		
		TF_BUSUARIO = new JTextField();
		TF_BUSUARIO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_BUSUARIO.setBounds(136, 230, 222, 45);
		add(TF_BUSUARIO);
		TF_BUSUARIO.setColumns(10);
		
		TF_BLIBRO = new JTextField();
		TF_BLIBRO.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		TF_BLIBRO.setColumns(10);
		TF_BLIBRO.setBounds(447, 230, 222, 45);
		add(TF_BLIBRO);
		
		JPanel P_TABLA = new JPanel();
		P_TABLA.setBounds(0, 286, 808, 317);
		add(P_TABLA);
		P_TABLA.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		P_TABLA.add(scrollPane, BorderLayout.CENTER);
		
		TABLA_USUARIO = new JTable();
		TABLA_USUARIO.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(TABLA_USUARIO);

	}
	
	
	DefaultTableModel dtm = new DefaultTableModel();
	
	public String Select_Usuario(String nombre) {
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
			
			if(UsorLib == 0) {
				rs = stm.executeQuery("Select Nombre_usuario , Nombre_libro , Dia_prestamo , Dia_entrega from prestamos where (Nombre_usuario = '"+nombre+"');");
				
				String[] titulo = new String[] {"Usuario", "Libro", "Dia de Prestamo", "Dia de entrega"};
				dtm.setColumnIdentifiers(titulo);
				TABLA_USUARIO.setModel(dtm);
				
			}else {
				rs = stm.executeQuery("Select Nombre_libro , Nombre_usuario , Dia_prestamo , Dia_entrega from prestamos where (Nombre_libro = '"+nombre+"');");
				
				String[] titulo = new String[] {"Libro", "Usuario", "Dia de Prestamo", "Dia de entrega"};
				dtm.setColumnIdentifiers(titulo);
				TABLA_USUARIO.setModel(dtm);
				
			}
			
			
			
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			
			int numCol = rsmd.getColumnCount();
			
			
			while (rs.next()/**/) {
				
				
				Object [] fila = new Object[numCol];
				
				for(int i = 0 ; i < numCol; i++){
					fila[i] = rs.getObject(i + 1);
				}
				
				dtm.addRow(fila);
				
			
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
			return "";
		}
	
	public void Refrescar() {
		
		if(TABLA_USUARIO.getRowCount() != 0) {
			for(int i = 0 ;i <= dtm.getRowCount() ; i++) {
			dtm.removeRow(0);
		}
		}
		
	}
	
}
