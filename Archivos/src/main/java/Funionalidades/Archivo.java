package Funionalidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Archivo {
	/*
	 * private String userHome = System.getProperty("user.home"); // Directorio del usuario
	 * private String pathDirectorio = userHome + "/Documentos/Programa"; // Directorio del programa
	 */
	private String directorioActual; // Directorio actual del usuario
	private String pathArchivo; // Ruta del archivo
	Pedir pd = new Pedir();


	// CONSTRUCTOR
	public Archivo() {
		this.directorioActual = System.getProperty("user.dir");
	}


	// MÉTODOS
	public void crearArchivo() {
		System.out.print("Nombre del nuevo archivo: ");
		String nombreArchivo = pd.textoNoVacio();
		setPathArchivo(nombreArchivo);


		File archivo = new File(getPathArchivo());
		if (!archivo.exists()) {
			try {
				if (archivo.createNewFile()) {
					System.out.println("Archivo creado: " + getPathArchivo());
				} else {
					System.out.println("El archivo ya existe.");
				}

			} catch (Exception e) {
				System.out.println("Error al crear el archivo.");
			}
		}
	}


	public void mostrarArchivoEspecifico() {
		System.out.print("Ingrese el nombre del archivo a mostrar: ");
		String nombreArchivo = pd.textoNoVacio();
		String pathArchivoEspecifico = getDirectorioActual() + File.separator + nombreArchivo;

		File archivo = new File(pathArchivoEspecifico);
		if (archivo.exists() && archivo.isFile()) {
			try {
				/// Leer por bytes
				/*
				 * String contenido = new String(Files.readAllBytes(Paths.get(pathArchivoEspecifico)));
				 * System.out.println("Contenido del archivo:\n" + contenido);
				 * */

				/// Leer por líneas (forma compacta)
				/*
				 * Files.lines(Paths.get(pathArchivoEspecifico)).forEach(System.out::println);
				 */

				/// Leer por líneas (forma detallada)
				/*
				 * Files.lines(Paths.get(pathArchivoEspecifico)).forEach(linea -> {
				 * 		System.out.println(linea);
				 * });
				 */

				/// Leer por líneas (forma simple)
			    List<String> lineas = Files.readAllLines(Paths.get(pathArchivoEspecifico));
				for (String linea : lineas) {
					System.out.println(linea);
				}
				System.out.println("Número total de líneas: " + lineas.size());

			} catch (IOException e) {
				System.out.println("Error al leer el archivo.");
			}
		} else {
			System.out.println("Archivo no encontrado.");
		}

	}


	public void anyadirLinea(String lineaAnyadir) {
		System.out.println("Añadiendo línea...");

		File archivo = new File(getPathArchivo());
		if (archivo.exists() && archivo.isFile()) {
			try (FileWriter writer = new FileWriter(archivo, StandardCharsets.UTF_8, true)){
				writer.write(lineaAnyadir + System.lineSeparator());
				System.out.println("Línea añadida al archivo.");

			} catch (IOException e) {
				System.out.println("Error al escribir en el archivo.");
			}

		} else {
			System.out.println("Archivo no encontrado.");
		}

	}

	public void eliminarArchivo() {
		System.out.print("Ingrese el nombre del archivo a eliminar: ");
		String nombreArchivo = pd.textoNoVacio();
		String pathArchivoEspecifico = getDirectorioActual() + File.separator + nombreArchivo;

		File archivo = new File(pathArchivoEspecifico);
		if (archivo.exists() && archivo.isFile()) {
			if (archivo.delete()) {
				System.out.println("Archivo eliminado: " + pathArchivoEspecifico);
			} else {
				System.out.println("Error al eliminar el archivo.");
			}
		} else {
			System.out.println("Archivo no encontrado.");
		}
	}




	public String getDirectorioActual() {
		return directorioActual;
	}
	public void setDirectorioActual(String directorioActual) {
		this.directorioActual = directorioActual;
	}

	public String getPathArchivo() {
		return pathArchivo;
	}
	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = getDirectorioActual() + File.separator + pathArchivo;
	}
}
