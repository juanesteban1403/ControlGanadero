package com.proyecto.afinal.controlganadero;

/**
 * Created by Juan on 2/05/2017.
 */

public class Lista_Fincainterior {
    int id_imagen;
    String nombre;

    public Lista_Fincainterior(int id_imagen, String nombre) {
        this.id_imagen = id_imagen;
        this.nombre = nombre;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
