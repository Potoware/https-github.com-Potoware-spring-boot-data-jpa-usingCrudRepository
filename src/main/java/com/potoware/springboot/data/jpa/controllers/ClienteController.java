package com.potoware.springboot.data.jpa.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.potoware.springboot.data.jpa.models.dao.IClienteDao;
import com.potoware.springboot.data.jpa.models.entity.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map <String, Object> model) {
	model.put("titulo", "Formulario Cliente");
	Cliente cliente = new Cliente();
	model.put("cliente", cliente);
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:listar";
	}
}
