package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;

public class Tablero {

    private String[][] matriz;
    private String historialArch;
    private Archivo arch;

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

    public String verificarGanador() {
        // Verificar filas
        for (int i = 0; i < 4; i++) {
            if (matriz[i][0] != null && matriz[i][0].equals(matriz[i][1]) && matriz[i][1].equals(matriz[i][2]) && matriz[i][2].equals(matriz[i][3])) {
                return matriz[i][0];
            }
        }

        // Verificar columnas
        for (int j = 0; j < 4; j++) {
            if (matriz[0][j] != null && matriz[0][j].equals(matriz[1][j]) && matriz[1][j].equals(matriz[2][j]) && matriz[2][j].equals(matriz[3][j])) {
                return matriz[0][j];
            }
        }

        // Verificar diagonales
        if (matriz[0][0] != null && matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2]) && matriz[2][2].equals(matriz[3][3])) {
            return matriz[0][0];
        }
        if (matriz[0][3] != null && matriz[0][3].equals(matriz[1][2]) && matriz[1][2].equals(matriz[2][1]) && matriz[2][1].equals(matriz[3][0])) {
            return matriz[0][3];
        }

        return null; // No hay ganador aún
    }
}