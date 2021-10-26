package com.api.consultafit.controller;
import com.api.consultafit.models.Cliente;
import com.api.consultafit.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/sign-in")
    public String registroCliente(@RequestBody Cliente cliente){
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
        String serviceResponse = clienteService.agregarCliente(cliente);
        if(serviceResponse.equals("Cliente agregado")){
            return "Se ha añadido correctamente";
        }
        return "Error intente más tarde";
    }

    @GetMapping("/{idCliente}")
    public Object getCliente(@PathVariable int idCliente){
        if(idCliente>0){
            // ir al sertvice
            return clienteService.buscarClienteById(idCliente);

        }
        return "El id debe ser mayor a 0";
    }

    @GetMapping("/listar")
    public Object listar(){
        return clienteService.listaClientes();
    }


    @DeleteMapping ("/eliminar/{idCliente}")
    public String deleteCliente(@PathVariable int idCliente){
        if(idCliente>0){
            // ir al sertvice
            clienteService.eliminarClienteById(idCliente);
            return "Se eliminó correctamente";
        }
        return "El id debe ser mayor a 0";
    }

    @PutMapping("/actualizar")
    public String actualizarCliente(@RequestBody Cliente cliente){
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
        String serviceResponse = clienteService.actualizarCliente(cliente);
        return serviceResponse;
    }



}
