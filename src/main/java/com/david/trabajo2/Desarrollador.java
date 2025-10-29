package com.david.trabajo2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Desarrollador {
    private String nombre;
    private Genero genero;
    private Consola consola;
    private Deque<Videojuego> videojuegos = new ArrayDeque<>();

    public Desarrollador() {}

    public Desarrollador(String nombre, Genero genero, Consola consola) {
        this.nombre = nombre;
        this.genero = genero;
        this.consola = consola;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setGenero(Genero genero) { this.genero = genero; }
    public void setConsola(Consola consola) { this.consola = consola; }

    public Deque<Videojuego> getVideojuegos() { return videojuegos; }
}
