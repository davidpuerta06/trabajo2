package com.david.trabajo2;

import java.util.*;
import java.util.function.Function;

public class MainTrabajo2 {
    public static void main(String[] args) {

        // PUNTO 1 - crear 5 videojuegos PS4 y asignar 5 puntuaciones cada uno
        Videojuego v1 = new Videojuego("Spider-Man", Genero.AVENTURA, Consola.PS4);
        Videojuego v2 = new Videojuego("FIFA 23", Genero.DEPORTES, Consola.PS4);
        Videojuego v3 = new Videojuego("God of War", Genero.ACCION, Consola.PS4);
        Videojuego v4 = new Videojuego("Gran Turismo", Genero.CARRERAS, Consola.PS4);
        Videojuego v5 = new Videojuego("Resident Evil", Genero.TERROR, Consola.PS4);

        // Agregar puntuaciones (últimos 5 'partidos' / reseñas)
        v1.agregarPuntuacion(85);
        v1.agregarPuntuacion(90);
        v1.agregarPuntuacion(88);
        v1.agregarPuntuacion(92);
        v1.agregarPuntuacion(87);

        v2.agregarPuntuacion(78);
        v2.agregarPuntuacion(80);
        v2.agregarPuntuacion(82);
        v2.agregarPuntuacion(79);
        v2.agregarPuntuacion(81);

        v3.agregarPuntuacion(95);
        v3.agregarPuntuacion(94);
        v3.agregarPuntuacion(96);
        v3.agregarPuntuacion(93);
        v3.agregarPuntuacion(92);

        v4.agregarPuntuacion(88);
        v4.agregarPuntuacion(86);
        v4.agregarPuntuacion(85);
        v4.agregarPuntuacion(87);
        v4.agregarPuntuacion(89);

        v5.agregarPuntuacion(70);
        v5.agregarPuntuacion(72);
        v5.agregarPuntuacion(74);
        v5.agregarPuntuacion(73);
        v5.agregarPuntuacion(75);

        Stack<Videojuego> juegosStack = new Stack<>();
        juegosStack.addAll(List.of(v1, v2, v3, v4, v5));

        Desarrollador dev = new Desarrollador("Naughty Dog", Genero.AVENTURA, Consola.PS4);
        dev.getVideojuegos().addAll(juegosStack);

        // PUNTO 2
        System.out.println("\nPUNTO 2 - ListIterator y Iterator");
        ListIterator<Videojuego> listIterator = juegosStack.listIterator();
        while (listIterator.hasNext()) {
            Videojuego v = listIterator.next();
            System.out.println(v.getNombre() + " - " + v.getGenero() + " - " + v.getConsola());
        }

        System.out.println("\nIterator desde el Deque del Desarrollador:");
        Iterator<Videojuego> iterator = dev.getVideojuegos().iterator();
        while (iterator.hasNext()) {
            Videojuego v = iterator.next();
            System.out.println(v.getNombre() + " - " + v.getGenero() + " - " + v.getConsola());
        }

        // PUNTO 3 - convertir Stack a Deque y filtrar por PS4
        System.out.println("\nPUNTO 3 - Programación funcional (PS4)");
        Deque<Videojuego> dequeJuegos = new ArrayDeque<>(juegosStack);
        dequeJuegos.stream()
                .filter(j -> j.getConsola() == Consola.PS4)
                .forEach(j -> System.out.println("Juego PS4: " + j.getNombre()));

        // PUNTO 4 - Function que suma puntuaciones
        System.out.println("\nPUNTO 4 - Function para total de puntuaciones");
        Function<Videojuego, Integer> funcionSuma = juego ->
                juego.getPuntuaciones().stream().mapToInt(Integer::intValue).sum();

        System.out.println("Total de puntuaciones de " + v1.getNombre() + ": " + funcionSuma.apply(v1));

        // PUNTO 5 - usar verTotalPuntuaciones de la clase
        System.out.println("\nPUNTO 5 - Método verTotalPuntuaciones");
        v2.verTotalPuntuaciones(funcionSuma);
    }
}
