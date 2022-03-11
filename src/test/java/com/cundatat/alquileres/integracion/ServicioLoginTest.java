package com.cundatat.alquileres.integracion;

import com.cundatat.alquileres.Servicios.ServicioLogin;
import com.cundatat.alquileres.excepciones.CredencialesInvalidasExcepcion;
import com.cundatat.alquileres.modelos.Credenciales;
import com.cundatat.alquileres.modelos.Usuario;
import com.cundatat.alquileres.repositorios.RepositorioUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class ServicioLoginTest {

    public static final String USUARIO_PEPE = "pepe";
    public static final String CONTRASEÑA_USUARIO_PEPE = "123456789";
    public static final String USUARIO_INVALIDO = "peppa";
    public static final String CONTRASEÑA_INVALIDA = "987654321";
    private boolean resultado;

    @Autowired
    private ServicioLogin servicioLogin;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @BeforeEach
    void inicializar() {
        repositorioUsuario.deleteAll();
    }

    @Test
    void elUsuarioPuedeLoguearExitosamenteConLasCredencialesValidas() throws CredencialesInvalidasExcepcion {
        dadoQueExisteElUsuarioPepeConContrasñea123456789();
        cuandoSeRealizaElLoginConCredencialesValidas();
        seVerificaQueElUsuarioSePudoLoguear();
    }

    @Test
    void seLanzaUnaExcepcionCuandoElUsuarioYContraseñaSonInvalidos() {
        dadoQueExisteElUsuarioPepeConContrasñea123456789();
        cuandoSeRealizaElLoginConCredencialesInvalidasSeLanzaLaExcepcion();
    }

    private void cuandoSeRealizaElLoginConCredencialesInvalidasSeLanzaLaExcepcion() {
        Credenciales credenciales = new Credenciales(USUARIO_INVALIDO, CONTRASEÑA_INVALIDA);

        assertThrows(CredencialesInvalidasExcepcion.class, () -> servicioLogin.loguear(credenciales));
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
