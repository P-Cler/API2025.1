package org.serratec.backend.dto;

public class ClienteRequest {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private Long endereco;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getEndereco() {
		return endereco;
	}
	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}
	
	
	
}
