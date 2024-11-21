package Funionalidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Archivo {
	private String userHome = System.getProperty("user.home");
	private String pathDirectorio = userHome + "/Documentos/Programa";
	private String pathArchivo = pathDirectorio + "/nuevoArchivo.txt";


	public void crearArchivo() {
		System.out.println("Creando archivo...");
		crearDirectorio();

		File archivo = new File(pathArchivo);
		if (!archivo.exists()) {
			try {
				if (archivo.createNewFile()) {
					System.out.println("Archivo creado: " + pathArchivo);
				} else {
					System.out.println("El archivo ya existe.");
				}

			} catch (Exception e) {
				System.out.println("Error al crear el archivo.");
			}
		}
	}

	public void mostrarArchivo() {
		System.out.println("Mostrando archivo...");

		File archivo = new File(pathArchivo);
		if (archivo.exists() && archivo.isFile()) {
			try {
				String contenido = new String(Files.readAllBytes(Paths.get(pathArchivo)));
				System.out.println("Contenido del archivo:\n" + contenido);

			} catch (IOException e) {
				System.out.println("Error al leer el archivo.");
			}
		} else {
			System.out.println("Archivo no encontrado.");
		}
	}

	public void anyadirLinea(String lineaAnyadir) {
		System.out.println("Añadiendo línea...");

		File archivo = new File(pathArchivo);
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
		System.out.println("Eliminando archivo...");

		File archivo = new File(pathArchivo);
		if (archivo.exists() && archivo.isFile()) {
			if (archivo.delete()) {
				System.out.println("Archivo eliminado: " + pathArchivo);
			} else {
				System.out.println("Error al eliminar el archivo.");
			}
		} else {
			System.out.println("Archivo no encontrado.");
		}
	}


	private void crearDirectorio() {
		File directorio = new File(pathDirectorio);
		if (!directorio.exists()) {
			directorio.mkdirs();
			System.out.println("Directorio creado: " + pathDirectorio);
		}
	}
}
