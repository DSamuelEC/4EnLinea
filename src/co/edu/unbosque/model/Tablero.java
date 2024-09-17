package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;

public class Tablero {

	private String[][] matriz;
	private String historialArch;
	Archivo arch;

	public Tablero() {
		matriz = new String[4][4];
		arch = new Archivo();
		historialArch = "";
	}
	
	public String leerHistorial() {
		historialArch = arch.leerArchivo();
		return historialArch;
	}

	public String actualizarHistorial(String partida) {
		return arch.escribirArchivo(partida);
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