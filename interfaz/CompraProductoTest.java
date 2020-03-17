package interfaz;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class CompraProductoTest {

	CompraProducto llamar = new CompraProducto();

	@Test
	public void testIniciarVentana() {
		llamar.setBounds(0, 0, 635, 700);
		llamar.setVisible(true);
		llamar.setResizable(false);
		llamar.setLocationRelativeTo(null);
	}

	@Test
	public void testCantidadArticulos() {
		int cantidadActual = llamar.getCantidad().get(0);
		int cantidadEsperada = 5;
		assertEquals(cantidadEsperada, cantidadActual);
	}

	@Test
	public void testSeleccionarProducto() {
		String ruta = "src/interfaz/images-productos/" + llamar.getArticulo().get(0) + ".png";
		String rutaEsperada = "src/interfaz/images-productos/Camiseta Marvel.png";
		assertEquals(rutaEsperada, ruta);
	}

	@Test
	public void testComprarMasDeMenos() {
		int unidades = 11;
		if (unidades > llamar.getCantidad().get(1)) {
			// boton2.setEnabled(false);
			// field3.setText(String.valueOf(unidades));
			Object opcion[] = { "Aceptar" };
			JOptionPane.showOptionDialog(null, unidades + " Articulos supera el máximo en Existencia", "Alerta",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcion, null);
		}
	}

	@Test
	public void testComprarMenosDeMas() {
		int unidades = 0;
		if (unidades == 0) {
			// boton3.setEnabled(false);
			// field3.setText(String.valueOf(unidades));
			Object opcion[] = { "Aceptar" };
			JOptionPane.showOptionDialog(null, "No puede comprar " + unidades + " Articulos agregue Elementos",
					"Alerta", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcion, null);
		}
	}

}
