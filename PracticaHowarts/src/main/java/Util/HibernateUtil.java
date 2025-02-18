package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.function.Function;

/**
 * Autor: Daniel Guirao Coronado
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Crea el SessionFactory a partir del archivo de configuración estándar (hibernate.cfg.xml).
			Configuration configuration = new Configuration();

			// Cargar la configuración desde el archivo hibernate.cfg.xml
			configuration.configure("hibernate.cfg.xml");

			// Construir el SessionFactory
			sessionFactory = configuration.buildSessionFactory();

		} catch (Exception ex) {
			System.err.println("Falló la creación inicial de SessionFactory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}


	public static <R> R executeTransaction(Function<Session, R> action) {
		Transaction transaction = null;
		try (Session session = getSession()) {
			transaction = session.beginTransaction();
			R result = action.apply(session);
			transaction.commit();
			return result;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException("Error durante la transacción", e);
		}
	}


	public static void shutdown() {
		sessionFactory.close();
	}

}
