package com.farsousa.desafiolocadoraveiculoapi.dto;

import com.farsousa.desafiolocadoraveiculoapi.models.Carro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarroSaveDTO {
	
	@NotBlank(message = "O atributo modelo precisa ser informado!")
	private String modelo;
	@NotBlank(message = "O atributo marca precisa ser informado!")
	private String marca;
	@NotBlank(message = "O atributo placa precisa ser informado!")
	private String placa;
	@NotBlank(message = "O atributo chassi precisa ser informado!")
	private String chassi;
	@NotNull(message = "O atributo valor da diária precisa ser informado!")
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
