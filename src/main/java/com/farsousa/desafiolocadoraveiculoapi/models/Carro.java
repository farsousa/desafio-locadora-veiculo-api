package com.farsousa.desafiolocadoraveiculoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = false)
	private String modelo;
	@Column(nullable = false, unique = false)
	private String marca;
	@Column(nullable = false, unique = true)
	private String placa;
	@Column(nullable = false, unique = true)
	private String chassi;
	@Column(nullable = false, unique = false)
	private Double valorDiaria;
	
	public Carro() {}
	
	public Carro(String modelo, String marca, String placa, String chassi, Double valorDiaria) {
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.chassi = chassi;
		this.valorDiaria = valorDiaria;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
