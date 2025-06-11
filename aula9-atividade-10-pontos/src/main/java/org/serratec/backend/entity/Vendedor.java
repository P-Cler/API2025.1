package org.serratec.backend.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoVendedor;
	
	@NotBlank
	private String nome;
	
	@Email
	private String email;
	
	@DecimalMin(value = "1518.00", message = "O salario não pode ser inferior ao salario mínimo")
	private BigDecimal salario;
	
	@OneToMany(mappedBy = "codigoVendedor", cascade = CascadeType.ALL)
	private List<LancamentoVendas> lancamentos;

	public Long getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
