package Ficheros;

import Entidades.Empleado;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class Ficheros {
	public static final String ANSI_BLUE = "\u001B[34m"; // Cambiára el color del print a azul.
	public static final String ANSI_RESET = "\u001B[0m"; // Cambiára el color del print a blanco.
	private String ubicacion = System.getProperty("user.dir") + "/src/main/java/zip/empleados.bin";

	// Constructor
	public Ficheros() {
		System.out.println(ANSI_BLUE + "La ubicación de su archivo es :" + ubicacion + ANSI_RESET);
	}

	// Método para leer los empleados
	public List<Empleado> getEmpleados() {
		List<Empleado> empleados = new ArrayList<Empleado>();

		// Lectura del fichero
		try {
			// Se inicia la lectura
			RandomAccessFile rafClientes = new RandomAccessFile(
					new File(ubicacion), "r");

			// Coge una linea
			String linea;
			//Lee la linea y mira que no sea null
			while((linea = rafClientes.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (Exception e) {
			System.out.print(ANSI_BLUE + "Error al leer el fichero." + e.getMessage() + ANSI_RESET);
		}

		return empleados;
	}

}
