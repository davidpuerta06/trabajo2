package com.david.trabajo2;

import java.util.Stack;
import java.util.function.Function;

public class Videojuego {
    private String nombre;
    private Genero genero;
    private Consola consola;
    private Stack<Integer> puntuaciones = new Stack<>();

    public Videojuego() {}

    public Videojuego(String nombre, Genero genero, Consola consola) {
        this.nombre = nombre;
        this.genero = genero;
        this.consola = consola;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setGenero(Genero genero) { this.genero = genero; }
    public void setConsola(Consola consola) { this.consola = consola; }

    public void agregarPuntuacion(int puntos) {
        puntuaciones.push(puntos);
    }

    public Stack<Integer> getPuntuaciones() {
        return puntuaciones;
    }

    public void verTotalPuntuaciones(Function<Videojuego, Integer> funcion) {
        int total = funcion.apply(this);
        System.out.println("El total de puntuaciones de " + nombre + " es: " + total);
    }

    public String getNombre() { return nombre; }
    public Genero getGenero() { return genero; }
    public Consola getConsola() { return consola; }
}
