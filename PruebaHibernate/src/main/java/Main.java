import Baloncesto.Data.*;

import Baloncesto.Data.Second.*;
import Baloncesto.Util.HibernateUtil;

import org.hibernate.Session;

/**
 * Autor: Daniel Guirao Coronado
 */
public class Main {
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession();) {
			/// Obtener equipo
			Equipo equipo1 = sesion.get(Equipo.class, 2);
			System.out.println(equipo1);

			/// Obtener un jugador
			Jugador jugador1 = obtenerJugador(sesion);
			System.out.println(jugador1);


			/// Crear un nuevo patrocinador
			System.out.println(ANSI_BLUE + "¡NUEVO PATROCINADOR!" + ANSI_RESET);
			if (crearPatrocinador(sesion)) {
				System.out.println("Patrocinador creado correctamente");
			} else {
				System.out.println("No se ha podido crear el patrocinador");
			}


			// Obtener un equipo y sus encuentros
			obtenerEquipoYSusEncuentros();

			/// Cerrará la sesión
			sesion.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void añadirEquipo(Session sesion) {
		// Crear un nuevo equipo
		Equipo nuevoEquipo = new Equipo();
		nuevoEquipo.setCodigoEquipo(5);
		nuevoEquipo.setNombreEquipo("El equipo de Javi");

		// Iniciamos una transacción
		sesion.beginTransaction();

		// Guardamos el nuevo equipo
		sesion.persist(nuevoEquipo); // persist() es el método que guarda el objeto en la base de datos
		sesion.flush(); // flush() es el método que sincroniza la sesión con la base de datos

		// Commit de la transacción
		sesion.getTransaction().commit();
	}

	private static void borrarEquipo(Session sesion) {
		int codigoEquipo = 0;
		
		try {
			System.out.println("¿Quieres eliminar un equipo? (s/n)");
			String respuesta = System.console().readLine();
			if (respuesta.equals("s")) {
				System.out.println("Introduce el código del equipo a eliminar:");
				codigoEquipo = Integer.parseInt(System.console().readLine());
	
				// Iniciamos una transacción
				sesion.beginTransaction();
	
				// Obtenemos el equipo a borrar
				Equipo equipo = sesion.get(Equipo.class, codigoEquipo);
	
				// Borramos el equipo
				sesion.delete(equipo);
				sesion.flush();
	
				// Commit de la transacción
				sesion.getTransaction().commit();
				
				System.out.println("Equipo eliminado correctamente");
				
			}
		} catch (Exception e) {
			System.out.println("No se ha encontrado el equipo con código " + codigoEquipo);
			//throw new RuntimeException(e);
		}
	}

	private boolean editarEquipo(Session sesion, int codigoEquipo, String nuevoNombre) {
		// Iniciamos una transacción
		sesion.beginTransaction();

		// Obtenemos el equipo a editar
		Equipo equipo = sesion.get(Equipo.class, codigoEquipo);

		if (equipo == null) {
			return false;
		}

		// Editamos el equipo
		equipo.setNombreEquipo(nuevoNombre);
		sesion.update(equipo);
		sesion.flush();

		// Commit de la transacción
		sesion.getTransaction().commit();

		return true;
	}

	private static Jugador obtenerJugador(Session sesion) {
		try {
			System.out.print("¿Quieres ver un jugador? (s/n): ");
			String respuesta = System.console().readLine();
			if (respuesta.equals("s")) {
				System.out.print("\nIntroduce el código del jugador a ver: ");
				int codigoJugador = Integer.parseInt(System.console().readLine());
				System.out.println("");

				// Obtenemos el jugador
				Jugador jugador = sesion.get(Jugador.class, codigoJugador);

				if (jugador != null) {
					System.out.println(jugador);
					return jugador;
				} else {
					System.out.println("No se ha encontrado el jugador con código " + codigoJugador);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	private static Boolean crearPatrocinador(Session session) {
		try {
			// Crear un nuevi patrocinador
			Patrocinador patrocinador = new Patrocinador();
			patrocinador.setCodigoPatrocinador(1);
			patrocinador.setNombrePatrocinador("Mi patrocinador1");
			patrocinador.setPresupuesto(1000);
			patrocinador.setOrganizacion("Mi organización");

			// Iniciamos una transacción
			session.beginTransaction();

			// Guardamos el nuevo patrocinador
			session.persist(patrocinador);
			session.flush();

			// Commit de la transacción
			session.getTransaction().commit();

			return true;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	private static void obtenerEquipoYSusEncuentros() {

		try(Session sesion = HibernateUtil.getSessionFactory().openSession();) {

			Equipo equipo = sesion.get(Equipo.class, 1);
			System.out.println("El equipo " + equipo.getNombreEquipo() +
					" tiene los siguientes encuentros en casa");

			for(Encuentro encuentroCasa: equipo.getEncuentrosCasa()) {
				System.out.println(encuentroCasa);
			}

			for(Encuentro encuentroVisitante: equipo.getEncuentrosVisitante()) {
				System.out.println(encuentroVisitante);
			}
		}

	}


	private static void crearEquipoConJugadores() {

	}
}
