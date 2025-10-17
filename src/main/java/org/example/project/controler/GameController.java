package org.example.project.controler;

import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.player.PlayerShip;

public class GameController {
    private static GameController instancia;

    private PlayerShip nave;
    private AreaDeJuego area;

    private GameController(){
        area = new AreaDeJuego(400, 400);
        nave = new PlayerShip(200,350,7,50,50,area);
    }

    public static GameController getInstancia(){
        if (instancia == null) instancia = new GameController();
        return instancia;
    }

    public int moverNaveDerecha(){
        return nave.moverDerecha();
    }

    public int moverNaveIzquierda(){
        return nave.moverIzquierda();
    }
}
