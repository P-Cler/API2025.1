package org.serratec.backend.enums;

import org.serratec.backend.exception.ResourceNotFoundException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {
	FERRAMENTAS,CONSTRUCAO,ACABAMENTO,INFRAESTRUTURA;
	
	@JsonCreator
	public static Categoria verificarCategoria(String valor) {
		for (Categoria categoria: Categoria.values()) {
			if (valor.equals(categoria.name())) {
				return categoria;
			}
		}
		throw new ResourceNotFoundException("Categoria inserida inválida");
	}
	
}
