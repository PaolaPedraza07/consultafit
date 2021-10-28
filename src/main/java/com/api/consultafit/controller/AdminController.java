package com.api.consultafit.controller;

import com.api.consultafit.models.Administrador;
import com.api.consultafit.models.Cliente;
import com.api.consultafit.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("administrador")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/sign-in")
    public String registroAdmin(@RequestBody Administrador administrador){
        //add fields validations
        // ADD HERE
        if(administrador.getNombre() == null){
            return "Error";
        }
        if(administrador.getCorreo() == null){
            return "Error";
        }
        // if(cliente.getDire == null){
        // }
        //-----------------------
        String serviceResponse = adminService.agregarAdministrador(administrador);
        if(serviceResponse.equals("Administrador agregado")){
            return "Se ha añadido correctamente";
        }
        return "Error intente más tarde";
    }

    @GetMapping("/{idAdministrador}")
    public Object getAdministrador(@PathVariable int idAdministrador){
        if(idAdministrador>0){
            // ir al sertvice
            return adminService.buscarAdministradorById(idAdministrador);

        }
        return "El id debe ser mayor a 0";
    }

    @GetMapping("/listar")
    public Object listar(){
        return adminService.listaAdministrador();
    }


    @DeleteMapping ("/eliminar/{idAdministrador}")
    public String deleteAdministrador(@PathVariable int idAdministrador){
        if(idAdministrador>0){
            // ir al sertvice
            adminService.eliminarAdministradorById(idAdministrador);
            return "Se eliminó correctamente";
        }
        return "El id debe ser mayor a 0";
    }

    @PutMapping("/actualizar")
    public String actualizarAdministrador(@RequestBody Administrador administrador){
        //add fields validations
        // ADD HERE
        // if(cliente.getName == null){
        //
        // }
        // if(cliente.getCorreo == null){
        // }
        // if(cliente.getDire == null){
        // }
        //-----------------------
        String serviceResponse = adminService.actualizarAdministrador(administrador);
        return serviceResponse;
    }


}
