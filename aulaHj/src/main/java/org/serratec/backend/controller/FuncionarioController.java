package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.dto.FuncionarioResponseDTO;
import org.serratec.backend.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public List<FuncionarioResponseDTO> listar(){
		return service.listar();
	}
	
	
}
