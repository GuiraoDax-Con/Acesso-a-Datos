/**
 * Autor: Guirao Coronado Daniel
 */

package Entidades;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Pedir {
	private Scanner sc = new Scanner(System.in);

	/**
	 * Este metodo se usa para solicitar al usuario que ingrese
	 * un número de típo 'int' y mediante un try_catch realiza la excepción de
	 * errores.
	 * Cuando salte un error se ejecutara un 'continue' el cual volvera a iniciar
	 * el bucle en el cual se encuentra el try_catch pidiendo nuevamente que
	 * ingrse un número de típo 'int'.
	 *
	 * @return El método solo devolvera el contenido de la variable 'num'
	 *         el cual almacena un numero entero de tipo 'int'.
	 *
	 * @since 1.00v
	 */
	public int numInt() {
		while (true) {
			//System.out.print("\nIngresa un número: ");

			try {
				// Intenta convertir la entrada a número
				int numero = sc.nextInt();
				sc.nextLine(); // Vacia el escanner para evitar el error de desbordamiento
				return numero;

			} catch (NumberFormatException e) {
				sc.nextLine(); // Vacia el escanner para evitar el error de desbordamiento

				// Si ocurre una excepción, no es un número
				System.out.println("\nError: no es un número válido. Inténtalo de nuevo.");
			}
		}
	}

	public float numFloat() {
		while (true) {
			System.out.print("\nIngresa un número con decimales: ");

			try {
				float numero = sc.nextFloat(); // Lee la entrada del usuario
				sc.nextLine(); // Vacia el escanner para evitar el error de desbordamiento // Vacia el escanner para evitar el error de desbordamiento // Vacia el escanner para evitar el error de desbordamiento
				return numero;

			} catch (NumberFormatException e) {
				sc.nextLine(); // Vacia el escanner para evitar el error de desbordamiento

				// Si ocurre una excepción, no es un número
				System.out.println("\nError: no es un número válido. Inténtalo de nuevo.");
			}
		}
	}

	public String textoNoVacio() {
		while (true) {
			//System.out.print("\nIngresa un texto: ");
			String input = sc.nextLine().trim(); // Lee la entrada y elimina espacios en blanco

			if (!input.isEmpty()) {
				return input;
			} else {
				System.out.println("\nError: No ingresaste ningún texto. Inténtalo de nuevo.");
			}
		}
	}

	public String textoVacio() {
		//System.out.print("\nIngresa un texto: ");
		return sc.nextLine();
	}

	public String caracter() {
		while (true) {
			System.out.print("Ingrese M (Masculino) o F (Femenino): ");
			String input = sc.nextLine();

			if (input.length() == 1 && (input.equals("M") || input.equals("F"))) {
				return input;
			} else {
				System.out.println("\nError: No a ingresado M o F.");
			}
		}
	}

	public String caracterVacio() {
		while (true) {
			System.out.print("Ingrese M (Masculino) o F (Femenino): ");
			String input = sc.nextLine();

			if (input.length() == 1 && (input.equals("M") || input.equals("F"))) {
				return input;
			} else {
				System.out.println("\nError: No a ingresado M o F.");
			}
			if (input.length() == 0) {
				return null;
			}
		}
	}

	public Date fecha() {
		long milisegundos = System.currentTimeMillis(); // Obtiene el tiempo actual en milisegundos
		return new Date(milisegundos); // Crea una instancia de java.sql.Date
	}

	public Date ingresarFecha() {
		String fechaString = textoNoVacio();

		try {
			// Definir el formato de la fecha
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			// Parsear la fecha String a java.util.Date
			java.util.Date utilDate = formato.parse(fechaString);
			// Convertir java.util.Date a java.sql.Date
			Date sqlDate = new Date(utilDate.getTime());

			return sqlDate;

		} catch (ParseException e) {
			System.out.println("\nFormato de fecha incorrecto. Asegúrate de usar dd-MM-yyyy.");
			return null;
		}

	}

	public Date convertirStringASqlDate(String fechaStr) {
		// Definir los patrones de fecha permitidos
		DateTimeFormatter formatterGuion = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter formatterSlash = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			// Intentar parsear con el formato "dd-MM-yyyy"
			LocalDate fecha = LocalDate.parse(fechaStr, formatterGuion);
			return Date.valueOf(fecha);

		} catch (DateTimeParseException e1) {
			try {
				// Intentar parsear con el formato "dd/MM/yyyy"
				LocalDate fecha = LocalDate.parse(fechaStr, formatterSlash);
				return Date.valueOf(fecha);

			} catch (DateTimeParseException e2) {
				// Si no coincide con ninguno de los formatos, imprimir mensaje de error y devolver null
				System.out.println("Formato de fecha incorrecto. Usa \"dd-MM-yyyy\" o \"dd/MM/yyyy\".");
				return null;
			}
		}
	}


	public boolean siNo() {
		String respuesta = textoNoVacio();

		if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("y") || respuesta.equalsIgnoreCase("yes")) {
			return true;
		}

		return false;
	}

	public void salir() {
		System.exit(0);
	}
}
