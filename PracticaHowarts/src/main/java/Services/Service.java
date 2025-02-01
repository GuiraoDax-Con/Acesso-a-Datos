package Services;

/**
 * Autor: Daniel Guirao Coronado
 */
public interface Service <T, S> {
	public void create(T model);
	public T read(S id);
	public void update(T model);
	public void delete(S id);
}