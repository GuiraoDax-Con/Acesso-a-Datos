package com.pberna.aad.exameneva2.data.dao.dao_pojos;

import com.pberna.aad.exameneva2.data.dao.HibernateDao;
import com.pberna.aad.exameneva2.data.pojos.Peliculas;
import com.pberna.aad.exameneva2.data.HibernateUtil;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoPeliculas extends HibernateDao<Peliculas, Integer> {

	public DaoPeliculas() {
		super(Peliculas.class);
	}
}