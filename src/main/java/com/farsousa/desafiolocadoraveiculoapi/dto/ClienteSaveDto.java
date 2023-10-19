package com.farsousa.desafiolocadoraveiculoapi.dto;

import com.farsousa.desafiolocadoraveiculoapi.models.Cliente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteSaveDto {
	
	@NotBlank(message = "O atributo cnh precisa ser informado!")
	private String cnh;
	@NotBlank(message = "O atributo nome precisa ser informado!")
	private String nome;	
	@NotBlank(message = "O atributo telefone precisa ser informado!")
	private String telefone;
	@NotNull(message = "O atributo endereço precisa ser informado!")
	@Valid
	private EnderecoSaveDto endereco;
	
	public Cliente toEntity() {
		return new Cliente(cnh, nome, telefone, endereco.toEntity());
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoSaveDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoSaveDto endereco) {
		this.endereco = endereco;
	}
	
	

}
