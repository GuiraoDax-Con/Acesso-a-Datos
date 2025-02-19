package data.Services;

import data.DAO.DaoHousePoints;
import data.DAO.DaoPerson;
import data.POJOS.House;
import data.POJOS.Person;

import java.util.List;

public class ServicePerson {
	public static final String ANSI_RED = "\u001B[31m"; // Cambiára el color del print a rojo.
	public static final String ANSI_GREEN = "\u001B[32m"; // Cambiára el color del print a verge.
	public static final String ANSI_RESET = "\u001B[0m"; // Cambiára el color del print a blanco.

	private final DaoPerson daoPerson;
	private final DaoHousePoints daoHousePoints;

	public ServicePerson() {
		this.daoPerson = new DaoPerson();
		this.daoHousePoints = new DaoHousePoints();
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

			if (hasGivenPoints || hasReceivedPoints) {
				// Mostrar mensajes específicos si tiene puntos como giver o receiver
				if (hasGivenPoints) {
					System.out.println(ANSI_RED + "No se puede borrar a la persona con ID " + idPerson +
							" porque ha dado puntos a otras personas." + ANSI_RESET);
				}
				if (hasReceivedPoints) {
					System.out.println(ANSI_RED + "No se puede borrar a la persona con ID " + idPerson +
							" porque ha recibido puntos de otras personas." + ANSI_RESET);
				}
			} else {
				// Si no tiene puntos asociados, proceder a eliminar
				daoPerson.delete(idPerson);
				System.out.println(ANSI_GREEN + "Persona con ID " + idPerson + " eliminada correctamente." + ANSI_RESET);
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
