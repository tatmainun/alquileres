package com.cundatat.alquileres.repositorios;

import com.cundatat.alquileres.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
