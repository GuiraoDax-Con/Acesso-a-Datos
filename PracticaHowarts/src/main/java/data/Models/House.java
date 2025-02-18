package data.Models;

import jakarta.persistence.*;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name="house")
public class House {

	@Id
	@Column(name="id", nullable = false)
	private long idHouse;

	@Column(name="name", nullable = false)
	private String name;

	@OneToOne
	@JoinColumn(name="head_teacher", unique = true, nullable = false)
	private Person head_teacher;

	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
	private List<Person> persons;

	// Constructores
	public House() {
	}
	public House(long id, String name, Person head_teacher) {
		this.idHouse = id;
		this.name = name;
		this.head_teacher = head_teacher;
	}


	// Getters y Setters
	public long getIdHouse() {
		return idHouse;
	}
	public void setIdHouse(long idHouse) {
		this.idHouse = idHouse;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Person getHead_teacher() {
		return head_teacher;
	}
	public void setHead_teacher(Person head_teacher) {
		this.head_teacher = head_teacher;
	}

	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
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
