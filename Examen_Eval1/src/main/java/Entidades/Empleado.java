package Entidades;

import java.sql.Date;

/**
 * Autor: Daniel Guirao Coronado
 */
public class Empleado {
	private int id;
	private String nombre;
	private String oficio;
	private Date fecha_alt;
	private float salario;
	private float comision;
	private int idDepartamento;

	// Constructor
	public Empleado(int id, String nombre, String oficio, Date fecha_alt, float salario, float comision, int idDepartamento) {
		this.id = id;
		this.nombre = nombre;
		this.oficio = oficio;
		this.fecha_alt = fecha_alt;
		this.salario = salario;
		this.comision = comision;
		this.idDepartamento = idDepartamento;
	}

	// Getters y Setters

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Date getFecha_alt() {
		return fecha_alt;
	}
	public void setFecha_alt(Date fecha_alt) {
		this.fecha_alt = fecha_alt;
	}

	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", oficio='" + oficio + '\'' +
				", fecha_alt=" + fecha_alt +
				", salario=" + salario +
				", comision=" + comision +
				", idDepartamento=" + idDepartamento +
				'}';
	}
}
