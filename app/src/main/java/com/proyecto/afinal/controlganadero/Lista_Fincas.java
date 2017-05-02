package com.proyecto.afinal.controlganadero;

/**
 * Created by Juan on 26/04/2017.
 */

public class Lista_Fincas {
    int id_imagen;
    String nombre;
    String ubicacion;

    public Lista_Fincas(int id_imagen, String nombre, String ubicacion) {
        this.id_imagen = id_imagen;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
