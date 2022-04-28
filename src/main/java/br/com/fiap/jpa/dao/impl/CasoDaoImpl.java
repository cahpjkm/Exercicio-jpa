package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CasoDao;
import br.com.fiap.jpa.entity.Caso;

public class CasoDaoImpl extends GenericDaoImpl<Caso, Integer> implements CasoDao{
	
	public CasoDaoImpl(EntityManager em) {
		super(em);
	}

}
