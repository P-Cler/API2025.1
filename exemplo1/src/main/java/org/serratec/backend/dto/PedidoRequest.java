package org.serratec.backend.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PedidoRequest {

	
	private LocalDate dataPedido;
	private LocalTime horaPedido;
	private Boolean Status;
	private Long cliente;
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public LocalTime getHoraPedido() {
		return horaPedido;
	}
	public void setHoraPedido(LocalTime horaPedido) {
		this.horaPedido = horaPedido;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	
	
	
}
