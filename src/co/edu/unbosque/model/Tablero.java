package co.edu.unbosque.model;

public class Tablero {

	private String[][] matriz;

	public Tablero() {
		matriz = new String[4][4];
	}

	public void cambiarColor(int fila, int columna, String color) {
		matriz[fila][columna] = color;
	}
	
	public String[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}
}