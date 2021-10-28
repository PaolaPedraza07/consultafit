package com.api.consultafit.controller;

import com.api.consultafit.models.Administrador;
import com.api.consultafit.models.Cliente;
import com.api.consultafit.services.LoginService;
import com.api.consultafit.utility.JwtUtility;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    LoginService loginClienteService;
    @Autowired
    JwtUtility jwtUtility;

    @PostMapping("/login-cliente")
    public ResponseEntity<String> loginCliente(@RequestBody Cliente cliente) {
        Cliente responseService = loginClienteService.validateCliente(cliente);
        if (responseService == null) {
            return new ResponseEntity <String> ("El usuario no existe", HttpStatus.NOT_FOUND);
        } else if (responseService.getContrasenia().equals(cliente.getContrasenia())) {
            String jwt = jwtUtility.generateJwt(responseService.getIdClient(), responseService.getNombre(), responseService.getCorreo(), "CLIENTE");
            return new ResponseEntity<String> (jwt, HttpStatus.OK);
        } else if (!responseService.getContrasenia().equals(cliente.getContrasenia())) {
            return new ResponseEntity<String> ("Contraseña inválida", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String> ("Error, intente más tarde", HttpStatus.INTERNAL_SERVER_ERROR);
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

