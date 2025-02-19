package data.Services;

import data.DAO.DaoHouse;
import data.POJOS.House;
import data.POJOS.Person;

import java.util.List;

public class ServiceHouse {
	public static final String ANSI_RED = "\u001B[31m"; // Cambiára el color del print a rojo.
	public static final String ANSI_GREEN = "\u001B[32m"; // Cambiára el color del print a verge.
	public static final String ANSI_RESET = "\u001B[0m"; // Cambiára el color del print a blanco.

	private final DaoHouse daoHouse;

	public ServiceHouse() {
		this.daoHouse = new DaoHouse();
	}

	/**
	 * Elimina una casa si no tiene alumnos asignados.
	 *
	 * @param idHouse el ID de la casa a eliminar.
	 */
	public void deleteHouse(int idHouse) {
		House house = daoHouse.read(idHouse);
		if (house != null && (house.getPersons() == null || house.getPersons().isEmpty())) {
			daoHouse.delete(idHouse);
			System.out.println(ANSI_GREEN + "Casa eliminada correctamente." + ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "No se puede eliminar la casa, hay alumnos matriculados." + ANSI_RESET);
		}
	}

	/**
	 * Devuelve el director (head_teacher) de una casa.
	 *
	 * @param idHouse el ID de la casa.
	 * @return el objeto Person correspondiente al head_teacher.
	 */
	public Person getHeadTeacher(int idHouse) {
		House house = daoHouse.read(idHouse);
		if (house != null) {
			return house.getHead_teacher();
		}
		return null;
	}

	/**
	 * Encuentra casas por nombre.
	 *
	 * @param name el nombre de la casa.
	 * @return una lista de casas que coinciden.
	 */
	public List<House> findByName(String name) {
		return daoHouse.findByName(name);
	}
}
