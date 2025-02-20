package com.pberna.aad.exameneva2.data.dao.dao_pojos;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.dao.HibernateDao;
import com.pberna.aad.exameneva2.data.pojos.Actores;

import java.util.List;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoActores extends HibernateDao<Actores, Integer> {

	public DaoActores() {
		super(Actores.class);
	}
}
