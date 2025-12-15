package com.duoc.SalmonttApp.model;


public abstract class Entidad implements Registrable {
    protected String nombre;

    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}