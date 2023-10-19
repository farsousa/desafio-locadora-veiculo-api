package com.farsousa.desafiolocadoraveiculoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farsousa.desafiolocadoraveiculoapi.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
