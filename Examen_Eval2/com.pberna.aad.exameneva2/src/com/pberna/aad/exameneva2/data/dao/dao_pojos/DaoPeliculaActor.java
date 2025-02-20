package com.pberna.aad.exameneva2.data.dao.dao_pojos;

import com.pberna.aad.exameneva2.data.dao.HibernateDao;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoPeliculaActor extends HibernateDao<PeliculaActor, Integer> {

	public DaoPeliculaActor() {
		super(PeliculaActor.class);
	}
}
