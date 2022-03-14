package com.cundatat.alquileres.Servicios;

import com.cundatat.alquileres.modelos.Departamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioDepartamento {

    public ArrayList<Departamento> obtenerDepartamentos() {
        return new ArrayList<Departamento>();
    }
}
