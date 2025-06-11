package org.serratec.backend.dto;

import java.math.BigDecimal;

public record VendedorResponseDTO(Long codigoVendedor, String nome, String email, BigDecimal salario) {

}
