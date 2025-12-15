package com.duoc.SalmonttApp.Data;

import com.duoc.SalmonttApp.model.*;
import java.util.ArrayList;

public class GestorEntidades {

    private ArrayList<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    public String mostrarTodas() {
        StringBuilder resultado = new StringBuilder();

        for (Registrable r : entidades) {
            resultado.append(r.mostrarResumen()).append("\n");

            if (r instanceof Empleado) {
                resultado.append(" Tipo: Personal interno\n");
            } else if (r instanceof Proveedor) {
                resultado.append(" Tipo: Externo\n");
            }
        }
        return resultado.toString();
    }
}