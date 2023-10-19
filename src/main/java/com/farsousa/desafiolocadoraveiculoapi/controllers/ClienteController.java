package com.farsousa.desafiolocadoraveiculoapi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farsousa.desafiolocadoraveiculoapi.dto.ClienteSaveDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.ClienteUpdateDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.ResponseModel;
import com.farsousa.desafiolocadoraveiculoapi.models.Cliente;
import com.farsousa.desafiolocadoraveiculoapi.services.impl.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping("")
	public ResponseEntity<ResponseModel<Cliente>> salvar(
		@RequestBody @Valid ClienteSaveDto clienteParaSalvar
	) {
		Cliente cliente = clienteService.salvar(clienteParaSalvar);	
		
		ResponseModel<Cliente> resposta = new ResponseModel<Cliente>();	
		resposta.setData(cliente);
		resposta.setMensagem("Cliente salvo com sucesso!");
		
		return ResponseEntity.created(null).body(resposta);
	}
	
	@GetMapping("")
	public ResponseEntity<ResponseModel<Cliente>> buscarTodos(
		Pageable paginacao
	) {
		Page<Cliente> clientes = clienteService.listarClientes(paginacao);
		
		ResponseModel<Cliente> resposta = new ResponseModel<Cliente>();	
		resposta.setPage(clientes);
		resposta.setMensagem("Listando todos os clientes!");
		
		return ResponseEntity.ok(resposta);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseModel<Cliente>> excluirPorId(
		@PathVariable Long id
	) {
		Cliente cliente = clienteService.excluirPorId(id);	
		
		ResponseModel<Cliente> resposta = new ResponseModel<Cliente>();	
		resposta.setData(cliente);
		resposta.setMensagem("Cliente excluído com sucesso!");
		
		return ResponseEntity.ok(resposta);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ResponseModel<Cliente>> atualizarPorId(
		@PathVariable Long id,
		@RequestBody ClienteUpdateDto clienteParaAtualizar
	) {
		Cliente cliente = clienteService.atualizarPorId(id, clienteParaAtualizar);	
		
		ResponseModel<Cliente> resposta = new ResponseModel<Cliente>();	
		resposta.setData(cliente);
		resposta.setMensagem("Cliente atualizado com sucesso!");
		
		return ResponseEntity.ok(resposta);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseModel<Cliente>> buscarPorId(
		@PathVariable Long id
	) {
		Cliente cliente = clienteService.buscarPorId(id);	
		
		ResponseModel<Cliente> resposta = new ResponseModel<Cliente>();	
		resposta.setData(cliente);
		resposta.setMensagem("Listando cliente com id "+ id +"!");
		
		return ResponseEntity.ok(resposta);
	}
	
}
