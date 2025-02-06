package data.Models;

import jakarta.persistence.*;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name="person")
public class Person {
	@Id
	@Column(name = "id", nullable = false)
	private int idPersons;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;


	@ManyToOne
	@JoinColumn(name = "house_id", nullable = true)
	private House houseId;


	// Constructores
	public Person() {
	}
	public Person(int idPersons, String firistName, String lastName, House house) {
		this.idPersons = idPersons;
		this.firstName = firistName;
		this.lastName = lastName;
		this.houseId = house;
	}


	// toString
	@Override
	public String toString() {
		return "Person{" +
				"idPersons=" + idPersons +
				", firistName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", house=" + houseId +
				'}';
	}

	// HashCode
	@Override
	public int hashCode() {
		return 0;
	}
}
