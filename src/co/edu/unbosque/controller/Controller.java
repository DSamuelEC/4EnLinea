package co.edu.unbosque.controller;

import java.awt.Color;

import co.edu.unbosque.model.Tablero;
import co.edu.unbosque.view.VistaPrincipal;
import co.edu.unbosque.view.VistaVentanaEmergente;

public class Controller {

	private VistaPrincipal ventana;
	private Tablero tablero;
	private VistaVentanaEmergente emergente;

	public Controller() {
		this.emergente = new VistaVentanaEmergente();
		this.ventana = new VistaPrincipal();
		this.tablero = new Tablero();
		
		cambiarColor(0, 3, "rojo");
		cambiarColor(1, 1, "azul");
		cambiarColor(1, 2, "rojo");
		cambiarColor(1, 3, "azul");

		emergente.leerDatoString("Nombre: ");
	}
	
	public void cambiarColor(int fila, int columna, String color) {
		tablero.cambiarColor(fila, columna, color);
		ventana.getpTablero().cambiarColor(fila, columna, color);
	}
}