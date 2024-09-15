package co.edu.unbosque.controller;

import co.edu.unbosque.model.Tablero;
import co.edu.unbosque.view.VistaPrincipal;
import co.edu.unbosque.view.VistaVentanaEmergente;
import co.edu.unbosque.view.PanelTablero.TableroListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private VistaPrincipal ventana;
	private Tablero tablero;
	private VistaVentanaEmergente emergente;
	private String turno;

	public Controller() {
		this.emergente = new VistaVentanaEmergente();
		this.ventana = new VistaPrincipal();
		this.tablero = new Tablero();
		this.turno = "rojo"; // El juego empieza con el turno del rojo
		asignarOyentes();
	}

	public void asignarOyentes() {
		ventana.getpTablero().setTableroListener(new TableroListener() {
			@Override
			public void celdaClickeada(int fila, int columna) {
				manejarClicEnCelda(fila, columna);
			}
		});

		ventana.getpMenu().getBtnNuevaPartida().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarNuevaPartida();
			}
		});

		ventana.getpMenu().getBtnCambioJugador().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarJugador();
			}
		});

		ventana.getpMenu().getBtnCargarHistorial().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarHistorial();
			}
		});
	}

	public void manejarClicEnCelda(int fila, int columna) {
		if (tablero.getMatriz()[fila][columna] == null) {
			cambiarColor(fila, columna, turno);
			registrarMovimiento(fila, columna, turno);
			cambiarTurno();
		} else {
			emergente.mostrarInformacion("La celda ya está ocupada.");
		}
	}

	public void cambiarColor(int fila, int columna, String color) {
		tablero.cambiarColor(fila, columna, color);
		ventana.getpTablero().cambiarColor(fila, columna, color);
	}

	public void registrarMovimiento(int fila, int columna, String color) {
		String movimiento = "Fila: " + fila + ", Columna: " + columna + ", Color: " + color;
		ventana.getpHistorial().añadirMovimientos(movimiento);
	}

	public void cambiarTurno() {
		turno = turno.equals("rojo") ? "azul" : "rojo";
	}

	public void iniciarNuevaPartida() {
		tablero = new Tablero();
		ventana.getpTablero().removeAll();
		ventana.getpTablero().inicializarComponentes();
		ventana.getpHistorial().añadirMovimientos("Nueva partida iniciada");
		turno = "rojo";
	}

	public void cambiarJugador() {
		String jugador1 = ventana.getpMenu().getTxtNombre1().getText();
		String jugador2 = ventana.getpMenu().getTxtNombre2().getText();
		ventana.getpMenu().getTxtNombre1().setText(jugador2);
		ventana.getpMenu().getTxtNombre2().setText(jugador1);
		ventana.getpHistorial().añadirMovimientos("Cambio de jugadores: " + jugador1 + " y " + jugador2);
	}

	public void cargarHistorial() {
		// Aquí puedes implementar la lógica para cargar el historial desde un archivo o
		// base de datos
		emergente.mostrarInformacion("Funcionalidad de cargar historial no implementada.");
	}
}