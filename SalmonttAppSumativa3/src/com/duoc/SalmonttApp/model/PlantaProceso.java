package com.duoc.SalmonttApp.model;

public class PlantaProceso extends Entidad {

    private String ciudad;

    public PlantaProceso(String nombre, String ciudad) {
        super(nombre);
        this.ciudad = ciudad;
    }

    @Override
    public String mostrarResumen() {
        return "Planta de Proceso: " + nombre +
                " | Ciudad: " + ciudad;
    }
}