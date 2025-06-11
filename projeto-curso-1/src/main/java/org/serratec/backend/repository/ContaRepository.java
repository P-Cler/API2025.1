package org.serratec.backend.repository;


import org.serratec.backend.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContaRepository extends JpaRepository<Conta, Long> {

	
}
