package data.DAO;

import Hibernate.HibernateDao;
import Hibernate.HibernateUtil;
import data.POJOS.House;
import org.hibernate.Session;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoHouse extends HibernateDao<House, Integer> {

	public DaoHouse() {
		super(House.class);
	}

	/// Métodos adicionales

	/**
	 * Busca casas por nombre.
	 *
	 * @param name el nombre a buscar
	 * @return una lista de casas que coinciden con el nombre dado
	 */
	public List<House> findByName(String name) {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("FROM Person WHERE name = :name", House.class)
						.setParameter("name", name)
						.getResultList());
	}
}
