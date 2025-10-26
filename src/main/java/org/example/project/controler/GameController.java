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


    public void checkCollisions(){
        /*Vamos a chequear collision entre elementos utilizando el método privado collision
        en el caso de haber una colisión se restará vida al objeto en cuestión
        -Balas entre enemigos y nave quita 1 punto
        -Bala nave contra muro quita 2 puntos
        -Bala enemiga contra muro quita 1 punto
         */

        //Caso bala propia contra muro y contra nave enemiga
        for ( Proyectile bala : proyectilesJugador){
            for (Wall muro : walls){
                 boolean res = collision(bala , muro);
                 if (res){
                     muro.setHealth(muro.getHealth()-1);
                 }
            }
            for (EnemyShips naveEnemiga : enemyShips){
                boolean res = collision(bala , naveEnemiga);
                if (res){
                    naveEnemiga.setHealth(naveEnemiga.getHealth()-1);
                }
            }
        }


        //caso bala enemiga contra muro y nave propia
        for ( Proyectile bala : proyectilesEnemigos){
            for (Wall muro : walls){
                boolean res = collision(bala , muro);
                if (res){
                    muro.setHealth(muro.getHealth()-1);
                }
            }

            if( collision(bala,nave)){
                nave.setHealth(nave.getHealth()-1);
            }
        }

    }

     private boolean collision(Entity entity1, Entity entity2){
        int x1 = entity1.getPosition().getX();
        int y1= entity1.getPosition().getY();
        int x2 = entity2.getPosition().getX();
        int y2= entity2.getPosition().getY();

        // caso de colision
        if((x1==x2)&&(y1==y2)) return true;
        else return false;

    }



    public boolean checkShipHealth(){
        return nave.getHealth()<=0;
    }
}
