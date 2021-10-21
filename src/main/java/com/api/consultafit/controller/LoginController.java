package com.api.consultafit.controller;

import com.api.consultafit.models.Cliente;
import com.api.consultafit.services.LoginClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginClienteService loginClienteService;

    @PostMapping("/login-cliente")
    public Object loginCliente(@RequestBody Cliente cliente){
       return loginClienteService.validateCliente(cliente);
    }
}
