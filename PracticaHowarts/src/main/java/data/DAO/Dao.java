package data.DAO;

import data.Models.House_Points;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public interface Dao <T, S> {
	void save(T model);
    public T read(S id);
	void update(T model);
    void delete(S id);
	List<T> findAll();
	List<T> findByName(String name);
}
