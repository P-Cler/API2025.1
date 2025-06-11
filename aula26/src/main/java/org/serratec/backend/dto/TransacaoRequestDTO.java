package org.serratec.backend.dto;

import java.math.BigDecimal;

public class TransacaoRequestDTO {
    private Long contaOrigemId;
    private Long contaDestinoId;
    private BigDecimal valor;
	public Long getContaOrigemId() {
		return contaOrigemId;
	}
	public void setContaOrigemId(Long contaOrigemId) {
		this.contaOrigemId = contaOrigemId;
	}
	public Long getContaDestinoId() {
		return contaDestinoId;
	}
	public void setContaDestinoId(Long contaDestinoId) {
		this.contaDestinoId = contaDestinoId;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

    
}
