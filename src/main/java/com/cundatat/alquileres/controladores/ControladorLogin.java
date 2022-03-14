package com.cundatat.alquileres.controladores;

import com.cundatat.alquileres.Servicios.ServicioLogin;
import com.cundatat.alquileres.excepciones.CredencialesInvalidasExcepcion;
import com.cundatat.alquileres.modelos.Credenciales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorLogin {

    private ServicioLogin servicioLogin;

    @Autowired
    public ControladorLogin(ServicioLogin servicioLogin) {
        this.servicioLogin = servicioLogin;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody Credenciales credenciales) throws CredencialesInvalidasExcepcion {
        servicioLogin.loguear(credenciales);
        return ResponseEntity.ok().build();
    }

}
