package Baloncesto.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name="equipos")
public class Equipo {
	@Id
	@Column(name="codigo_equipo")
	private int codigoEquipo;

	@Column(name="nombre_equipo")
	private String nombreEquipo;

	public int getCodigoEquipo() {
		return codigoEquipo;
	}
	public void setCodigoEquipo(int codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}


	@Override
	public String toString() {
		return "Equipo [codigoEquipo=" + codigoEquipo + ", nombreEquipo=" + nombreEquipo + "]";
	}
}
