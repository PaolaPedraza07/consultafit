package com.api.consultafit.services;

import com.api.consultafit.models.Cliente;
import com.api.consultafit.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepo clienteRepo;

    public String agregarCliente(Cliente cliente){
        if(clienteRepo.existsByCorreo(cliente.getCorreo())){
            return "El correo de usuario ya está registrado";
        }
        Cliente dbResponse = clienteRepo.save(cliente);
        if(dbResponse == null){
            return "Error al ingresar en la base de datos";
        }
        return "Cliente agregado";
    }

    public Object buscarClienteById(int idCliente){
        Optional<Cliente> dbResponse = clienteRepo.findById(idCliente);
        if(dbResponse.isPresent()){
            return dbResponse.get();
        }
        return "El id no existe en la base de datos";
    }


    public Object listaClientes(){
        List <Cliente> dbResponse = clienteRepo.findAll();
//if
        return dbResponse;
    }

    public void eliminarClienteById(int idCliente){
        clienteRepo.deleteById(idCliente);
    }

    public String actualizarCliente(Cliente cliente){
        if(clienteRepo.existsById(cliente.getIdClient())){
            Cliente dbResponse = clienteRepo.save(cliente);
            if(dbResponse == null){
                return "Error al actualizar en la base de datos";
            }
            return "Cliente actualizado";
        }
        return "No se puede actualizar, el cliente no existe";

    }
}
