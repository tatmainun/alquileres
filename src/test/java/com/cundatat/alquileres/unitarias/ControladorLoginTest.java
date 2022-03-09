package com.cundatat.alquileres.unitarias;

import com.cundatat.alquileres.controladores.ControladorLogin;
import com.cundatat.alquileres.modelos.Credenciales;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ControladorLoginTest {

    private Credenciales credenciales;
    @Autowired
    private ControladorLogin controladorLogin;
    private ResponseEntity<Void> respuesta;

    @Test
    public void dadoUnUsuarioYContraseñaElLoginMeDevuelve200() {
        dadoUnUsuarioYContraseña("pepe", "123456789");
        cuandoElUsuarioSeLoguea();
        seVerificaQueSeDevuelveEstado200();
    }

    private void seVerificaQueSeDevuelveEstado200() {
        assertEquals(HttpStatus.OK ,this.respuesta.getStatusCode());
    }

    private void cuandoElUsuarioSeLoguea() {
        respuesta = controladorLogin.login(this.credenciales);
        System.out.println(respuesta);
    }

    private void dadoUnUsuarioYContraseña(String usuario, String contraseña) {
        Credenciales credenciales = new Credenciales(usuario, contraseña);
        this.credenciales = credenciales;
    }
}
