package com.potoware.springboot.data.jpa.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.potoware.springboot.data.jpa.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{



}
