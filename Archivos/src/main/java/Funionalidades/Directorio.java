package Funionalidades;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * @author Guirap
 * @date 25/11/2024
 */
public class Directorio {
	Pedir pd = new Pedir();
	String directorioActual = System.getProperty("user.dir");


	public Directorio() {
	}

	public void mostrarDirectorios() {
		// Obtener el directorio actual
		File directorio = new File(directorioActual);

		if (directorio.exists() && directorio.isDirectory()) {
			// Fecha de última modificación
			long ultimaModificacion = directorio.lastModified();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String fecha = sdf.format(ultimaModificacion);

			// Tamaño del directorio
			long tamanyoBytes = calcularTamaño(directorio);
			double tamanyoKilobytes = tamanyoBytes / 1024;

			// Mostrar resultados
			System.out.println("Directorio: " + directorio.getAbsolutePath());
			System.out.println("Última modificación: " + fecha);
			System.out.printf("Tamaño total: %.2f KB%n", tamanyoKilobytes);
		} else {
			System.out.println("El directorio no existe o no es un directorio válido.");
		}
	}

	/**
	 * Calcula el tamaño total de un directorio, incluyendo los tamaños de todos
	 * los archivos y subdirectorios contenidos en él.
	 *
	 * @param directorio El directorio cuyo tamaño se desea calcular.
	 * @return El tamaño total del directorio en bytes.
	 */
	private static long calcularTamaño(File directorio) {
		// Variable para acumular el tamaño total en bytes
		long tamanyo = 0;

		// Verificar si el archivo pasado es un directorio
		if (directorio.isDirectory()) {
			// Obtener la lista de archivos y subdirectorios dentro del directorio
			File[] archivos = directorio.listFiles();

			// Asegurarse de que no haya errores al listar el contenido del directorio
			if (archivos != null) {
				// Iterar por cada archivo o subdirectorio
				for (File archivo : archivos) {
					if (archivo.isFile()) {
						// Si es un archivo, sumar su tamaño
						tamanyo += archivo.length();
					} else {
						// Si es un subdirectorio, calcular su tamaño recursivamente
						tamanyo += calcularTamaño(archivo);
					}
				}
			}
		}

		// Devolver el tamaño total en bytes
		return tamanyo;
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
			System.out.println("Directorio cambiado a: " + directorioActual);
		} else {
			System.out.println("El subdirectorio no existe.");
		}
	}


}
