package org.serratec.backend.dto;

import java.util.Optional;

import org.serratec.backend.entity.Endereco;

public record EnderecoResponseDTO(String cep, String logradouro, String bairro, String localidade, String uf) {

	public EnderecoResponseDTO(Endereco endereco) {
		this(endereco.getCep(), endereco.getLogradouro(), endereco.getBairro(), endereco.getLocalidade(),
				endereco.getUf());
	}

	
}