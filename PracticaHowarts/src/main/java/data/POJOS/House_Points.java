package data.POJOS;

import jakarta.persistence.*;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name="house_points")
public class House_Points {

	@Id
	@Column(name = "id", nullable = false)
	private int id;

	// FOREING KEY (giver) REFERENCES person(id)
	@ManyToOne
	@JoinColumn(name = "giver", nullable = false)
	private Person giver;

	// FOREING KEY (receiver) REFERENCES person(id)
	@ManyToOne
	@JoinColumn(name = "receiver", nullable = false)
	private Person receiver;

	@Column(name = "points", nullable = false)
	private int points;

	// Constructor
	public House_Points() {
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getGiver() {
		return giver;
	}

	public void setGiver(Person giver) {
		this.giver = giver;
	}

	public Person getReceiver() {
		return receiver;
	}

	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
