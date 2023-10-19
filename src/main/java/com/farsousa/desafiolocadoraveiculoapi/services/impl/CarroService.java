package com.farsousa.desafiolocadoraveiculoapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.farsousa.desafiolocadoraveiculoapi.dto.CarroSaveDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.CarroUpdateDto;
import com.farsousa.desafiolocadoraveiculoapi.exceptions.NaoEncontradoException;
import com.farsousa.desafiolocadoraveiculoapi.models.Carro;
import com.farsousa.desafiolocadoraveiculoapi.repositories.CarroRepository;
import com.farsousa.desafiolocadoraveiculoapi.services.ICarroService;
import com.farsousa.desafiolocadoraveiculoapi.utils.ObjectUtil;

@Service
public class CarroService implements ICarroService {
	
	private final CarroRepository carroRepository;
	
	public CarroService(CarroRepository carroRepository) {
		this.carroRepository = carroRepository;
	}

	@Override
	public Carro buscarPorId(Long id) {
		return carroRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Carro não encontrado!"));
	}

	@Override
	public Carro salvar(CarroSaveDto carroParaSalvar) {		
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
	public Carro atualizarPorId(Long id, CarroUpdateDto carroParaAtualizar) {
		Carro carro = buscarPorId(id);
		carro = ObjectUtil.mergeObjects(carro, carroParaAtualizar.toEntity());
		return carroRepository.save(carro);
	}

}
