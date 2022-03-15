package com.cundatat.alquileres.integracion;

import com.cundatat.alquileres.Servicios.ServicioDepartamento;
import com.cundatat.alquileres.modelos.Departamento;
import com.cundatat.alquileres.repositorios.RepositorioDepartamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class ServicioDepartamentoTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ServicioDepartamento servicioDepartamento;

    @Autowired
    private RepositorioDepartamento repositorioDepartamento;

    private ArrayList<Departamento> resultado;

    @BeforeEach
    void inicializacion() {
        repositorioDepartamento.deleteAll();
        entityManager.createNativeQuery("ALTER TABLE departamento AUTO_INCREMENT = 1").executeUpdate();
    }

    @Test
    void seObtieneTodosLosDepartamentos() {
        dadoQueExistenDosDepartamentos();
        cuandoSeObtienenTodosLosDepartamentos();
        entoncesVerificoLaCantidadDeDepartamentosSeaDos();
    }

    @Test
    void seVerificaQueElDepartamento2Exista() {
        dadoQueExistenDosDepartamentos();
        cuandoSeObtienenTodosLosDepartamentos();
        entoncesVerificoQueElDepartamento2Exista();
    }

    private void entoncesVerificoQueElDepartamento2Exista() {
        assertEquals(2, this.resultado.get(1).getId());
    }

    private void entoncesVerificoLaCantidadDeDepartamentosSeaDos() {
        assertEquals(2, this.resultado.size());
    }

    private void cuandoSeObtienenTodosLosDepartamentos() {
        this.resultado = servicioDepartamento.obtenerDepartamentos();
    }

    private void dadoQueExistenDosDepartamentos() {
        Departamento departamento1 = new Departamento();
        Departamento departamento2 = new Departamento();

        departamento1.setAmbientes(2);
        departamento1.setCantidadDePersonas(4);
        repositorioDepartamento.save(departamento1);

        departamento2.setAmbientes(3);
        departamento2.setCantidadDePersonas(6);
        repositorioDepartamento.save(departamento2);

    }
}
