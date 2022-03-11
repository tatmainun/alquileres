package com.cundatat.alquileres.integracion;

import com.cundatat.alquileres.Servicios.ServicioLogin;
import com.cundatat.alquileres.excepciones.CredencialesInvalidasExcepcion;
import com.cundatat.alquileres.modelos.Credenciales;
import com.cundatat.alquileres.modelos.Usuario;
import com.cundatat.alquileres.repositorios.RepositorioUsuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ServicioLoginTest {

    public static final String USUARIO_PEPE = "pepe";
    public static final String CONTRASEÑA_USUARIO_PEPE = "123456789";
    private boolean resultado;

    @Autowired
    private ServicioLogin servicioLogin;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    void elUsuarioPuedeLoguearExitosamenteConLasCredencialesValidas() throws CredencialesInvalidasExcepcion {
        dadoQueExisteElUsuarioPepeConContrasñea123456789();
        cuandoSeRealizaElLoginConCredencialesValidas();
        seVerificaQueElUsuarioSePudoLoguear();
    }

    private void seVerificaQueElUsuarioSePudoLoguear() {
        assertTrue(this.resultado);
    }

    private void cuandoSeRealizaElLoginConCredencialesValidas() throws CredencialesInvalidasExcepcion {
        Credenciales credenciales = new Credenciales(USUARIO_PEPE, CONTRASEÑA_USUARIO_PEPE);

        this.resultado = servicioLogin.loguear(credenciales);
    }

    private void dadoQueExisteElUsuarioPepeConContrasñea123456789() {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsuario(USUARIO_PEPE);
        nuevoUsuario.setContraseña(CONTRASEÑA_USUARIO_PEPE);

        repositorioUsuario.save(nuevoUsuario);
    }
}
