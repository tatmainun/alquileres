package com.cundatat.alquileres.Servicios;

import com.cundatat.alquileres.excepciones.CredencialesInvalidasExcepcion;
import com.cundatat.alquileres.modelos.Credenciales;
import com.cundatat.alquileres.modelos.Usuario;
import com.cundatat.alquileres.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioLogin {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public boolean loguear(Credenciales credenciales) throws CredencialesInvalidasExcepcion {

        Optional<Usuario> usuarioEncontrado = repositorioUsuario.findByUsuario(credenciales.getUsuario());

        if (!usuarioEncontrado.isPresent()) {
            throw new CredencialesInvalidasExcepcion("Usuario inexistente");
        }

        if (usuarioEncontrado.get().getContraseña() != credenciales.getContraseña()) {
            throw new CredencialesInvalidasExcepcion("Contraseña incorrecta");
        }

        return true;
    }
}
