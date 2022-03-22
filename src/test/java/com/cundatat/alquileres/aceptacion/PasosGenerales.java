package com.cundatat.alquileres.aceptacion;

import com.cundatat.alquileres.repositorios.RepositorioDepartamento;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
public class PasosGenerales {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private RepositorioDepartamento repositorioDepartamento;

    @Before
    public void limpiarContexto() {
        repositorioDepartamento.deleteAll();
        entityManager.createNativeQuery("ALTER TABLE departamento AUTO_INCREMENT = 1").executeUpdate();
    }
}
