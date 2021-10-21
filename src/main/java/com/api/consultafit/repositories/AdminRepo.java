package com.api.consultafit.repositories;


import com.api.consultafit.models.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Administrador, Integer> {
    Administrador findByNombre (String nombre);
}
