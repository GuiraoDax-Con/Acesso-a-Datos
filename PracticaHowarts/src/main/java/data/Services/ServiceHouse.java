package data.Services;

import data.DAO.DaoHouse;
import data.POJOS.House;
import data.POJOS.Person;

import java.util.List;

public class ServiceHouse {

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
			System.out.println("Casa eliminada correctamente.");
		} else {
			System.out.println("No se puede eliminar la casa, hay alumnos matriculados.");
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
