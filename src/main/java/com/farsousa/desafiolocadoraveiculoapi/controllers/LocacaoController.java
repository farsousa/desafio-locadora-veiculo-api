package com.farsousa.desafiolocadoraveiculoapi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farsousa.desafiolocadoraveiculoapi.dto.LocacaoSaveDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.LocacaoUpdateDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.ResponseModel;
import com.farsousa.desafiolocadoraveiculoapi.models.Locacao;
import com.farsousa.desafiolocadoraveiculoapi.services.impl.LocacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("locacao")
public class LocacaoController {
	
	private final LocacaoService locacaoService;
	
	public LocacaoController(LocacaoService locacaoService) {
		this.locacaoService = locacaoService;
	}
	
	@PostMapping("")
	public ResponseEntity<ResponseModel<Locacao>> salvar(
		@RequestBody @Valid LocacaoSaveDto locacaoParaSalvar
	) {
		Locacao locacao = locacaoService.salvar(locacaoParaSalvar);
		
		ResponseModel<Locacao> resposta = new ResponseModel<Locacao>();
		resposta.setData(locacao);
		resposta.setMensagem("Locação realizada com sucesso!");
		
		return ResponseEntity.created(null).body(resposta);
	}
	
	@GetMapping("")
	public ResponseEntity<ResponseModel<Locacao>> buscarTodos(
		Pageable paginacao
	) {
		Page<Locacao> locacao = locacaoService.buscarTodas(paginacao);
		
		ResponseModel<Locacao> resposta = new ResponseModel<Locacao>();	
		resposta.setPage(locacao);
		resposta.setMensagem("Listando todas as locações!");
		
		return ResponseEntity.ok(resposta);
	}
	
	@PutMapping("{idLocacao}")
	public ResponseEntity<ResponseModel<Locacao>> atualizarPorId(
		@PathVariable Long idLocacao,
		@RequestBody LocacaoUpdateDto locacaoParaAtualizar
	) {
		Locacao locacao = locacaoService.atualizarPorId(idLocacao, locacaoParaAtualizar);	
		
		ResponseModel<Locacao> resposta = new ResponseModel<Locacao>();	
		resposta.setData(locacao);
		resposta.setMensagem("Locacao atualizado com sucesso!");
		
		return ResponseEntity.ok(resposta);
	}
	
	@GetMapping("{idLocacao}")
	public ResponseEntity<ResponseModel<Locacao>> buscarPorId(
		@PathVariable Long idLocacao
	) {
		Locacao locacao = locacaoService.buscarPorId(idLocacao);	
		
		ResponseModel<Locacao> resposta = new ResponseModel<Locacao>();	
		resposta.setData(locacao);
		resposta.setMensagem("Listando locacao com id "+ idLocacao +"!");
		
		return ResponseEntity.ok(resposta);
	}
	
	
}
