package com.cundatat.alquileres.Servicios;

import com.cundatat.alquileres.excepciones.CredencialesInvalidasExcepcion;
import com.cundatat.alquileres.modelos.Credenciales;
import com.cundatat.alquileres.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioLogin {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public boolean loguear(Credenciales credenciales) throws CredencialesInvalidasExcepcion {
        return true;
    }
}
