package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelMenu extends JPanel {

	private JTextField txtNombre1, txtNombre2, txtVS;
	private JButton btnNuevaPartida, btnCambioJugador, btnCargarHistorial;

	public PanelMenu() {
		setLayout(new GridLayout(2, 3));
		setBackground(Color.WHITE);
		setBorder(new TitledBorder("Historial"));

		inicializarComponentes();

		setVisible(true);
	}

	public void inicializarComponentes() {
		txtNombre1 = new JTextField("Jugador 1");
		txtNombre1.setEditable(false);
		add(txtNombre1);

		txtVS = new JTextField("VS");
		txtVS.setEditable(false);
		add(txtVS);

		txtNombre2 = new JTextField("Jugador 2");
		txtNombre2.setEditable(false);
		add(txtNombre2);

		btnNuevaPartida = new JButton("Iniciar");
		btnNuevaPartida.setActionCommand("INICIAR PARTIDA");
		add(btnNuevaPartida);

		btnCambioJugador = new JButton("Cambio");
		btnCambioJugador.setActionCommand("CAMBIAR DE JUGADOR");
		add(btnCambioJugador);

		btnCargarHistorial = new JButton("Cargar");
		btnCargarHistorial.setActionCommand("CARGAR PARTIDAS");
		add(btnCargarHistorial);
	}

	public JTextField getTxtNombre1() {
		return txtNombre1;
	}

	public void setTxtNombre1(JTextField txtNombre1) {
		this.txtNombre1 = txtNombre1;
	}

	public JTextField getTxtNombre2() {
		return txtNombre2;
	}

	public void setTxtNombre2(JTextField txtNombre2) {
		this.txtNombre2 = txtNombre2;
	}

	public JTextField getTxtVS() {
		return txtVS;
	}

	public void setTxtVS(JTextField txtVS) {
		this.txtVS = txtVS;
	}

	public JButton getBtnNuevaPartida() {
		return btnNuevaPartida;
	}

	public void setBtnNuevaPartida(JButton btnNuevaPartida) {
		this.btnNuevaPartida = btnNuevaPartida;
	}

	public JButton getBtnCambioJugador() {
		return btnCambioJugador;
	}

	public void setBtnCambioJugador(JButton btnCambioJugador) {
		this.btnCambioJugador = btnCambioJugador;
	}

	public JButton getBtnCargarHistorial() {
		return btnCargarHistorial;
	}

	public void setBtnCargarHistorial(JButton btnCargarHistorial) {
		this.btnCargarHistorial = btnCargarHistorial;
	}
}