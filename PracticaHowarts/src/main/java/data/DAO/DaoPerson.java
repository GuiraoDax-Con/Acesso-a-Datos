package data.DAO;

import Util.HibernateUtil;
import data.Models.Person;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoPerson implements Dao<Person, Integer> {

	@Override
	public void save(Person person) {
		HibernateUtil.executeTransaction(session -> {
			session.persist(person);
			return null;
		});
	}

	@Override
	public Person read(Integer id) {
		return HibernateUtil.executeTransaction(session -> session.find(Person.class, id));
	}

	@Override
	public void update(Person person) {
		HibernateUtil.executeTransaction(session -> {
			session.merge(person);
			return null;
		});
	}

	@Override
	public void delete(Integer id) {
		HibernateUtil.executeTransaction(session -> {
			Person person = session.find(Person.class, id);
			if (person != null) {
				session.remove(person);
			}
			return null;
		});
	}

	@Override
	public List<Person> findAll() {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("FROM Person", Person.class).getResultList());
	}

	@Override
	public List<Person> findByName(String name) {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("FROM Person WHERE firstName = :name OR last_name = :name", Person.class)
						.setParameter("name", name)
						.getResultList());
	}
}

