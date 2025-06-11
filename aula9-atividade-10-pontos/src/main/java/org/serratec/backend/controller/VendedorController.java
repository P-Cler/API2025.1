package org.serratec.backend.controller;

import org.serratec.backend.dto.VendedorRequestDTO;
import org.serratec.backend.dto.VendedorResponseDTO;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<VendedorResponseDTO> listarPorId (@PathVariable Long id){
		VendedorResponseDTO dto = vendedorservice.listarPorId(id);
		return ResponseEntity.ok(dto); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor inserirVendedor(@Valid @RequestBody VendedorRequestDTO dto) {
	    return vendedorservice.inserirVendedor(dto);
	}


}
