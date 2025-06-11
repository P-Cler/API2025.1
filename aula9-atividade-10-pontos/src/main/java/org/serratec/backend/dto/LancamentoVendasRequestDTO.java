package org.serratec.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.serratec.backend.entity.LancamentoVendas;

import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

public class LancamentoVendasRequestDTO {

	@FutureOrPresent
	private LocalDate dataVenda;
	
	@NotNull
	@DecimalMin(value = "1.00", message = "Valor da compra deve ser acima de R$1,00")
	private BigDecimal valorVenda;
	
	@NotNull(message = "Insira o nome de um vendedor")
	private Long codigoVendedor;
	
	public LancamentoVendasRequestDTO() {
	}

	public LancamentoVendasRequestDTO(@FutureOrPresent LocalDate dataVenda, @NotNull BigDecimal valorVenda,
			@NotNull(message = "Insira o nome de um vendedor") Long codigoVendedor) {
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.codigoVendedor = codigoVendedor;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Long getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	
	

}

