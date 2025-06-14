package br.com.serratec;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Post;
import br.com.serratec.repository.PostRepository;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

	@Autowired
	private PostRepository repository;

	@PostMapping
	public ResponseEntity<Post> inserir(@RequestBody Post post) {
		return ResponseEntity.created(null).body(repository.save(post));
	}

	@GetMapping
	public List<Post> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Post> buscar(@PathVariable Long id) {
		Optional<Post> post = repository.findById(id);
		if (post.isPresent()) {
			return ResponseEntity.ok(post.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Post> atualizar(@PathVariable Long id, @RequestBody Post post) {
		if (repository.existsById(id)) {
			post.setId(id);
			return ResponseEntity.ok(repository.save(post));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();

	}

}
