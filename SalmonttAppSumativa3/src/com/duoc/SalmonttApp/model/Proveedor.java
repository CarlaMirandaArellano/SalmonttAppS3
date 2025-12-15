package com.duoc.SalmonttApp.model;

public class Proveedor extends Entidad {

    private String rubro;

    public Proveedor(String nombre, String rubro) {
        super(nombre);
        this.rubro = rubro;
    }

    @Override
    public String mostrarResumen() {
        return "Proveedor: " + nombre +
                " | Rubro: " + rubro;
    }
}
