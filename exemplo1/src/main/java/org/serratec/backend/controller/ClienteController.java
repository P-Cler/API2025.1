package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.dto.ClienteRequest;
import org.serratec.backend.dto.EnderecoRequest;
import org.serratec.backend.entity.Cidade;
import org.serratec.backend.entity.Cliente;
import org.serratec.backend.entity.Endereco;
import org.serratec.backend.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@Valid @RequestBody ClienteRequest clienteRequest) {
		
		Endereco endereco = enderecoRepository.findById(clienteRequest.getEndereco())
				.orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(clienteRequest.getNome());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setEmail(clienteRequest.getEmail());
		cliente.setEndereco(endereco);
		
		return repository.save(cliente);
	}

	@GetMapping
	public List<Cliente> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Cliente> inserir(@RequestBody List<Cliente> clientes) {
		return repository.saveAll(clientes);

	}

	@PutMapping("{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		if (repository.existsById(id)) {
			cliente.setId(id);
			return ResponseEntity.ok(repository.save(cliente));
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