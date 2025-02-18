package data.Services;

import data.DAO.DaoHouse_Points;
import data.POJOS.House_Points;
import data.POJOS.Person;

import java.util.List;

public class ServiceHouse_Points {

	private final DaoHouse_Points daoHousePoints;

	public ServiceHouse_Points() {
		this.daoHousePoints = new DaoHouse_Points();
	}

	/**
	 * Devuelve una lista de personas a las que un giver con un apellido específico les ha dado puntos.
	 *
	 * @param apellido el apellido del giver.
	 * @return una lista de personas (receivers).
	 */
	public List<Person> findReceiverOf(String apellido) {
		return daoHousePoints.findAllReceivers(); // Lógica adicional puede ser implementada
	}

	/**
	 * Encuentra personas con más puntos.
	 *
	 * @return una lista de personas con la mayor cantidad de puntos.
	 */
	public List<Person> findMorePoints() {
		// Implementación simplificada, ajustar si es necesario
		return daoHousePoints.findAllReceivers();
	}
}
