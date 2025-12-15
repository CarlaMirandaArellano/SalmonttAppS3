package com.duoc.SalmonttApp.model;

public class Empleado extends Entidad {

    private String cargo;

    public Empleado(String nombre, String cargo) {
        super(nombre);
        this.cargo = cargo;
    }

    @Override
    public String mostrarResumen() {
        return "Empleado: " + nombre +
                " | Cargo: " + cargo;
    }
}