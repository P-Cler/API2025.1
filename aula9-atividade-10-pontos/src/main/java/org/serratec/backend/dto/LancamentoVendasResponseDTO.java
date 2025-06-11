package org.serratec.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.serratec.backend.entity.Vendedor;

public record LancamentoVendasResponseDTO(LocalDate dataVenda, BigDecimal valorVenda, Vendedor nome ) {

}
