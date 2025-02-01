package Baloncesto.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name = "patrocinador")
public class Patrocinador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_patrocinador", nullable = false, length = 100)
	private int codigoPatrocinador;

	@Column(name="nombre_patrocinador", nullable = false, length = 100)
	private String nombrePatrocinador;

	@Column(name="presupuesto")
	private int presupuesto;

	@Column(name = "organizacion", nullable = false)
	@ColumnDefault("'Mi organización'")
	private String organizacion;

	// Constructor
	public Patrocinador(int codigoPatrocinador, String nombrePatrocinador, int presupuesto, String organizacion) {
		this.codigoPatrocinador = codigoPatrocinador;
		this.nombrePatrocinador = nombrePatrocinador;
		this.presupuesto = presupuesto;
		this.organizacion = organizacion;
	}
	public Patrocinador() {
	}

	// Getters y Setters
	public int getCodigoPatrocinador() {
		return codigoPatrocinador;
	}
	public void setCodigoPatrocinador(int codigoPatrocinador) {
		this.codigoPatrocinador = codigoPatrocinador;
	}

	public String getNombrePatrocinador() {
		return nombrePatrocinador;
	}
	public void setNombrePatrocinador(String nombrePatrocinador) {
		this.nombrePatrocinador = nombrePatrocinador;
	}

	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	@Override
	public String toString() {
		return "Patrocinador [codigoPatrocinador=" + codigoPatrocinador + ", nombrePatrocinador=" + nombrePatrocinador + ", presupuesto=" + presupuesto + ", organizacion=" + organizacion + "]";
	}

}
