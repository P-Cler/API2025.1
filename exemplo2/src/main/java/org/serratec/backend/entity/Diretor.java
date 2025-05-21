package org.serratec.backend.entity;

import jakarta.persistence.Entity;


@Entity
public class Diretor extends Funcionario {
	
	private String nivelHierarquico;

	public String getNivelHierarquico() {
		return nivelHierarquico;
	}

	public void setNivelHierarquico(String nivelHierarquico) {
		this.nivelHierarquico = nivelHierarquico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
