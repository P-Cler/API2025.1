package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Produto;
import org.serratec.backend.repository.ProdutoRepository;
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

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Produto inserir(@RequestBody Produto produto) {
//		return repository.save(produto);
//	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> inserirVarios(@RequestBody List<Produto> produtosNovos) {
		return repository.saveAll(produtosNovos);
	}
	
	@GetMapping("/lista")
	public List<Produto> listar(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> listarId(@PathVariable Long id){
		Optional<Produto> produto = repository.findById(id);
		if(!produto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto.get());
	
}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto){
		Optional<Produto> Optproduto = repository.findById(id);
		if(Optproduto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		return ResponseEntity.ok(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
	    Optional<Produto> optProduto = repository.findById(id);
	    
	    if (optProduto.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    repository.deleteById(id);
	    return ResponseEntity.noContent().build();
	}
 
}
