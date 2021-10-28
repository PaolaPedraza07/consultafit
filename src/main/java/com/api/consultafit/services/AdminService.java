package com.api.consultafit.services;

import com.api.consultafit.models.Administrador;
import com.api.consultafit.models.Cliente;
import com.api.consultafit.repositories.AdminRepo;
import com.api.consultafit.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public String agregarAdministrador(Administrador administrador){
        Administrador dbResponse = adminRepo.save(administrador);
        if(dbResponse == null){
            return "Error al ingresar en la base de datos";
        }
        return "Administrador agregado";
    }

    public Object buscarAdministradorById(int idAdministrador){
        Optional<Administrador> dbResponse = adminRepo.findById(idAdministrador);
        if(dbResponse.isPresent()){
            return dbResponse.get();
        }
        return "El id no existe en la base de datos";
    }


    public Object listaAdministrador(){
        List<Administrador> dbResponse = adminRepo.findAll();
//if
        return dbResponse;
    }

    public void eliminarAdministradorById(int idAdministrador){
        adminRepo.deleteById(idAdministrador);
    }

    public String actualizarAdministrador(Administrador administrador){
        if(adminRepo.existsById(administrador.getIdAdministrador())){
            Administrador dbResponse = adminRepo.save(administrador);
            if(dbResponse == null){
                return "Error al actualizar en la base de datos";
            }
            return "Administrador actualizado";
        }
        return "No se puede actualizar, el administrador no existe";

    }
}
