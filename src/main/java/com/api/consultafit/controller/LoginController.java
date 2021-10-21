package com.api.consultafit.controller;

import com.api.consultafit.models.Administrador;
import com.api.consultafit.models.Cliente;
import com.api.consultafit.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginClienteService;

    @PostMapping("/login-cliente")
    public Object loginCliente(@RequestBody Cliente cliente) {
        Cliente responseService = loginClienteService.validateCliente(cliente);
        if (responseService == null) {
            return "El usuario no existe";
        } else if (responseService.getContrasenia().equals(cliente.getContrasenia())) {
            return responseService;
        } else if (!responseService.getContrasenia().equals(cliente.getContrasenia())) {
            return "Contraseña inválida";
        }
        return "error 500";
    }

    @PostMapping("/login-admin")
    public Object loginAdmin(@RequestBody Administrador admin) {
        Administrador responseService = loginClienteService.validateAdmin(admin);
        if (responseService == null) {
            return "El usuario no existe";
        }else if (responseService.getContrasenia().equals(admin.getContrasenia())) {
            return responseService;
        }else if (!responseService.getContrasenia().equals(admin.getContrasenia())) {
            return "Contraseña inválida";
        }
        return "error 500";
    }
}

