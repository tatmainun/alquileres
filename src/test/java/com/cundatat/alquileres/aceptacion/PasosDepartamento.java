package com.cundatat.alquileres.aceptacion;

import com.cundatat.alquileres.modelos.Departamento;
import com.cundatat.alquileres.repositorios.RepositorioDepartamento;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PasosDepartamento extends PasosBase {

    public MockMvc mockMvc;
    private ResultActions resultado;

    @Autowired
    private RepositorioDepartamento repositorioDepartamento;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters(springSecurityFilterChain)
                .build();
    }

    @Given("^Existen dos departamentos$")
    public void existenDosDepartamentos() {

        Departamento departamentoUno = new Departamento();
        departamentoUno.setAmbientes(1);
        departamentoUno.setCantidadDePersonas(2);

        Departamento departamentoDos = new Departamento();
        departamentoDos.setAmbientes(2);
        departamentoDos.setCantidadDePersonas(4);

        List<Departamento> departamentos = new ArrayList<>();
        departamentos.add(departamentoUno);
        departamentos.add(departamentoDos);

        repositorioDepartamento.saveAll(departamentos);
    }

    @When("^Se solicitan todos los departamentos$")
    public void seSolicitanTodosLosDepartamentos() throws Exception {
        resultado = mockMvc.perform(get("/departamento").contentType("application/json").characterEncoding("UTF-8"));
    }

    @Then("^Obtenemos todos los departamentos$")
    public void obtenemosTodosLosDepartamentos() throws Exception {
        resultado.andExpect(status().is(200))
                .andExpect((result) -> {
                    assertEquals("", result.getResponse().getContentAsString());
                });
    }
}
