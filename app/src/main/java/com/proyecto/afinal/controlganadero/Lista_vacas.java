package com.proyecto.afinal.controlganadero;

/**
 * Created by Juan on 3/05/2017.
 */

public class Lista_vacas {
    int imagen;
    String nombres;
    String evento;
    String lirtros;

    public Lista_vacas(int imagen, String nombres, String evento, String lirtros) {
        this.imagen = imagen;
        this.nombres = nombres;
        this.evento = evento;
        this.lirtros = lirtros;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getLirtros() {
        return lirtros;
    }

    public void setLirtros(String lirtros) {
        this.lirtros = lirtros;
    }
}
