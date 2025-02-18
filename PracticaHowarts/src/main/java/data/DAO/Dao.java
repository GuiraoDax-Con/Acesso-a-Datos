package data.DAO;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public interface Dao <T, S> {
	void save(T model);
    T read(S id);
	void update(T model);
    void delete(S id);
	List<T> findAll();
}
