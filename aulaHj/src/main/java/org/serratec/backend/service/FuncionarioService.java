package org.serratec.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.dto.FuncionarioResponseDTO;
import org.serratec.backend.entity.Funcionario;
import org.serratec.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public List<FuncionarioResponseDTO> listar(){
		List<Funcionario> funcionarios = repository.findAll();
		return funcionarios.stream().map(f -> new FuncionarioResponseDTO(f)).collect(Collectors.toList());
	}
	
}
