package com.farsousa.desafiolocadoraveiculoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farsousa.desafiolocadoraveiculoapi.models.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
