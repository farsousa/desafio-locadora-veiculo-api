package com.farsousa.desafiolocadoraveiculoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farsousa.desafiolocadoraveiculoapi.models.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
