package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ItemDao;
import br.com.fiap.jpa.entity.Item;

public class ItemDaoImpl extends GenericDaoImpl<Item, Integer> implements ItemDao{
	
	public ItemDaoImpl(EntityManager em) {
		super(em);
	}

}
