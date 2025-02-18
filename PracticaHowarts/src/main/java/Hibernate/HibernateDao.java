package Hibernate;

import data.DAO.Dao;
import org.hibernate.Session;

import java.util.List;


/**
 * Autor: Daniel Guirao Coronado
 */
public class HibernateDao<T, S> implements Dao<T, S> {
	private final Class<T> classT;

	public HibernateDao(Class<T> classT) {
		this.classT = classT;
	}

	@Override
	public void save(T model) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.persist(model); // persist para nuevas entidades
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T read(S id) {
		try (Session session = HibernateUtil.getSession()) {
			return session.find(classT, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(T model) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.merge(model); // merge para actualizar entidades existentes
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(S id) {
		T model = read(id);

		if(model != null) {
			Session session = HibernateUtil.getSession();

			session.beginTransaction();
			session.remove(model);
			session.getTransaction().commit();
		}
	}

	@Override
	public List<T> findAll() {
	    Session session = HibernateUtil.getSession();
	    return session.createQuery("from " + classT.getName(), classT).getResultList();
	}
}
