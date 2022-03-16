package com.cundatat.alquileres.unitarias;

import com.cundatat.alquileres.Servicios.ServicioLogin;
import com.cundatat.alquileres.controladores.ControladorLogin;
import com.cundatat.alquileres.excepciones.CredencialesInvalidasExcepcion;
import com.cundatat.alquileres.modelos.Credenciales;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ControladorLoginTest {

    private static final String USUARIO_INVALIDO = "pepito";
    private static final String CONTRASEÑA_INVALIDA = "987654321";
    public static final String USUARIO_VALIDO = "pepe";
    public static final String CONTRASEÑA_VALIDA = "123456789";

    @Mock
    ServicioLogin servicioLogin;

    private Credenciales credenciales;
    private ResponseEntity<Void> respuesta;

    @InjectMocks
    private ControladorLogin controladorLogin;

    @Test
    public void dadoUnUsuarioYContraseñaElLoginMeDevuelve200() throws CredencialesInvalidasExcepcion {
        dadoUnUsuarioYContraseñaValidos();
        cuandoElUsuarioSeLoguea();
        seVerificaQueSeDevuelveEstado200();
    }

    @Test
    public void dadoUnUsuarioYContraseñaInvalidosSeDevuelveUnaExcepcion() throws CredencialesInvalidasExcepcion {
        dadoUnUsuarioYContraseñaInvalidos();
        assertThrows(CredencialesInvalidasExcepcion.class, this::cuandoElUsuarioSeLoguea);
    }

    private void dadoUnUsuarioYContraseñaValidos() {
        Credenciales credenciales = new Credenciales(USUARIO_VALIDO, CONTRASEÑA_VALIDA);
        this.credenciales = credenciales;
    }

    private void dadoUnUsuarioYContraseñaInvalidos() throws CredencialesInvalidasExcepcion {
        Credenciales credenciales = new Credenciales(USUARIO_INVALIDO, CONTRASEÑA_INVALIDA);
        this.credenciales = credenciales;
        when(servicioLogin.loguear(this.credenciales)).thenThrow(CredencialesInvalidasExcepcion.class);
    }

    private void cuandoElUsuarioSeLoguea() throws CredencialesInvalidasExcepcion {
        respuesta = controladorLogin.login(this.credenciales);
        System.out.println(respuesta);
    }

    private void seVerificaQueSeDevuelveEstado200() {
        assertEquals(HttpStatus.OK, this.respuesta.getStatusCode());
    }

}
