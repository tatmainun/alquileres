package com.cundatat.alquileres.Servicios;

import com.cundatat.alquileres.excepciones.CredencialesInvalidasExcepcion;
import com.cundatat.alquileres.modelos.Credenciales;
import org.springframework.stereotype.Service;

@Service
public class ServicioLogin {
    public boolean loguear(Credenciales credenciales) throws CredencialesInvalidasExcepcion {
        return true;
    }
}
