package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.dto.EnderecoRequest;
import org.serratec.backend.entity.Cidade;
import org.serratec.backend.entity.Endereco;
import org.serratec.backend.repository.CidadeRepository;
import org.serratec.backend.repository.EnderecoRepository;
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
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository repository;
	@Autowired
	private CidadeRepository cidadeRepository;


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco inserir(@Valid @RequestBody EnderecoRequest enderecoRequest) {
	    Cidade cidade = cidadeRepository.findById(enderecoRequest.getCidade())
	        .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

	    Endereco endereco = new Endereco();
	    endereco.setRua(enderecoRequest.getRua());
	    endereco.setNumero(enderecoRequest.getNumero());
	    endereco.setComplemento(enderecoRequest.getComplemento());
	    endereco.setBairro(enderecoRequest.getBairro());
	    endereco.setCidade(cidade);

	    return repository.save(endereco);
	}

	@GetMapping
	public List<Endereco> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Endereco> listarPorId(@PathVariable Long id) {
		Optional<Endereco> endereco = repository.findById(id);
		if (!endereco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(endereco.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Endereco> inserir(@RequestBody List<Endereco> enderecos) {
		return repository.saveAll(enderecos);

	}

	@PutMapping("{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @Valid @RequestBody Endereco endereco) {
		if (repository.existsById(id)) {
			endereco.setId(id);
			return ResponseEntity.ok(repository.save(endereco));
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