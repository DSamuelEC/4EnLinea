package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelTablero extends JPanel {

	private JLabel[][] matrizJL;

	public PanelTablero() {
		//setSize(400, 400);
		setLayout(new GridLayout(4, 4));
		setBackground(Color.BLACK);
		
		this.matrizJL = new JLabel[4][4];
		inicializarComponentes();

		setVisible(true);
	}

	public void inicializarComponentes() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrizJL[i][j] = new JLabel("");
				matrizJL[i][j].setOpaque(true); // Para poder cambiar el fondo de color
				matrizJL[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				add(matrizJL[i][j]);
			}
		}
	}

	public void cambiarColor(int fila, int columna, String color) {
		switch (color) {
		case "rojo":
			matrizJL[fila][columna].setBackground(Color.RED);
			break;
		case "azul":
			matrizJL[fila][columna].setBackground(Color.BLUE);
			break;
		default:
			break;
		}
	}
}
