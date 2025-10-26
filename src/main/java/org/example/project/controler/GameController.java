package org.example.project.controler;

import org.example.project.models.Entity;
import org.example.project.models.enemies.EnemyShips;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;
import org.example.project.models.objects.Proyectile;
import org.example.project.models.objects.Wall;
import org.example.project.models.player.PlayerShip;

import java.util.List;

public class GameController {
    private static GameController instancia;

    private List<Wall> walls;
    private List<EnemyShips> enemyShips;
    private List<Proyectile> proyectilesJugador;
    private List<Proyectile> proyectilesEnemigos;
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
    /*
    public Vector2 moverEntidad (){

    }
    */


    /*
    public boolean colcion(Entity entity1, Entity entity2){

    }*/

    public boolean checkShipHealth(){
        return nave.getHealth()<=0;
    }
}
