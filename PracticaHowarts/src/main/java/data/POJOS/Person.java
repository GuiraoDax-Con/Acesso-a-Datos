package data.POJOS;

import jakarta.persistence.*;

import java.util.List;

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
	private String first_name;

	@Column(name = "last_name", nullable = false)
	private String last_name;


	@ManyToOne
	@JoinColumn(name = "house_id", nullable = true)
	private House houseId;

	@OneToMany(mappedBy = "personId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<House_Points> pointsGiven;

	@OneToMany(mappedBy = "personId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<House_Points> pointsReceived;


	// Constructores
	public Person() {
	}
	public Person(int idPersons, String first_name, String last_name, House house) {
		this.idPersons = idPersons;
		this.first_name = first_name;
		this.last_name = last_name;
		this.houseId = house;
	}


	// Getters y Setters
	public int getIdPersons() {
		return idPersons;
	}
	public void setIdPersons(int idPersons) {
		this.idPersons = idPersons;
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String lastName) {
		this.last_name = lastName;
	}

	public House getHouseId() {
		return houseId;
	}
	public void setHouseId(House houseId) {
		this.houseId = houseId;
	}

	public List<House_Points> getPointsGiven() {
		return pointsGiven;
	}
	public void setPointsGiven(List<House_Points> pointsGiven) {
		this.pointsGiven = pointsGiven;
	}

	public List<House_Points> getPointsReceived() {
		return pointsReceived;
	}
	public void setPointsReceived(List<House_Points> pointsReceived) {
		this.pointsReceived = pointsReceived;
	}

	// toString
	@Override
	public String toString() {
		return "Person{" +
				"idPersons=" + idPersons +
				", firistName='" + first_name + '\'' +
				", lastName='" + last_name + '\'' +
				", house=" + houseId +
				'}';
	}

	// HashCode
	@Override
	public int hashCode() {
		return 0;
	}
}
