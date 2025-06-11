package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.dto.ContaDTO;
import org.serratec.backend.dto.ContaRequestDTO;
import org.serratec.backend.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService service;

	@GetMapping
	public ResponseEntity<List<ContaDTO>> listar() {
		return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaDTO> buscarPorId(@PathVariable Long id) {
		Optional<ContaDTO> conta = service.buscarPorId(id);
		return conta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaDTO inserir(@Valid @RequestBody ContaRequestDTO dto) {
		return service.inserir(dto);
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<ContaDTO> inserirLista(@RequestBody List<ContaRequestDTO> dtos) {
		return service.inserirLista(dtos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ContaRequestDTO dto) {
		Optional<ContaDTO> atualizado = service.atualizar(id, dto);
		return atualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (service.remover(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
