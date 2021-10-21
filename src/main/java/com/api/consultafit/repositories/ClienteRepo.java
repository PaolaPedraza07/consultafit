package com.api.consultafit.repositories;

import com.api.consultafit.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
    Cliente findByNombre(String nombre);
}
