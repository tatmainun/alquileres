package com.cundatat.alquileres.unitarias;
import com.cundatat.alquileres.Servicios.ServicioDepartamento;
import com.cundatat.alquileres.controladores.ControladorDepartamento;
import com.cundatat.alquileres.modelos.Departamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ControladorDepartamentoTest {

    private ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
    private ResponseEntity<ArrayList<Departamento>> resultado;

    @Mock
    ServicioDepartamento servicioDepartamento;

    @InjectMocks
    ControladorDepartamento controladorDepartamento;

    @Test
    void obtengoUnaListaDeDepartamentosConUnaEstructuraValida() {
        dadoQueExistenDosDepartamentos();
        cuandoSolicitdoLaListaDeTodosLosDepartamentos();
        entoncesObtengoDosDepartamentos();
    }

    private void entoncesObtengoDosDepartamentos() {
        assertEquals(2, this.resultado.getBody().size());
        assertEquals(HttpStatus.OK, this.resultado.getStatusCode());
    }

    private void cuandoSolicitdoLaListaDeTodosLosDepartamentos() {
        this.resultado = controladorDepartamento.obtenerTodos();
    }

    private void dadoQueExistenDosDepartamentos() {
        Departamento departamento1 = new Departamento();
        Departamento departamento2 = new Departamento();

        departamento1.setAmbientes(2);
        departamento1.setCantidadDePersonas(4);
        departamentos.add(departamento1);

        departamento2.setAmbientes(3);
        departamento2.setCantidadDePersonas(6);
        departamentos.add(departamento2);

        when(servicioDepartamento.obtenerDepartamentos()).thenReturn(departamentos);
    }
}
