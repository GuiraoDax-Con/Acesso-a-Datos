package data.DAO;

import Hibernate.HibernateDao;
import Hibernate.HibernateUtil;
import data.POJOS.House_Points;
import data.POJOS.Person;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoHouse_Points extends HibernateDao<House_Points, Integer> {

	public DaoHouse_Points() {
		super(House_Points.class);
	}

	/// Métodos adicionales

	/**
	 * Devuelve una lista de personas que son givers.
	 *
	 * @return una lista de personas que son givers
	 */
	public List<Person> findAllGivers() {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("SELECT DISTINCT hp.giver FROM House_Points hp", Person.class)
						.getResultList());
	}

	/**
	 * Devuelve una lista de personas que son receivers.
	 *
	 * @return una lista de personas que son receivers
	 */
	public List<Person> findAllReceivers() {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("SELECT DISTINCT hp.receiver FROM House_Points hp", Person.class)
						.getResultList());
	}
}
