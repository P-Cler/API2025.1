package org.serratec.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class LancamentoVendas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoVenda;
	
	private LocalDate dataVenda;
	private BigDecimal valorVenda;
	
	
	@ManyToOne
	@JoinColumn(name = "id_vendedor")
	private Vendedor vendedor;


	public Long getCodigoVenda() {
		return codigoVenda;
	}


	public void setCodigoVenda(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
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


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
}
