package co.edu.unbosque.model;

public class Tablero {

	private String[][] matriz;

	public Tablero() {
		matriz = new String[4][4];
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = "o" ;
			}
		}
		System.out.println(matriz);
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