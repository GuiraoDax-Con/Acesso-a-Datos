package data.Services;

import data.DAO.DaoHousePoints;
import data.DAO.DaoPerson;
import data.POJOS.House_Points;
import data.POJOS.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceHousePoints {
	private final DaoHousePoints daoHousePoints;
	private final DaoPerson daoPerson;

	public ServiceHousePoints() {
		this.daoHousePoints = new DaoHousePoints();
		this.daoPerson = new DaoPerson();
	}

	/**
	 * Encuentra todas las personas con el apellido dado y para cada una devuelve
	 * una lista de las personas que les han dado puntos.
	 *
	 * @param apellido El apellido de las personas (receiver).
	 * @return Un mapa donde cada clave es una persona con el apellido y el valor es la lista de sus givers.
	 */
	public Map<Person, List<Person>> findReceiverOf(String apellido) {
		// Buscar todas las personas con el apellido dado
		List<Person> receivers = daoPerson.findByName(apellido);

		if (receivers.isEmpty()) {
			throw new IllegalArgumentException("No se encontró ninguna persona con el apellido: " + apellido);
		}

		// Crear un mapa donde cada clave es un receiver y el valor son sus givers
		Map<Person, List<Person>> result = new HashMap<>();

		for (Person receiver : receivers) {
			// Obtener los puntos recibidos por cada persona
			List<House_Points> receivedPoints = receiver.getPointsReceived();

			// Extraer la lista de personas que le dieron puntos (givers)
			List<Person> givers = receivedPoints.stream()
					.map(House_Points::getGiver)
					.distinct() // Evitar duplicados
					.collect(Collectors.toList());

			// Agregar al mapa
			result.put(receiver, givers);
		}

		return result;
	}


	/**
	 * Encuentra las personas que tienen la mayor cantidad de puntos recibidos.
	 *
	 * @return Una lista con las personas que tienen el mayor número de puntos.
	 */
	public List<Person> findMorePoints() {
		// Obtener todas las personas de la base de datos
		List<Person> allPersons = daoPerson.findAll();

		if (allPersons.isEmpty()) {
			throw new IllegalStateException("No hay personas en la base de datos.");
		}

		// Crear un mapa para almacenar el total de puntos por persona
		Map<Person, Integer> pointsMap = new HashMap<>();

		// Calcular el total de puntos recibidos por cada persona
		for (Person person : allPersons) {
			int totalPoints = person.getPointsReceived().stream()
					.mapToInt(House_Points::getPoints)
					.sum();
			pointsMap.put(person, totalPoints);
		}

		// Encontrar el máximo de puntos
		int maxPoints = pointsMap.values().stream()
				.max(Integer::compareTo)
				.orElse(0);

		// Devolver las personas que tienen el máximo de puntos
		return pointsMap.entrySet().stream()
				.filter(entry -> entry.getValue() == maxPoints)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}



}
