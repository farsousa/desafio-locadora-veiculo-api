package com.farsousa.desafiolocadoraveiculoapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.farsousa.desafiolocadoraveiculoapi.dto.LocacaoSaveDto;
import com.farsousa.desafiolocadoraveiculoapi.dto.LocacaoUpdateDto;
import com.farsousa.desafiolocadoraveiculoapi.models.Locacao;

public interface ILocacaoService {
	
	public Locacao salvar(LocacaoSaveDto locacaoParaSalvar);
	public Locacao atualizarPorId(Long id, LocacaoUpdateDto locacaoParaAtualizar);
	public Locacao buscarPorId(Long id);
	public Page<Locacao> buscarTodas(Pageable paginacao);

}
