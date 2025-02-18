package data.DAO;

import Util.HibernateUtil;
import data.Models.House;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoHouse implements Dao<House, Integer>{

	//Saved
	@Override
	public void save(House house) {
		HibernateUtil.executeTransaction(session -> {
			session.persist(house);
			return null;
		});
	}

	//Read
	@Override
	public House read(Integer id) {
		return HibernateUtil.executeTransaction(session -> session.find(House.class, id));
	}

	//Update
	public void update(House house) {
		HibernateUtil.executeTransaction(session -> {
			session.merge(house);
			return null;
		});
	}

	//Delete
	@Override
	public void delete(Integer id) {
		HibernateUtil.executeTransaction(session -> {
			House house = session.find(House.class, id);
			if (house != null) {
				session.remove(house);
			}
			return null;
		});
	}

	//Find all
	@Override
	public List<House> findAll() {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("FROM House", House.class).getResultList());
	}

	//Find by name
	@Override
	public List<House> findByName(String name) {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("FROM House WHERE name = :name", House.class)
						.setParameter("name", name)
						.getResultList());
	}
}
