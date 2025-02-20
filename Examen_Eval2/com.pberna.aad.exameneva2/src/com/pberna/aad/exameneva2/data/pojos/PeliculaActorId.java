package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class PeliculaActorId implements java.io.Serializable {
	private static final long serialVersionUID = -134752012018696045L;
	@Column(name = "id_pelicula", nullable = false)
	private Integer idPelicula;

	@Column(name = "id_actor", nullable = false)
	private Integer idActor;


	// Getters y Setters
	public Integer getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Integer getIdActor() {
		return idActor;
	}
	public void setIdActor(Integer idActor) {
		this.idActor = idActor;
	}


	// Constructores
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		PeliculaActorId entity = (PeliculaActorId) o;
		return Objects.equals(this.idPelicula, entity.idPelicula) &&
				Objects.equals(this.idActor, entity.idActor);
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(idPelicula, idActor);
	}

}