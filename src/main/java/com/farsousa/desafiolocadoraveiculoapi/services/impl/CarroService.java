package com.farsousa.desafiolocadoraveiculoapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.farsousa.desafiolocadoraveiculoapi.dto.CarroSaveDTO;
import com.farsousa.desafiolocadoraveiculoapi.models.Carro;
import com.farsousa.desafiolocadoraveiculoapi.repositories.CarroRepository;
import com.farsousa.desafiolocadoraveiculoapi.services.ICarroService;

@Service
public class CarroService implements ICarroService {
	
	private final CarroRepository carroRepository;
	
	public CarroService(CarroRepository carroRepository) {
		this.carroRepository = carroRepository;
	}

	@Override
	public Carro buscarPorId(Long id) {
		return carroRepository.findById(id).orElseThrow();
	}

	@Override
	public Carro salvar(CarroSaveDTO carroParaSalvar) {		
		return carroRepository.save(carroParaSalvar.toEntity());
	}

	@Override
	public Page<Carro> listarCarros(Pageable paginacao) {
		return carroRepository.findAll(paginacao);
	}

	@Override
	public Carro excluirPorId(Long id) {
		Carro carro = buscarPorId(id);
		carroRepository.delete(carro);
		return carro;
	}

	@Override
	public Carro atualizarPorId(Long id, Carro carro) {
		// TODO Auto-generated method stub
		return null;
	}

}
