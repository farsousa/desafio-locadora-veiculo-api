package com.farsousa.desafiolocadoraveiculoapi.dto;

import jakarta.validation.constraints.NotNull;

public class LocacaoSaveDto {
	
	@NotNull(message = "O atributo id do cliente precisa ser informado!")
	private Long idCliente;
	@NotNull(message = "O atributo id do carro precisa ser informado!")
	private Long idCarro;
	@NotNull(message = "O atributo quantidade de dias precisa ser informado!")
	private int quantidadeDias;
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}
	public int getQuantidadeDias() {
		return quantidadeDias;
	}
	public void setQuantidadeDias(int quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}	

}
