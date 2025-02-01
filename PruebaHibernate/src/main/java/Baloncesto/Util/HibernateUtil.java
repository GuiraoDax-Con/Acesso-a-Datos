package Baloncesto.Util;

import Baloncesto.Data.*;
import Baloncesto.Data.Second.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Autor: Daniel Guirao Coronado
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Crea el SessionFactory a partir del archivo de configuración estándar (hibernate.cfg.xml).
			Configuration configuration = new Configuration();

			// Paquete Data
			configuration.addAnnotatedClass(Equipo.class);
			configuration.addAnnotatedClass(Jugador.class);
			configuration.addAnnotatedClass(Patrocinador.class);
			// Paquete Second
			configuration.addAnnotatedClass(Encuentro.class); // Parece que no hay que especificar el paquete.
			configuration.addAnnotatedClass(EncuentroId.class);
			configuration.addAnnotatedClass(Pabellon.class);


			configuration.configure();

			sessionFactory = configuration.buildSessionFactory();

		} catch (Exception ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
