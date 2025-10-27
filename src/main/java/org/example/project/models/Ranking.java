package org.example.project.models;

import org.example.project.controler.PlayerController;
import org.example.project.views.views.RankingView;
import org.example.structures.EntradaJugador;

import java.util.LinkedList;

public class Ranking {

    private static Ranking instance;
    private RankingView rankingView;
    private LinkedList<EntradaJugador> jugadores;

    private Ranking(){
        jugadores = new LinkedList<>();
        rankingView = new RankingView(jugadores);
    }

    public static Ranking getInstance() {
        if (instance == null)
            instance = new Ranking();
        return instance;
    }


    public void addEntrada(String nombre){
        jugadores.add(
                new EntradaJugador(
                        nombre,
                        PlayerController.getInstance().getView().getScore()
        ));
    }

    public RankingView getRankingView() {
        return rankingView;
    }

}
