package co.edu.unbosque.model;

public class Tablero {

	private String[][] matriz;

	public Tablero() {
		matriz = new String[4][4];
		// inicializarComponentes();
	}

//quizas no se use este metodo
	public void inicializarComponentes() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = "-";
			}
		}
	}

	public void cambiarColor(int fila, int columna, String color) {
		matriz[fila][columna] = color;
	}

	public String mostrarMatriz() {
		StringBuilder aux = new StringBuilder();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				aux.append(matriz[i][j] == null ? "-" : matriz[i][j]);
				aux.append(" ");
			}
			aux.append("\n");
		}
		return aux.toString();
	}

	public String[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}
}