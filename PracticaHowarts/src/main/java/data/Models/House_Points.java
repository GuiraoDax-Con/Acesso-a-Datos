package data.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * Autor: Daniel Guirao Coronado
 */
public class House_Points {

	@Id
	@Column(name = "id", nullable = false)
	private int id;


	private int giver;

	private int receiver;

	private int points;
}
