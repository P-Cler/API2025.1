package org.serratec.backend.dto;

public class EnderecoRequest {

	private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Long cidade;
    
    
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Long getCidade() {
		return cidade;
	}
	public void setCidade(Long cidade) {
		this.cidade = cidade;
	}
    
    
	
}
