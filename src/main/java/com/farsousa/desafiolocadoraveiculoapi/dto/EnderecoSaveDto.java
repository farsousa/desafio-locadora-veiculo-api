package com.farsousa.desafiolocadoraveiculoapi.dto;

import com.farsousa.desafiolocadoraveiculoapi.models.Endereco;
import jakarta.validation.constraints.NotBlank;

public class EnderecoSaveDto {
	
	@NotBlank(message = "O atributo logradouro precisa ser informado!")
	private String logradouro;
	@NotBlank(message = "O atributo numero precisa ser informado!")
	private String numero;
	@NotBlank(message = "O atributo bairro precisa ser informado!")
	private String bairro;
	@NotBlank(message = "O atributo cidade precisa ser informado!")
	private String cidade;
	@NotBlank(message = "O atributo estado precisa ser informado!")
	private String estado;
	
	public Endereco toEntity() {
		return new Endereco(logradouro, numero, bairro, cidade, estado);
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



}
