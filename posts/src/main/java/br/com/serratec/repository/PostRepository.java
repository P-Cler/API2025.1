package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
