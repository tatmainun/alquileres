package com.cundatat.alquileres.Servicios;

import com.cundatat.alquileres.excepciones.DepartamentoInexistente;
import com.cundatat.alquileres.modelos.Departamento;
import com.cundatat.alquileres.repositorios.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioDepartamento {

    private final RepositorioDepartamento repositorioDepartamento;

    @Autowired
    public ServicioDepartamento(RepositorioDepartamento repositorioDepartamento) {
        this.repositorioDepartamento = repositorioDepartamento;
    }

    public ArrayList<Departamento> obtenerDepartamentos() {
        ArrayList<Departamento> departamentos = (ArrayList<Departamento>) repositorioDepartamento.findAll();
        return departamentos;
    }

    public Departamento obtenerDepartamento(long id) throws DepartamentoInexistente {
        Departamento departamentoBuscado = repositorioDepartamento.findById(id)
                .orElseThrow(DepartamentoInexistente::new);

        return departamentoBuscado;
    }
}
