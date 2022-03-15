package com.cundatat.alquileres.controladores;

import com.cundatat.alquileres.Servicios.ServicioDepartamento;
import com.cundatat.alquileres.modelos.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class ControladorDepartamento {

    private ServicioDepartamento servicioDepartamento;

    @Autowired
    ControladorDepartamento(ServicioDepartamento servicioDepartamento) {
        this.servicioDepartamento = servicioDepartamento;
    }

    @GetMapping("/departamento")
    public ResponseEntity<ArrayList<Departamento>> obtenerTodos() {

        ArrayList<Departamento> respuestaDepartamento = servicioDepartamento.obtenerDepartamentos();

        return ResponseEntity.ok(respuestaDepartamento);
    }

}
