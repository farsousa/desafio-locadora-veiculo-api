package com.farsousa.desafiolocadoraveiculoapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.farsousa.desafiolocadoraveiculoapi.dto.CarroSaveDTO;
import com.farsousa.desafiolocadoraveiculoapi.models.Carro;

public interface ICarroService {
	
	public Carro buscarPorId(Long id);
	public Carro salvar(CarroSaveDTO carroParaSalvar);
	public Page<Carro> listarCarros(Pageable paginacao);
	public Carro excluirPorId(Long id);
	public Carro atualizarPorId(Long id, Carro carro);

}
