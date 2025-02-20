package com.pberna.aad.exameneva2.data.dao.dao_pojos;

import com.pberna.aad.exameneva2.data.dao.HibernateDao;
import com.pberna.aad.exameneva2.data.pojos.Genero;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoGenero extends HibernateDao<Genero, Integer> {

	public DaoGenero() {
		super(Genero.class);
	}
}
