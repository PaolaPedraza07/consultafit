package com.api.consultafit.services;

import com.api.consultafit.models.Cliente;
import com.api.consultafit.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginClienteService {
    @Autowired
    ClienteRepo clienteRepo;


    public Cliente validateCliente(Cliente client){

        return clienteRepo.findByNombre(client.getNombre());
    }
}
