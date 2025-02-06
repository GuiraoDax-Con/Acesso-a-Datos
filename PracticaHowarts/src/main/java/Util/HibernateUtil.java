package Util;

import data.Models.House;
import data.Models.House_Points;
import data.Models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Autor: Daniel Guirao Coronado
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Session currentSession = null;

	static {
		try {
			// Crea el SessionFactory a partir del archivo de configuración estándar (hibernate.cfg.xml).
			Configuration configuration = new Configuration();

			// Inicializar las clases que se van a utilizar
			configuration.addAnnotatedClass(House.class);
			configuration.addAnnotatedClass(House_Points.class);
			configuration.addAnnotatedClass(Person.class);

			// Cargar la configuración
			configuration.configure();

			// Construir el SessionFactory
			sessionFactory = configuration.buildSessionFactory();

		} catch (Exception ex) {
			System.err.println("Falló la creación inicial de SessionFactory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		if(currentSession == null) {
			currentSession = sessionFactory.openSession();
		} else {
			if(!currentSession.isOpen()) {
				currentSession = sessionFactory.openSession();
			}
		}

		return currentSession;
	}

}
