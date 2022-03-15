package com.cundatat.alquileres.repositorios;

import com.cundatat.alquileres.modelos.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDepartamento extends JpaRepository<Departamento, Long> {
}
