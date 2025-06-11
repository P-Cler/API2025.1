package org.serratec.backend.controller;

import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoservice;
	
	@GetMapping("/id")
	public ResponseEntity<LancamentoVendasResponseDTO> listarPorId (Long id){
		LancamentoVendasResponseDTO dto = lancamentoservice.listarPorId(id);
		return ResponseEntity.ok(dto); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LancamentoVendas inserirLancamento(@Valid @RequestBody LancamentoVendasRequestDTO dto) {
		return lancamentoservice.inserirLancamento(dto);
		
	}

}
