package com.pberna.aad.exameneva2.data.dao.dao_pojos;

import com.pberna.aad.exameneva2.data.dao.HibernateDao;
import com.pberna.aad.exameneva2.data.pojos.Directores;

/**
 * Autor: Daniel Guirao Coronado
 */
public class DaoDirectores extends HibernateDao<Directores, Integer> {

    public DaoDirectores() {
        super(Directores.class);
    }
}
