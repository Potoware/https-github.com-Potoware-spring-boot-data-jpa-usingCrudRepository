package com.potoware.springboot.data.jpa.models.dao;

import java.util.List;

import com.potoware.springboot.data.jpa.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();
}
