package data.Services;

import data.DAO.DaoHouse_Points;
import data.DAO.DaoPerson;
import data.POJOS.House;
import data.POJOS.Person;

import java.util.List;

public class ServicePerson {

	private final DaoPerson daoPerson;
	private final DaoHouse_Points daoHousePoints;

	public ServicePerson() {
		this.daoPerson = new DaoPerson();
		this.daoHousePoints = new DaoHouse_Points();
	}

	/**
	 * Elimina una persona si no tiene registros en house_points.
	 *
	 * @param idPerson el ID de la persona.
	 */
	public void deletePerson(int idPerson) {
		Person person = daoPerson.read(idPerson);
		if (person != null) {
			boolean hasGivenPoints = !person.getPointsGiven().isEmpty();
			boolean hasReceivedPoints = !person.getPointsReceived().isEmpty();

			if (!hasGivenPoints && !hasReceivedPoints) {
				daoPerson.delete(idPerson);
			} else {
				System.out.println("No se puede eliminar la persona, tiene registros de puntos asociados.");
			}
		}
	}

	/**
	 * Devuelve la casa a la que pertenece una persona.
	 *
	 * @param idPerson el ID de la persona.
	 * @return el objeto House correspondiente.
	 */
	public House getHouse(int idPerson) {
		Person person = daoPerson.read(idPerson);
		if (person != null) {
			return person.getHouseId();
		}
		return null;
	}

	/**
	 * Encuentra personas por nombre.
	 *
	 * @param name el nombre de la persona.
	 * @return una lista de personas que coinciden.
	 */
	public List<Person> findByName(String name) {
		return daoPerson.findByName(name);
	}
}
