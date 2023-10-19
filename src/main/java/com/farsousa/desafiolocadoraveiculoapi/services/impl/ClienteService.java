package com.farsousa.desafiolocadoraveiculoapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.farsousa.desafiolocadoraveiculoapi.dto.ClienteSaveDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.ClienteUpdateDto;
import com.farsousa.desafiolocadoraveiculoapi.exceptions.NaoEncontradoException;
import com.farsousa.desafiolocadoraveiculoapi.models.Cliente;
import com.farsousa.desafiolocadoraveiculoapi.repositories.ClienteRepository;
import com.farsousa.desafiolocadoraveiculoapi.services.IClienteService;
import com.farsousa.desafiolocadoraveiculoapi.utils.ObjectUtil;

@Service
public class ClienteService implements IClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado!"));
	}

	@Override
	public Cliente salvar(ClienteSaveDto clienteParaSalvar) {		
		return clienteRepository.save(clienteParaSalvar.toEntity());
	}

	@Override
	public Page<Cliente> listarClientes(Pageable paginacao) {
		return clienteRepository.findAll(paginacao);
	}

	@Override
	public Cliente excluirPorId(Long id) {
		Cliente cliente = buscarPorId(id);
		clienteRepository.delete(cliente);
		return cliente;
	}

	@Override
	public Cliente atualizarPorId(Long id, ClienteUpdateDto clienteParaAtualizar) {
		Cliente cliente = buscarPorId(id);
		cliente = ObjectUtil.mergeObjects(cliente, clienteParaAtualizar.toEntity());
		return clienteRepository.save(cliente);
	}

}
