package MyProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

import PANELES.ALQUILER;
import PANELES.DEVOLUCIONES;
import PANELES.LIBROS;
import PANELES.PRINCIPAL;
import PANELES.USUARIOS;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	
	JPanel content;
	JPanel P_BOTONES;
	JButton BT_PRINCIPAL;
	JButton BT_ALQUILER;
	JButton BT_DEVOLUCIONES;
	JButton BT_USUARIOS;
	JButton BT_LIBROS;
	JLabel lblNewLabel_1;
	JPanel P_BARRA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		P_BOTONES = new JPanel();
		P_BOTONES.setBackground(new Color(139, 0, 0));
		P_BOTONES.setBounds(0, 0, 264, 651);
		contentPane.add(P_BOTONES);
		P_BOTONES.setLayout(null);
		
		BT_PRINCIPAL = new JButton("PRINCIPAL");
		BT_PRINCIPAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PRINCIPAL P1 = new PRINCIPAL();
				P1.setSize(809, 603);
				P1.setLocation(0, 0);
				
				content.removeAll();
				content.add(P1, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		BT_PRINCIPAL.setForeground(Color.WHITE);
		BT_PRINCIPAL.setContentAreaFilled(false);
		BT_PRINCIPAL.setBackground(new Color(240, 248, 255));
		BT_PRINCIPAL.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_PRINCIPAL.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_PRINCIPAL.setBounds(10, 253, 244, 45);
		P_BOTONES.add(BT_PRINCIPAL);
		
		BT_ALQUILER = new JButton("PRESTAR");
		BT_ALQUILER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ALQUILER P1 = new ALQUILER();
				P1.setSize(809, 603);
				P1.setLocation(0, 0);
				
				content.removeAll();
				content.add(P1, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		BT_ALQUILER.setForeground(Color.WHITE);
		BT_ALQUILER.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_ALQUILER.setContentAreaFilled(false);
		BT_ALQUILER.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_ALQUILER.setBackground(new Color(240, 248, 255));
		BT_ALQUILER.setBounds(10, 326, 244, 45);
		P_BOTONES.add(BT_ALQUILER);
		
		BT_DEVOLUCIONES = new JButton("DEVOLUCIONES");
		BT_DEVOLUCIONES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DEVOLUCIONES P1 = new DEVOLUCIONES();
				P1.setSize(809, 603);
				P1.setLocation(0, 0);
				
				content.removeAll();
				content.add(P1, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
				
			}
		});
		BT_DEVOLUCIONES.setForeground(Color.WHITE);
		BT_DEVOLUCIONES.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_DEVOLUCIONES.setContentAreaFilled(false);
		BT_DEVOLUCIONES.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_DEVOLUCIONES.setBackground(new Color(240, 248, 255));
		BT_DEVOLUCIONES.setBounds(10, 393, 244, 45);
		P_BOTONES.add(BT_DEVOLUCIONES);
		
		BT_USUARIOS = new JButton("USUARIO");
		BT_USUARIOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				USUARIOS P1 = new USUARIOS();
				P1.setSize(809, 603);
				P1.setLocation(0, 0);
				
				content.removeAll();
				content.add(P1, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		BT_USUARIOS.setForeground(Color.WHITE);
		BT_USUARIOS.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_USUARIOS.setContentAreaFilled(false);
		BT_USUARIOS.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_USUARIOS.setBackground(new Color(240, 248, 255));
		BT_USUARIOS.setBounds(10, 461, 244, 45);
		P_BOTONES.add(BT_USUARIOS);
		
		BT_LIBROS = new JButton("LIBROS");
		BT_LIBROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LIBROS P1 = new LIBROS();
				P1.setSize(809, 603);
				P1.setLocation(0, 0);
				
				content.removeAll();
				content.add(P1, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		BT_LIBROS.setForeground(Color.WHITE);
		BT_LIBROS.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		BT_LIBROS.setContentAreaFilled(false);
		BT_LIBROS.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_LIBROS.setBackground(new Color(240, 248, 255));
		BT_LIBROS.setBounds(10, 535, 244, 45);
		P_BOTONES.add(BT_LIBROS);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Proyecto final\\Fotos\\name 2.png"));
		lblNewLabel_1.setBounds(29, 71, 212, 148);
		P_BOTONES.add(lblNewLabel_1);
		
		P_BARRA = new JPanel();
		P_BARRA.setBackground(new Color(128, 128, 128));
		P_BARRA.setBounds(0, 0, 1073, 48);
		contentPane.add(P_BARRA);
		
		content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setBounds(264, 48, 809, 603);
		contentPane.add(content);
		content.setLayout(null);
		
		PRINCIPAL P1 = new PRINCIPAL();
		P1.setSize(809, 603);
		P1.setLocation(0, 0);
		
		content.removeAll();
		content.add(P1, BorderLayout.CENTER);
		content.revalidate();
		content.repaint();
		
		
	
		
		
	}
}
