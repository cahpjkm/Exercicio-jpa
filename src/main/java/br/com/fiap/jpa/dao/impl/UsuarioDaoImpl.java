package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.UsuarioDao;
import br.com.fiap.jpa.entity.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao{
	
	public UsuarioDaoImpl(EntityManager em){
		super(em);
	}

}
