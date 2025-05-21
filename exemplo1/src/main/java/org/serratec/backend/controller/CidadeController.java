package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Cidade;
import org.serratec.backend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade inserir(@Valid @RequestBody Cidade cidade) {
		return repository.save(cidade);
	}

	@GetMapping
	public List<Cidade> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Cidade> listarPorId(@PathVariable Long id) {
		Optional<Cidade> cidade = repository.findById(id);
		if (!cidade.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cidade.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Cidade> inserir(@RequestBody List<Cidade> cidades) {
		return repository.saveAll(cidades);

	}

	@PutMapping("{id}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @Valid @RequestBody Cidade cidade) {
		if (repository.existsById(id)) {
			cidade.setId(id);
			return ResponseEntity.ok(repository.save(cidade));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}