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
import com.farsousa.desafiolocadoraveiculoapi.dto.CarroSaveDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.CarroUpdateDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.ResponseModel;
import com.farsousa.desafiolocadoraveiculoapi.models.Carro;
import com.farsousa.desafiolocadoraveiculoapi.services.impl.CarroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("carro")
public class CarroController {
	
	private final CarroService carroService;
	
	public CarroController(CarroService carroService) {
		this.carroService = carroService;
	}
	
	@PostMapping("")
	public ResponseEntity<ResponseModel<Carro>> salvar(
		@RequestBody @Valid CarroSaveDto carroParaSalvar
	) {
		Carro carro = carroService.salvar(carroParaSalvar);	
		
		ResponseModel<Carro> resposta = new ResponseModel<Carro>();	
		resposta.setData(carro);
		resposta.setMensagem("Carro salvo com sucesso!");
		
		return ResponseEntity.created(null).body(resposta);
	}
	
	@GetMapping("")
	public ResponseEntity<ResponseModel<Carro>> buscarTodos(
		Pageable paginacao
	) {
		Page<Carro> carros = carroService.listarCarros(paginacao);
		
		ResponseModel<Carro> resposta = new ResponseModel<Carro>();	
		resposta.setPage(carros);
		resposta.setMensagem("Listando todos os carros!");
		
		return ResponseEntity.ok(resposta);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseModel<Carro>> excluirPorId(
		@PathVariable Long id
	) {
		Carro carro = carroService.excluirPorId(id);	
		
		ResponseModel<Carro> resposta = new ResponseModel<Carro>();	
		resposta.setData(carro);
		resposta.setMensagem("Carro excluído com sucesso!");
		
		return ResponseEntity.ok(resposta);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ResponseModel<Carro>> atualizarPorId(
		@PathVariable Long id,
		@RequestBody CarroUpdateDto carroParaAtualizar
	) {
		Carro carro = carroService.atualizarPorId(id, carroParaAtualizar);	
		
		ResponseModel<Carro> resposta = new ResponseModel<Carro>();	
		resposta.setData(carro);
		resposta.setMensagem("Carro atualizado com sucesso!");
		
		return ResponseEntity.ok(resposta);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseModel<Carro>> buscarPorId(
		@PathVariable Long id
	) {
		Carro carro = carroService.buscarPorId(id);	
		
		ResponseModel<Carro> resposta = new ResponseModel<Carro>();	
		resposta.setData(carro);
		resposta.setMensagem("Listando carro com id "+ id +"!");
		
		return ResponseEntity.ok(resposta);
	}
	
}
