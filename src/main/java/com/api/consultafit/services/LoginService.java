package com.api.consultafit.services;

import com.api.consultafit.models.Administrador;
import com.api.consultafit.models.Cliente;
import com.api.consultafit.repositories.AdminRepo;
import com.api.consultafit.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    AdminRepo adminRepo;


    public Cliente validateCliente(Cliente client){
        return clienteRepo.findByCorreo(client.getCorreo());
    }

    public Administrador validateAdmin(Administrador admin){
        return adminRepo.findByNombre(admin.getNombre());
    }

}
