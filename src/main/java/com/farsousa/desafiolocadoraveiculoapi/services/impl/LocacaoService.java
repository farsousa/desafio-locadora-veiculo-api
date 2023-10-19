package com.farsousa.desafiolocadoraveiculoapi.services.impl;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.farsousa.desafiolocadoraveiculoapi.dto.LocacaoSaveDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.LocacaoUpdateDto;
import com.farsousa.desafiolocadoraveiculoapi.exceptions.NaoEncontradoException;
import com.farsousa.desafiolocadoraveiculoapi.models.Carro;
import com.farsousa.desafiolocadoraveiculoapi.models.Cliente;
import com.farsousa.desafiolocadoraveiculoapi.models.Locacao;
import com.farsousa.desafiolocadoraveiculoapi.repositories.LocacaoRepository;
import com.farsousa.desafiolocadoraveiculoapi.services.ILocacaoService;

import jakarta.transaction.Transactional;

@Service
public class LocacaoService implements ILocacaoService {
	
	private final ClienteService clienteService;
	private final CarroService carroService;
	private final LocacaoRepository locacaoRepository;
	
	public LocacaoService(ClienteService clienteService, CarroService carroService, LocacaoRepository locacaoRepository) {
		this.clienteService = clienteService;
		this.carroService = carroService;
		this.locacaoRepository = locacaoRepository;
	}

	@Override
	public Locacao salvar(LocacaoSaveDto locacaoParaSalvar) {
		Cliente cliente = clienteService.buscarPorId(locacaoParaSalvar.getIdCliente());
		Carro carro = carroService.buscarPorId(locacaoParaSalvar.getIdCarro());		
		Double valorTotal = carro.getValorDiaria() * locacaoParaSalvar.getQuantidadeDias();		
		Locacao locacao = new Locacao(cliente, carro, LocalDateTime.now(), valorTotal, locacaoParaSalvar.getQuantidadeDias());		
		return locacaoRepository.save(locacao);
	}

	@Override
	@Transactional
	public Locacao atualizarPorId(Long id, LocacaoUpdateDto locacaoParaAtualizar) {
		Locacao locacao = buscarPorId(id);
		locacao.setQuantidadeDias(locacaoParaAtualizar.getQuantidadeDias());
		Double valorTotal = locacao.getCarro().getValorDiaria() * locacao.getQuantidadeDias();
		locacao.setValorTotal(valorTotal);
		return locacaoRepository.save(locacao);
	}

	@Override
	public Locacao buscarPorId(Long id) {
		Locacao locacao = locacaoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Locação não encontrado!"));
		return locacao;
	}

	@Override
	public Page<Locacao> buscarTodas(Pageable paginacao) {
		return locacaoRepository.findAll(paginacao);
	}

}
