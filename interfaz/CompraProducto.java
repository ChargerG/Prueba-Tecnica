package interfaz;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene todos los m�todos implementados y construye toda la
 * interfaz gr�fica con la que el usuario va a interactuar, la clase hereda de
 * la clase JFrame para poder utilizar todos sus componentes gr�ficos e
 * implementa ActionListener y ItemListener para capturar los eventos que se den
 * cuando se ejecuta esta interfaz.
 * 
 * @author Cristian Camilo Gonz�lez Ramos
 *
 */
public class CompraProducto extends JFrame implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> box1;
	private JButton boton1, boton2, boton3, boton4, boton5;
	private JLabel label1, label2, label3, label4, label5;
	private JTextField field1, field2, field3;
	private JPanel panel1;

	private String producto = "", ruta = "";
	private int articulo = 0, unidades = 0, cantidadActual = 0;
	private List<Integer> cantidad = new ArrayList<Integer>();
	private List<String> articulos = new ArrayList<String>();

	public CompraProducto() {
		setTitle("Productos");
		getContentPane().setBackground(new Color(200, 200, 200));
		setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource("images-icon/marvel-icon.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Valores iniciales de las unidades de la lista por defecto.
		cantidad.add(5);
		cantidad.add(10);
		cantidad.add(15);
		cantidad.add(4);
		cantidad.add(8);
		cantidad.add(18);
		cantidad.add(6);
		cantidad.add(2);
		cantidad.add(3);

		// Valores iniciales de los articulos de la lista por defecto.
		articulos.add("Camiseta Marvel");
		articulos.add("Chanclas Capitan America");
		articulos.add("Cojin Capitan America");
		articulos.add("Gorra X-Men Marvel");
		articulos.add("Guantelete Iron Man Marvel");
		articulos.add("Lampara Iron Man Marvel");
		articulos.add("Maleta Marvel");
		articulos.add("Martillo de Thor Marvel");
		articulos.add("Ant-Man Marvel");

		// Formaci�n del label1.
		label1 = new JLabel("Seleccione el Producto:");
		label1.setBounds(50, 20, 300, 100);
		label1.setForeground(new Color(255, 255, 255));
		label1.setFont(new Font("Times New Roman", 1, 30));
		add(label1);

		// Formaci�n el label2.
		label2 = new JLabel("Cantidad de Unidades:");
		label2.setBounds(355, 100, 300, 100);
		label2.setForeground(new Color(2, 18, 44));
		label2.setFont(new Font("Times New Roman", 1, 18));
		add(label2);

		// Formaci�n del box1.
		box1 = new JComboBox<String>();
		box1.setBounds(50, 130, 280, 45);
		box1.setFont(new Font("Times New Roman", 1, 14));
		box1.setForeground(new Color(2, 18, 44));
		box1.addItemListener(this);
		add(box1);
		for (int i = 0; i < articulos.size(); i++) {
			box1.addItem(articulos.get(i));
		}

		// Formaci�n del label2.
		label3 = new JLabel();
		label3.setBounds(355, 180, 220, 240);
		label3.setBackground(new Color(255, 255, 255));
		add(label3);

		// Formaci�n del boton1.
		boton1 = new JButton("Ver Articulo");
		boton1.setBounds(115, 430, 100, 50);
		boton1.setForeground(new Color(255, 255, 255));
		boton1.setFont(new Font("Andale Mono", 1, 10));
		boton1.setBackground(new Color(190, 190, 190));
		boton1.addActionListener(this);
		add(boton1);

		// Formaci�n del boton2.
		boton2 = new JButton("Agregar");
		boton2.setBounds(235, 430, 100, 50);
		boton2.setForeground(new Color(255, 255, 255));
		boton2.setFont(new Font("Andale Mono", 1, 10));
		boton2.setBackground(new Color(190, 190, 190));
		boton2.addActionListener(this);
		boton2.setEnabled(false);
		add(boton2);

		// Formaci�n del boton3.
		boton3 = new JButton("Quitar");
		boton3.setBounds(355, 430, 100, 50);
		boton3.setForeground(new Color(255, 255, 255));
		boton3.setFont(new Font("Andale Mono", 1, 10));
		boton3.setBackground(new Color(190, 190, 190));
		boton3.addActionListener(this);
		boton3.setEnabled(false);
		add(boton3);

		// Formaci�n del boton4.
		boton4 = new JButton("Comprar");
		boton4.setBounds(475, 430, 100, 50);
		boton4.setForeground(new Color(255, 255, 255));
		boton4.setFont(new Font("Andale Mono", 1, 10));
		boton4.setBackground(new Color(190, 190, 190));
		boton4.setEnabled(false);
		boton4.addActionListener(this);
		add(boton4);

		// Formaci�n del panel1.
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(50, 500, 525, 150);
		panel1.setBackground(new Color(190, 190, 190));
		add(panel1);

		// Formaci�n del label3.
		label4 = new JLabel("Nombre del Producto Nuevo:");
		label4.setBounds(50, 10, 200, 30);
		label4.setForeground(new Color(2, 18, 44));
		label4.setFont(new Font("Times New Roman", 1, 15));
		panel1.add(label4);

		// Formaci�n del label4.
		label5 = new JLabel("Cantidad de Unidades:");
		label5.setBounds(50, 74, 150, 30);
		label5.setForeground(new Color(2, 18, 44));
		label5.setFont(new Font("Times New Roman", 1, 15));
		panel1.add(label5);

		// Formaci�n del field1.
		field1 = new JTextField("");
		field1.setBounds(50, 42, 190, 30);
		field1.setForeground(new Color(2, 18, 44));
		field1.setFont(new Font("Times New Roman", 1, 15));
		field1.setBackground(new Color(240, 240, 240));
		panel1.add(field1);

		// Formaci�n del field2.
		field2 = new JTextField("");
		field2.setBounds(50, 106, 150, 30);
		field2.setForeground(new Color(2, 18, 44));
		field2.setFont(new Font("Times New Roman", 1, 15));
		field2.setBackground(new Color(240, 240, 240));
		panel1.add(field2);

		// Formaci�n del boton5.
		boton5 = new JButton("Agregar Articulo Nuevo");
		boton5.setBounds(280, 74, 200, 60);
		boton5.setForeground(new Color(255, 255, 255));
		boton5.setFont(new Font("Andale Mono", 1, 14));
		boton5.setBackground(new Color(2, 18, 44));
		boton5.addActionListener(this);
		panel1.add(boton5);

		// Formaci�n del field3.
		field3 = new JTextField();
		field3.setBounds(535, 130, 40, 45);
		field3.setForeground(new Color(2, 18, 44));
		field3.setFont(new Font("Times New Roman", 1, 18));
		field3.setBackground(new Color(255, 255, 255));
		field3.setDisabledTextColor(new Color(255, 255, 255));
		field3.setEditable(false);
		field3.setHorizontalAlignment(JTextField.CENTER);
		add(field3);
	}

	/**
	 * Este m�todo retorna la cantidad actual de un articulo en existencia este
	 * valor se implementa para poder realizar operaci�n de adici�n y sustraci�n
	 * para ir cambiado ese valor en la base de datos.
	 * 
	 * En este caso la base de datos es en la memoria.
	 * 
	 * Por ejemplo: Se tienen 15 camisetas marvel.
	 * 
	 * @return Devuelve el numero de articulos de un producto en un entero.
	 */
	public int cantidadArticulos() {
		cantidadActual = cantidad.get(articulo);
		return cantidadActual;
	}

	/**
	 * Este m�todo es el encargado de seleccionar la ruta de donde se obtendr�n las
	 * imagenes, tanto aquellas que est�n en la carpeta images-productos por
	 * defecto, como aquellas que est�n siendo agregadas cuando se desea agregar un
	 * producto nuevo a la base de datos.
	 * 
	 * El m�todo se encarga de retornar la ruta para buscar el elemento.
	 * 
	 * @return Devuelve un String conteniendo la ruta para buscar los articulo
	 *         existentes en la base de datos.
	 */
	public String seleccionarProducto() {
		ruta = "src/interfaz/images-productos/" + producto + ".png";
		return ruta;
	}

	/**
	 * M�todo que no devuelve nada pero utiliza dos m�todos mas, los cuales son
	 * guardarImagen() y crearImagen con los cuales se divide el proceso de lectura,
	 * guardar y copiado del archivo que se desea agregar.
	 */
	public void leerImagen() {
		int incremento = 0;
		String ruta = "";
		JFileChooser fileC1 = new JFileChooser();
		FileInputStream archivo;
		fileC1.showOpenDialog(this);
		try {
			ruta = fileC1.getSelectedFile().getPath();
			archivo = new FileInputStream(ruta);
			boolean confirmacion = false;
			while (!confirmacion) {

				int bytes = archivo.read();
				if (bytes == -1) {
					confirmacion = true;
				}

				incremento++;
			}
			archivo.close();
		} catch (IOException e) {
			Object opcion[] = { "Aceptar" };
			JOptionPane.showOptionDialog(null, "Error " + e + " No se pudo encontrar el Archivo", "Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, opcion, null);
		}
		guardarImagen(incremento, ruta);
	}

	/**
	 * Este m�todo se encarga guardar la imagen que ya ha sido ubicada por el m�todo
	 * leerImagen para poder hacer esto se debe conocer el tama�o en bytes de la
	 * imagen, este argumento es el "peso" el cual define el tama�o del arreglo para
	 * guardar la imagen.
	 * 
	 * Tambi�n se necesita la "ruta" otro argumento que recibe este m�todo, este
	 * elemento lo necesita para poder guardar los bytes de la imagen dentro del
	 * arreglo ya mensionado.
	 * 
	 * @param peso Almacena el peso de la iamgen en un entero y da el tama�o al
	 *             arreglo contieniente en este m�todo.
	 * @param ruta Almacena la ruta para poder buscar el articulo nuevo que se
	 *             agregara a la base de datos.
	 */
	public void guardarImagen(int peso, String ruta) {
		int imagen[] = new int[peso];
		int incremento = 0;
		FileInputStream archivoLeido;
		try {
			archivoLeido = new FileInputStream(ruta);

			boolean confirmacion = false;
			while (!confirmacion) {

				int bytes = archivoLeido.read();

				if (bytes != -1) {
					imagen[incremento] = bytes;
				} else {

					confirmacion = true;

				}

				incremento++;
			}

			archivoLeido.close();
		} catch (IOException e) {

			Object opcion[] = { "Aceptar" };
			JOptionPane.showOptionDialog(null, "Error " + e + " No se pudo leer el Archivo", "Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, opcion, null);
		}

		crearImagen(imagen);

	}

	/**
	 * Este m�todo recibe como argumento un arreglo el cual contiene los bytes de la
	 * imagen ya leida, este es el proceso final para copiar la imagen en la ruta
	 * que se especifica en el m�todo.
	 * 
	 * @param archivoNuevo Alacena un array para recorrerlo y obtener su
	 *                     configuraci�n en bytes para copiar el archivo en la base
	 *                     de datos, en este caso la carpeta images-productos del
	 *                     proyecto.
	 */
	public void crearImagen(int archivoNuevo[]) {
		try {
			FileOutputStream archivoCopiado = new FileOutputStream(
					"D:/Escritorio/Cidenet/src/interfaz/images-productos/" + field1.getText() + ".png");
			for (int i = 0; i < archivoNuevo.length; i++) {
				archivoCopiado.write(archivoNuevo[i]);
			}

			archivoCopiado.close();
			Object opcion0[] = { "Continuar" };
			JOptionPane.showOptionDialog(null, "Carga Exitosa", "Proceso Listo", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, opcion0, null);
			articulos.add(field1.getText());
			box1.addItem(field1.getText());
		} catch (IOException e) {
			Object opcion1[] = { "Aceptar" };
			JOptionPane.showOptionDialog(null, "Error " + e + " No se pudo copiar el Archivo", "Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, opcion1, null);
		}

	}

	/**
	 * Este m�todo solo verifica que el usuario no pueda comprar mas articulos de
	 * los existentes en la base de datos, este m�todo no retorna nada y se invoca
	 * en los elementos gr�ficos con eventos.
	 */
	public void comprarMasDeMenos() {
		if (unidades > cantidad.get(articulo)) {
			boton2.setEnabled(false);
			field3.setText(String.valueOf(unidades));
			Object opcion[] = { "Aceptar" };
			JOptionPane.showOptionDialog(null, unidades + " Articulos supera el m�ximo en Existencia", "Alerta",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcion, null);
		}
	}

	/**
	 * Este m�todo solo verifica que el usuario no realice la compra de cero
	 * articulos de los existentes en la base de datos, este m�todo no retorna nada
	 * y se invoca en los elementos gr�ficos con eventos.
	 */
	public void comprarMenosDeMas() {
		if (unidades == 0) {
			boton3.setEnabled(false);
			field3.setText(String.valueOf(unidades));
			Object opcion[] = { "Aceptar" };
			JOptionPane.showOptionDialog(null, "No puede comprar " + unidades + " Articulos agregue Elementos",
					"Alerta", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcion, null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == boton1) {
			ImageIcon imagen = new ImageIcon(seleccionarProducto());
			Icon icono = new ImageIcon(
					imagen.getImage().getScaledInstance(label3.getWidth(), label3.getHeight(), Image.SCALE_DEFAULT));
			label3.setIcon(icono);
			this.repaint();
			boton2.setEnabled(true);
			boton3.setEnabled(true);
		}

		if (e.getSource() == boton2) {
			field3.setText(String.valueOf(unidades++ + 1));
			boton3.setEnabled(true);
			boton4.setEnabled(true);
			comprarMasDeMenos();
		}

		if (e.getSource() == boton3) {
			field3.setText(String.valueOf(unidades-- - 1));
			boton2.setEnabled(true);
			comprarMenosDeMas();
		}

		if (e.getSource() == boton4) {

			Object opcion[] = { "Continuar", "Cancelar" };

			if (unidades > 0 && unidades <= cantidad.get(articulo)) {
				int valor = JOptionPane.showOptionDialog(null, "�Realizar Compra de " + (unidades) + " Articulos?",
						"Mensaje", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, opcion[0]);
				if (valor == 0) {
					Object opcion1[] = { "Gracias por tu Compra" };
					JOptionPane.showOptionDialog(null,
							"Compra Efectuada Articulos Restantes: " + (cantidadArticulos() - unidades),
							"Compra Exitosa", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
							opcion1, null);
				}
			}

			comprarMasDeMenos();
			comprarMenosDeMas();
		}

		if (e.getSource() == boton5) {

			if (field1.getText().equals("") || field2.getText().toString().equals("")) {

				Object opcion[] = { "Aceptar" };
				JOptionPane.showOptionDialog(null, "Llene todos los campos", "Alerta", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, opcion, null);

			} else {
				try {
					cantidad.add(Integer.parseInt(field2.getText()));
					leerImagen();
				} catch (NumberFormatException e1) {
					Object opcion[] = { "Aceptar" };
					JOptionPane.showOptionDialog(null, "Error " + e1 + " Ingrese solo valores Num�ricos", "Error",
							JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, opcion, null);
				}
			}

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == box1) {
			producto = box1.getSelectedItem().toString();
			articulo = box1.getSelectedIndex();
			setTitle(producto);

		}
	}

	/**
	 * Este m�todo permite retornar la lista cantidad de tipo Integer para ser
	 * implementado en otras clases, en este caso se utiliza para las pruebas
	 * unitarias.
	 * 
	 * @return Retorna la lista cantidad con los elementos que contiene actualmente
	 *         que son valores Integer.
	 */
	public List<Integer> getCantidad() {
		return cantidad;
	}
	
	/**
	 * Este m�todo permite retornar la lista articulos de tipo String para ser
	 * implementado en otras clases, en este caso se utiliza para las pruebas
	 * unitarias.
	 * 
	 * @return Retorna la lista articulos con los elementos que contiene actualmente
	 *         que son valores String.
	 */
	public List<String> getArticulo(){
		return articulos;
	}
	
	/**
	 * Este m�todo dise�a la ventana contenedora de todos los elementos de la
	 * interfaz de ususario, es invocado en la clase Bienvenida para continuar
	 * despu�s de haber ingresado al entorno de trabajo.
	 */
	public void iniciarVentana() {
		CompraProducto ventana2 = new CompraProducto();
		ventana2.setBounds(0, 0, 635, 700);
		ventana2.setVisible(true);
		ventana2.setResizable(false);
		ventana2.setLocationRelativeTo(null);
	}

}
