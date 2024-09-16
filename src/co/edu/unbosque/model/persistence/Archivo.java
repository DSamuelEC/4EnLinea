package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Archivo {
	private File f;

	public Archivo() {
		f = new File("archivos\\Historial.txt");
	}

	public Archivo(File f) {
		this.f = f;
	}

	public String leerArchivo() {
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader linea;
		try {
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis);
			linea = new BufferedReader(isr);

			if (f.exists()) {
				String linea_arch = linea.readLine();
				String archivo_total = linea_arch;
				while (linea_arch != null) {
					linea_arch = linea.readLine();
					if (linea_arch != null) {
						archivo_total = archivo_total + "\n" + linea_arch;
					}
				}
				linea.close();
				return archivo_total;
			} else {
				return "El archivo no existe";
			}
		} catch (IOException e) {
			return "No se pudo leer el archivo";
		}
	}

	public String escribirArchivo(String frase) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader linea = new BufferedReader(isr);
			FileWriter lineatx = new FileWriter(f);
			String linea_arch = frase;
			lineatx.write(linea_arch + "\r\n");
			lineatx.close();
			return "Linea ingresada con exito";
		} catch (IOException e) {
			return "No se pudo escribir en el archivo";
		}

	}
}
