package org.example.project.views.views;

import org.example.structures.EntradaJugador;

import java.util.LinkedList;

public class RankingView {
    private LinkedList<EntradaJugador> jugadores;

    public RankingView(LinkedList<EntradaJugador> jugadores) {
        this.jugadores = jugadores;
    }

    public EntradaJugador getEntradaJugador(int id){
        return jugadores.get(id);
    }

    public int size(){
        return jugadores.size();
    }

    public boolean isEmpty(){
        return jugadores.isEmpty();
    }
}
