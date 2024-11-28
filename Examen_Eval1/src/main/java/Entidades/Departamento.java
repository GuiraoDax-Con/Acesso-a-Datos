package Entidades;

/**
 * Autor: Daniel Guirao Coronado
 */
public class Departamento {
	private int id;
	private String dnombre;
	private String localidad;
	private int jefe;

	// Constructor
	public Departamento(int id, String dnombre, String localidad, int jefe) {
		this.id = id;
		this.dnombre = dnombre;
		this.localidad = localidad;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDnombre() {
		return dnombre;
	}
	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getJefe() {
		return jefe;
	}
	public void setJefe(int jefe) {
		this.jefe = jefe;
	}

	// toString
	@Override
	public String toString() {
		return "Departamento{" +
				"id=" + id +
				", dnombre='" + dnombre + '\'' +
				", localidad='" + localidad + '\'' +
				", jefe='" + jefe + '\'' +
				'}';
	}
}
