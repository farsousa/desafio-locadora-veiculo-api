package com.farsousa.desafiolocadoraveiculoapi.dto;

import com.farsousa.desafiolocadoraveiculoapi.models.Cliente;

public class ClienteUpdateDto {
	
	private String cnh;
	private String nome;	
	private String telefone;
	private EnderecoUpdateDto endereco;
	
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

	public EnderecoUpdateDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoUpdateDto endereco) {
		this.endereco = endereco;
	}
	
	

}
