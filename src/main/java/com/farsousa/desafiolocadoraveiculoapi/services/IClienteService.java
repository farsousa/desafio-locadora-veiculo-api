package com.farsousa.desafiolocadoraveiculoapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.farsousa.desafiolocadoraveiculoapi.dto.ClienteSaveDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.ClienteUpdateDto;
import com.farsousa.desafiolocadoraveiculoapi.models.Cliente;

public interface IClienteService {
	
	public Cliente buscarPorId(Long id);
	public Cliente salvar(ClienteSaveDto clienteParaSalvar);
	public Page<Cliente> listarClientes(Pageable paginacao);
	public Cliente excluirPorId(Long id);
	public Cliente atualizarPorId(Long id, ClienteUpdateDto clienteParaAtualizar);

}
