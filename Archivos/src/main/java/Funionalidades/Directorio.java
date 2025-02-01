package Funionalidades;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Autor: Daniel Guirao Coronado
 */
public class Directorio {
	Pedir pd = new Pedir();
	Archivo arch;
	String directorioActual;


	// CONSTRUCTOR
	public Directorio() {
		this.arch = new Archivo();
		this.directorioActual = arch.getDirectorioActual();
	}


	// MÉTODOS
	public void mostrarDirectorios() {
		// Obtener el directorio actual
		File directorio = new File(directorioActual);

		if (directorio.exists() && directorio.isDirectory()) {
			// Mostrar información del directorio actual
			imprimirInformacion(directorio, 0);

			// Obtener subdirectorios directos
			File[] archivos = directorio.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					if (archivo.isDirectory()) {
						imprimirInformacion(archivo, 1);
					}
				}
			}
		} else {
			System.out.println("El directorio no existe o no es un directorio válido.");
		}
	}

	private void imprimirInformacion(File archivo, int nivel) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaModificacion = sdf.format(archivo.lastModified());
		long tamanoKB = archivo.length() / 1024;

		String formato = "Nombre: %-15s Fecha Ultima Modificación: %-15s Tamaño: %d KB";
		String salida = String.format(formato, archivo.getName(), fechaModificacion, tamanoKB);

		System.out.println(salida);
	}

	public void cambiarDirectorio() {
		System.out.print("Ingrese el nombre del subdirectorio o '..' para ir al directorio padre: ");
		String nombreDirectorio = pd.textoNoVacio();
		File nuevoDirectorio;

		if (nombreDirectorio.equals("..")) {
			nuevoDirectorio = new File(directorioActual).getParentFile();
			if (nuevoDirectorio == null) {
				System.out.println("No se puede ir al directorio padre. Ya estás en el directorio raíz.");
				return;
			}
		} else {
			nuevoDirectorio = new File(directorioActual, nombreDirectorio);
		}

		if (nuevoDirectorio.exists() && nuevoDirectorio.isDirectory()) {
			directorioActual = nuevoDirectorio.getAbsolutePath();
			arch.setDirectorioActual(directorioActual);
			System.out.println("Directorio cambiado a: " + directorioActual);
		} else {
			System.out.println("El subdirectorio no existe.");
		}
	}

}
