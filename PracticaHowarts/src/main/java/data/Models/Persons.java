package data.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Autor: Daniel Guirao Coronado
 */
public class Persons {
	@Id
	@Column(name = "id", nullable = false)
	private int idPersons;

	@Column(name = "first_name", nullable = false)
	private String firistName;

	@Column(name = "last_name", nullable = false)
	private String lastName;


	@ManyToOne
	@JoinColumn(name = "house_id", nullable = true)
	private House house;


	// Constructores
	public Persons() {
	}
	public Persons(int idPersons, String firistName, String lastName, House house) {
		this.idPersons = idPersons;
		this.firistName = firistName;
		this.lastName = lastName;
		this.house = house;
	}


	// toString
	@Override
	public String toString() {
		return "Persons{" +
				"idPersons=" + idPersons +
				", firistName='" + firistName + '\'' +
				", lastName='" + lastName + '\'' +
				", house=" + house +
				'}';
	}

	// HashCode
	@Override
	public int hashCode() {
		return 0;
	}
}
