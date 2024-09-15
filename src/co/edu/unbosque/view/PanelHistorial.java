package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelHistorial extends JPanel {

	private JTextArea historial;
	private JScrollPane scroll;

	public PanelHistorial() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setBorder(new TitledBorder("Historial"));
		
		historial = new JTextArea();
		inicializarComponentes();

		setVisible(true);
	}

	public void inicializarComponentes() {
		historial.setEditable(false); // En false hace que el JTextArea no sea editable
		historial.setLineWrap(true); // Ajusta el texto automáticamente
		// historial.setWrapStyleWord(true); // Ajusta el texto por palabra
		scroll = new JScrollPane(historial);
		add(scroll, BorderLayout.CENTER);
	}

	// Añadir movimientos al historial
	public void añadirMovimientos(String movimiento) {
		historial.append(movimiento + "\n");
	}

	// Mostrar el historial que se guarde en el archivo
	public void cargarHistorial(String[] movimientos) {
		for (String movimiento : movimientos) {
			historial.append(movimiento + "\n");
		}
	}

}