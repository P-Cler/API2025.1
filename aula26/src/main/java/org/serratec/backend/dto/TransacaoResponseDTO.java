package org.serratec.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponseDTO {

    private Long id;
    private String contaOrigem;
    private String contaDestino;
    private BigDecimal valor;
    private LocalDateTime dataHora;

    public TransacaoResponseDTO(Long id, String contaOrigem, String contaDestino, BigDecimal valor, LocalDateTime dataHora) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataHora = dataHora;
    }

	public Long getId() {
		return id;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

    
}
