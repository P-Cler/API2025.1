package org.serratec.backend.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ErrorResposta {

	private Integer status;
	private String titulo;
	private LocalDateTime dataHora;
	private List<String> erros;
	
	public ErrorResposta(Integer status, String titulo, LocalDateTime dataHora, List<String> erros) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.dataHora = dataHora;
		this.erros = erros;
	}
	
	public Integer getStatus() {
		return status;
	}
	public String getTitulo() {
		return titulo;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public List<String> getErros() {
		return erros;
	}
	
	
	
}
