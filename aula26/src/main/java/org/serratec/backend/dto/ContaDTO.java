package org.serratec.backend.dto;

import java.math.BigDecimal;

public class ContaDTO {

	private Long id;
	private String nomeTitular;
	private String numeroConta;
	private String cpf;
	private BigDecimal saldo;

	

	public ContaDTO(Long id, String nomeTitular, String numeroConta, String cpf, BigDecimal saldo) {
		this.id = id;
		this.nomeTitular = nomeTitular;
	}

	public Long getId() {
		return id;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
}
