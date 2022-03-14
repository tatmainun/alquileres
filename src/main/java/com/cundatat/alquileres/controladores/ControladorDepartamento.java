package com.cundatat.alquileres.controladores;

import com.cundatat.alquileres.modelos.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ControladorDepartamento {

    @Autowired
    ControladorDepartamento() {

    }

    @GetMapping("/departamento")
    public ResponseEntity<ArrayList<Departamento>> obtenerTodos() {
        return ResponseEntity.ok(new ArrayList<Departamento>());
    }

}
