package interfaz;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

/**
 * Esta clase pretende construir una interfaz gráfica para la manipulación de
 * articulos de una tienda, donde se da la bienvenida al usuario.
 * 
 * @author Cristian Camilo González Ramos
 *
 */
public class Bienvenida extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton boton1;
	private JLabel label1, label2;

	public Bienvenida() {

		setTitle("Bienvenido");
		getContentPane().setBackground(new Color(2, 18, 44));
		setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource("images-icon/marvel-icon.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Formación del label1.
		label1 = new JLabel("Tienda Marvel");
		label1.setBounds(50, 20, 200, 100);
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(new Font("Times New Roman", 1, 30));
		add(label1);

		// Formación del label2.
		ImageIcon logo = new ImageIcon("src/interfaz/images-icon/marvel-logo-b.png");
		label2 = new JLabel(logo);
		label2.setBounds(50, 125, 200, 100);
		add(label2);

		// Formación del boton1.
		boton1 = new JButton("Ingresar");
		boton1.setBounds(100, 260, 100, 50);
		boton1.setForeground(new Color(255, 255, 255));
		boton1.setFont(new Font("Andale Mono", 1, 15));
		boton1.setBackground(new Color(190, 190, 190));
		boton1.addActionListener(this);
		add(boton1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {
			CompraProducto ventana2 = new CompraProducto();
			ventana2.iniciarVentana();
			this.setVisible(false);
		}
	}

	public static void main(String args[]) {
		Bienvenida ventana1 = new Bienvenida();
		ventana1.setBounds(0, 0, 300, 420);
		ventana1.setVisible(true);
		ventana1.setResizable(false);
		ventana1.setLocationRelativeTo(null);
	}

}
