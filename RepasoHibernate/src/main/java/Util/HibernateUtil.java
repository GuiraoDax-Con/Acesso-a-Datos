package Util;

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
		try{

		} catch (Exception ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
