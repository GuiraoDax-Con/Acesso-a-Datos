package data.DAO;

import Hibernate.HibernateDao;
import Hibernate.HibernateUtil;
import data.POJOS.Person;
import org.hibernate.Session;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoPerson extends HibernateDao<Person, Integer> {

	public DaoPerson() {
		super(Person.class);
	}

	/// Métodos adicionales

	/**
	 * Busca personas por nombre.
	 *
	 * @param name el nombre a buscar
	 * @return una lista de personas que coinciden con el nombre dado
	 */
	public List<Person> findByName(String name) {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("FROM Person WHERE first_name = :name OR last_name = :name", Person.class)
						.setParameter("name", name)
						.getResultList());
	}
}

