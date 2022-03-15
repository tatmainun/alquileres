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
    private ResponseEntity<ArrayList<Departamento>> resultados;
    private ResponseEntity<Departamento> resultado;
    private Departamento departamento;

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

    @Test 
    void obtengoeLDepartamento2() {
        dadoQueExisteElDepartamento2();
        cuandoSolicitoSolicitoElDepartamentoDos();
        entoncesObtengoLosDatosDelDepartamentoDos();
    }

    private void entoncesObtengoLosDatosDelDepartamentoDos() {
        assertEquals(HttpStatus.OK, this.resultado.getStatusCode());
        assertEquals(2L, this.resultado.getBody().getId());
        assertEquals(2, this.resultado.getBody().getAmbientes());
        assertEquals(4, this.resultado.getBody().getCantidadDePersonas());
    }

    private void cuandoSolicitoSolicitoElDepartamentoDos() {
        this.resultado = controladorDepartamento.obtenerDepto(2L);
    }

    private void dadoQueExisteElDepartamento2() {
        this.departamento = new Departamento();

        this.departamento.setId(2L);
        this.departamento.setAmbientes(2);
        this.departamento.setCantidadDePersonas(4);

        when(servicioDepartamento.obtenerDepartamento(2L)).thenReturn(this.departamento);
    }

    private void entoncesObtengoDosDepartamentos() {
        assertEquals(2, this.resultados.getBody().size());
        assertEquals(HttpStatus.OK, this.resultados.getStatusCode());
    }

    private void cuandoSolicitdoLaListaDeTodosLosDepartamentos() {
        this.resultados = controladorDepartamento.obtenerTodos();
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
