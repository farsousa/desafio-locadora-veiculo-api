package com.farsousa.desafiolocadoraveiculoapi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String cnh;
	@Column(nullable = false, unique = false)
	private String nome;	
	@Column(nullable = false, unique = false)
	private String telefone;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	
	public Cliente(String cnh, String nome, String telefone, Endereco endereco) {
		this.cnh = cnh;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public Cliente() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	

}
