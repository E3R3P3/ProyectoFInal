package PANELES;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PRINCIPAL extends JPanel {

	/**
	 * Create the panel.
	 */
	public PRINCIPAL() {
		setLayout(null);
		
		JTextPane txtpnHeyHolaBienvenido = new JTextPane();
		txtpnHeyHolaBienvenido.setText("HEY, \r\nBienvenidos a la app ATHOS, Esta app es una biblioteca virtual para que nuestros usuarios puedan alquilar un libro de forma virtual.\r\n\r\nEsta app cuenta con varias herramientas como: alquileres de libros, ver la gran variedad de libros que les ofrece y sobre todo cuenta con una gran variedad de libros.\r\n\r\nSin mas espero que lo disfrute.\r\n");
		txtpnHeyHolaBienvenido.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 14));
		txtpnHeyHolaBienvenido.setBackground(SystemColor.menu);
		txtpnHeyHolaBienvenido.setAutoscrolls(false);
		txtpnHeyHolaBienvenido.setBounds(111, 312, 568, 205);
		add(txtpnHeyHolaBienvenido);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Proyecto final\\Fotos\\welcome.png"));
		lblNewLabel.setBounds(147, 85, 487, 193);
		add(lblNewLabel);

	}

}
