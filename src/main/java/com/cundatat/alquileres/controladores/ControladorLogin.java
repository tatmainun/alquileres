package com.cundatat.alquileres.controladores;

import com.cundatat.alquileres.modelos.Credenciales;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorLogin {

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody Credenciales credenciales) {
        return ResponseEntity.ok().build();
    }

}
