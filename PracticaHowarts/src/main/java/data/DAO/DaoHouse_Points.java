package data.DAO;

import Util.HibernateUtil;
import data.Models.House_Points;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoHouse_Points implements Dao<House_Points, Integer> {
	@Override
	public void save(House_Points housePoints) {
		HibernateUtil.executeTransaction(session -> {
			session.persist(housePoints); // session.save(housePoints); <- Deprecado
					return null;
		});
	}

	@Override
	public House_Points read(Integer id) {
		return HibernateUtil.executeTransaction(session -> session.find(House_Points.class, id));
	}

	@Override
	public void update(House_Points housePoints) {
		HibernateUtil.executeTransaction(session -> {
			session.merge(housePoints); // session.update(housePoints); <- Deprecado
					return null;
		});
	}

	@Override
	public void delete(Integer id) {
		HibernateUtil.executeTransaction(session -> {
			House_Points housePoints = session.get(House_Points.class, id);
			if (housePoints != null) {
				session.remove(housePoints); // session.delete(housePoints); <- Deprecado
			}
			return null;
		});
	}

	@Override
	public List<House_Points> findAll() {
		return HibernateUtil.executeTransaction(session ->
				session.createQuery("FROM House_Points", House_Points.class).list());
	}

	@Override // No se aplica porque House_Points no tiene un campo "name".
	public List<House_Points> findByName(String name) {
		return null;
	}

}
