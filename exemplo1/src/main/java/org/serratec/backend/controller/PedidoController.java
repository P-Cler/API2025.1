package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.dto.PedidoRequest;
import org.serratec.backend.dto.ClienteRequest;
import org.serratec.backend.entity.Cidade;
import org.serratec.backend.entity.Pedido;
import org.serratec.backend.entity.Cliente;
import org.serratec.backend.repository.PedidoRepository;
import org.serratec.backend.repository.ClienteRepository;
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
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido inserir(@Valid @RequestBody PedidoRequest pedidoRequest) {
		
		Cliente cliente = clienteRepository.findById(pedidoRequest.getCliente())
				.orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
		
		Pedido pedido = new Pedido();
		
		pedido.setDataPedido(pedidoRequest.getDataPedido());
		pedido.setHoraPedido(pedidoRequest.getHoraPedido());
		pedido.setStatus(pedidoRequest.getStatus());
		pedido.setCliente(cliente);
		
		return repository.save(pedido);
	}

	@GetMapping
	public List<Pedido> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> listarPorId(@PathVariable Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		if (!pedido.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pedido.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Pedido> inserir(@RequestBody List<Pedido> pedidos) {
		return repository.saveAll(pedidos);

	}

	@PutMapping("{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
		if (repository.existsById(id)) {
			pedido.setId(id);
			return ResponseEntity.ok(repository.save(pedido));
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
	@GetMapping("/buscar/{id}")
	public List<Pedido> buscarPedidoCliente(@PathVariable Long id){
		return repository.findByClienteId(id);
	}

}