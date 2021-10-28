package com.api.consultafit.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtility {
    public String generateJwt(int id, String username, String correo, String role){
        String secret = "consultaFitSecretKey";
        Algorithm algorithm = Algorithm.HMAC512(secret);

        long expireTime = (new Date().getTime()) + (60000*10); // 60000 milliseconds = 60 seconds = 1 minute
        Date expireDate = new Date(expireTime);

        String generatedToken = JWT.create()
                .withIssuer("Simple Solution")
                .withClaim("id", id)
                .withClaim("username", username)
                .withClaim("correo", correo)
                .withClaim("role", role)
                .withExpiresAt(expireDate)
                .sign(algorithm);
        return generatedToken;
    }
}
