package data.Models;

import Persons;

import jakarta.persistence.*;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name="House")
public class House {

	@Id
	@Column(name="id", nullable = false)
	private long idHouse;

	@Column(name="name", nullable = false)
	private String name;

	@Column(name="head_teacher", nullable = false)
	private int head_teacher;

	@OneToMany(mappedBy = "house")
	private List<Persons> persons;

	// Constructores
	public House() {
	}
	public House(long id, String name, int head_teacher) {
		this.idHouse = id;
		this.name = name;
		this.head_teacher = head_teacher;
	}


	// toString
	@Override
	public String toString() {
		return "House{" +
				"id=" + idHouse +
				", name='" + name + '\'' +
				", head_teacher=" + head_teacher +
				'}';
	}

	// HashCode
	@Override
	public int hashCode() {
		return 0;
	}
}
