package org.example.project.models;

import org.example.structures.EntradaJugador;

import java.util.LinkedList;

public class Ranking {

    private static Ranking instance;
    private LinkedList<EntradaJugador> jugadores = new LinkedList<EntradaJugador>();

    private Ranking(){
    }

    public static Ranking getInstance() {
        if (instance == null)
            instance = new Ranking();
        return instance;
    }

    public LinkedList<EntradaJugador> aa() {
        jugadores.add(new EntradaJugador("a",1));
        jugadores.add(new EntradaJugador("b",2));
        jugadores.add(new EntradaJugador("c",3));

        return jugadores;
    }
}
