package com.farsousa.desafiolocadoraveiculoapi.dto;

import com.farsousa.desafiolocadoraveiculoapi.models.Carro;

public class CarroUpdateDto {
	
	private String modelo;
	private String marca;
	private String placa;
	private String chassi;
	private Double valorDiaria;
	
	public Carro toEntity() {
		return new Carro(modelo, marca, placa, chassi, valorDiaria);
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public Double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}	

}
