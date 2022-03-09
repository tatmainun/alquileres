package com.cundatat.alquileres.modelos;

public class Credenciales {

    private String usuario;
    private String contraseña;

    public Credenciales(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
}
