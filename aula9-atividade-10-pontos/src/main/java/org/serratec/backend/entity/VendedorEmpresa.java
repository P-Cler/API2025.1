package org.serratec.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VendedorEmpresa extends Vendedor{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer numeroCarteiraTrabalho;
	private LocalDate dataAdimissao;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroCarteiraTrabalho() {
		return numeroCarteiraTrabalho;
	}

	public void setNumeroCarteiraTrabalho(Integer numeroCarteiraTrabalho) {
		this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
	}

	public LocalDate getDataAdimissao() {
		return dataAdimissao;
	}

	public void setDataAdimissao(LocalDate dataAdimissao) {
		this.dataAdimissao = dataAdimissao;
	}
	
	

}
