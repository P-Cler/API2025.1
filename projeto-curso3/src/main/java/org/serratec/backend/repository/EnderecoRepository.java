package org.serratec.backend.repository;

import java.util.Optional;

import org.serratec.backend.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	Endereco findByCep(String cep);

}
