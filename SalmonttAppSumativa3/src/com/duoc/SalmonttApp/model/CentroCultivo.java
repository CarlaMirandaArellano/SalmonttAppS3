package com.duoc.SalmonttApp.model;

public class CentroCultivo extends Entidad {

    private int capacidadToneladas;

    public CentroCultivo(String nombre, int capacidadToneladas) {
        super(nombre);
        this.capacidadToneladas = capacidadToneladas;
    }

    @Override
    public String mostrarResumen() {
        return "Centro de Cultivo: " + nombre +
                " | Capacidad: " + capacidadToneladas + " toneladas";
    }
}