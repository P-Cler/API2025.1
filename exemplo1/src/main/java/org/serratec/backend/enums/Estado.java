package org.serratec.backend.enums;



public enum Estado {
	RJ(1,"Rio de Janeiro"), MG(2, "Minas Gerais"), SP(3, "São Paulo"), ES(4, "Espirito Santo");
	
	private Integer codigo;
	private String tipo;
	
	private Estado(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
//	@JsonCreator
//	public static Combustivel verificarCombustivel(Integer valor) {
//		for (Combustivel combustivel: Combustivel.values()) {
//			if (valor.equals(combustivel.codigo)) {
//				return combustivel;
//			}
//		}
//		throw new EnumException("Combustivel inserido inválido");
//	}
	
}
