package com.api.consultafit.repositories;


import com.api.consultafit.models.Administrador;
import com.api.consultafit.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Administrador, Integer> {
    Administrador findByCorreo(String correo);
    boolean existsByCorreo(String correo);
}
