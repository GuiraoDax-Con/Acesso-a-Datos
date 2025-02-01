package Baloncesto.Data.Second;

import Baloncesto.Data.Equipo;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.sql.Date;

/**
 * Autor: Daniel Guirao Coronado
 */
@Entity
@Table(name = "encuentro")
@DynamicInsert // Para que funcione el @ColumnDefaul
@IdClass(EncuentroId.class)
public class Encuentro {
	// Atributos
	@Id
	@ManyToOne
	@JoinColumn(name = "equipo_casa", referencedColumnName = "codigo_equipo")
	private Equipo equicoCasa;

	@Id
	@ManyToOne
	@JoinColumn(name = "equipo_visitante", referencedColumnName = "codigo_equipo")
	private Equipo equicoVisitante;

	@Id
	@Column(nullable= false)
	@Temporal(TemporalType.DATE) //Para indicar que solamente se almacena en BD día, mes y año
	private Date fecha;

	@Column(name = "puntos_equipo_casa", columnDefinition = "INT", nullable = false)
	@ColumnDefault(value="0")
	private int puntosEquipoCasa;

	@Column(name = "puntos_equipo_visitante", columnDefinition = "INT", nullable = false)
	@ColumnDefault(value="0")
	private int puntosEquipoVisitante;


	// Constructor
	public Encuentro() {
	}
	public Encuentro(Equipo equicoCasa, Equipo equicoVisitante, Date fecha, int puntosEquipoCasa, int puntosEquipoVisitante) {
		this.equicoCasa = equicoCasa;
		this.equicoVisitante = equicoVisitante;
		this.fecha = fecha;
		this.puntosEquipoCasa = puntosEquipoCasa;
		this.puntosEquipoVisitante = puntosEquipoVisitante;
	}


	// Getters y Setters
	public Equipo getEquicoVisitante() {
		return equicoVisitante;
	}
	public void setEquicoVisitante(Equipo equicoVisitante) {
		this.equicoVisitante = equicoVisitante;
	}

	public Equipo getEquicoCasa() {
		return equicoCasa;
	}
	public void setEquicoCasa(Equipo equicoCasa) {
		this.equicoCasa = equicoCasa;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPuntosEquipoCasa() {
		return puntosEquipoCasa;
	}
	public void setPuntosEquipoCasa(int puntosEquipoCasa) {
		this.puntosEquipoCasa = puntosEquipoCasa;
	}

	public int getPuntosEquipoVisitante() {
		return puntosEquipoVisitante;
	}
	public void setPuntosEquipoVisitante(int puntosEquipoVisitante) {
		this.puntosEquipoVisitante = puntosEquipoVisitante;
	}

	// toString
	@Override
	public String toString() {
		return "Encuentro{" +
				"equicoCasa=" + equicoCasa +
				", equicoVisitante=" + equicoVisitante +
				", fecha=" + fecha +
				", puntosEquipoCasa=" + puntosEquipoCasa +
				", puntosEquipoVisitante=" + puntosEquipoVisitante +
				'}';
	}
}
