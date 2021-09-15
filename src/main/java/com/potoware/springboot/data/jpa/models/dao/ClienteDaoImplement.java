package com.potoware.springboot.data.jpa.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.potoware.springboot.data.jpa.models.entity.Cliente;

@Repository
public class ClienteDaoImplement implements IClienteDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public void save(Cliente cliente) {
		if(cliente.getId()!=null && cliente.getId()>0) {
			System.out.println("*****************Paso por aqui merge");
			em.merge(cliente);	
		
		}else {
			System.out.println("*****************Paso por aqui persist");
			em.persist(cliente);
		}
	}

	@Override
	public Cliente findOne(Long id) {
		
		return em.find(Cliente.class, id);
	}

	@Override
	public void delete(Long id) {
	
		em.remove(findOne(id));
		
	}

}
