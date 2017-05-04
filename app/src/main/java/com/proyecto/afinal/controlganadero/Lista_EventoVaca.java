package com.proyecto.afinal.controlganadero;

/**
 * Created by Juan on 3/05/2017.
 */

public class Lista_EventoVaca {
    int imagen;
    String Nombreevento;
    String Fecha;

    public Lista_EventoVaca(int imagen, String nombreevento, String fecha) {
        this.imagen = imagen;
        Nombreevento = nombreevento;
        Fecha = fecha;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombreevento() {
        return Nombreevento;
    }

    public void setNombreevento(String nombreevento) {
        Nombreevento = nombreevento;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}
