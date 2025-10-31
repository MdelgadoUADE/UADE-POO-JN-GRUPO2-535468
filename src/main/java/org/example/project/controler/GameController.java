package org.example.project.controler;

import org.example.project.models.Entity;
import org.example.project.models.enemies.EnemyShips;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;
import org.example.project.models.objects.Proyectile;
import org.example.project.models.objects.Wall;
import org.example.project.models.others.Difficulty;
import org.example.project.models.player.PlayerShip;
import org.example.project.views.views.EntityView;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameController {
    private static GameController instancia;

    private Difficulty selectedDifficulty;

    private List<Wall> walls;
    private List<EnemyShips> enemyShips;
    private List<Proyectile> proyectilesJugador;
    private List<Proyectile> proyectilesEnemigos;
    private PlayerShip nave;
    private AreaDeJuego area;

    private GameController(){
        area = new AreaDeJuego(400, 400);
        nave = new PlayerShip(200,350,7,50,50,area);
        proyectilesEnemigos = new LinkedList<>();
        proyectilesJugador = new LinkedList<>();
        enemyShips = new LinkedList<>();
        walls = new LinkedList<>();
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

    public int crearProyectilJugador(){
        int centroNave = centroEntity(nave.getView());
        Proyectile p = new Proyectile(centroNave, area.getAlto(), -5,50,50,area);
        proyectilesJugador.add(p);
        return p.getId();
    }

    public int crearProyectilEnemigo(int idNave){
        EntityView e = buscarNaveEnemigo(idNave);
        int centroNave = centroEntity(e);
        int y = e.getArea().getAlto() + e.getPosition().getY();
        Proyectile p = new Proyectile(centroNave, y, 5,50,50,area);
        return p.getId();
    }

    public int centroEntity(EntityView entity){
        return nave.getPosition().getX() + nave.getArea().getAlto()/ 2;
    }


    public EntityView buscarNaveEnemigo(int idNave){
        for (int i = 0; i < enemyShips.size(); i++) {
            if (idNave == enemyShips.get(i).getId()){
                return enemyShips.get(i).getView();
            }
        }
        return null;
    }

    public EntityView buscarProyectilJugador(int idProyectil){
        for (int i = 0; i < proyectilesJugador.size(); i++) {
            if (idProyectil == proyectilesJugador.get(i).getId()){
                return proyectilesJugador.get(i).getView();
            }
        }
        return null;
    }

    public int moverProyectil(int idProyectil){
        for (int i = 0; i < proyectilesJugador.size(); i++) {
            if (idProyectil == proyectilesJugador.get(i).getId()){
                int nuevaY = proyectilesJugador.get(i).mover();
                if (nuevaY < -proyectilesJugador.get(i).getArea().getAlto()) {
                    proyectilesJugador.remove(proyectilesJugador.get(i));
                }
                return nuevaY;
            }
        }
        return 0;
    }



    public int asignarDisparo(){

        Random r = new Random();
        int disparar =  r.nextInt(2);
        if (disparar == 2){
            int i =  r.nextInt(enemyShips.size()-1);
            return enemyShips.get(i).getId();
        }
        return 0;
    }
    /*
    public Vector2 moverEntidad (){

    }
    */
    public void setDifficulty(Difficulty difficulty){
        selectedDifficulty = difficulty;
    }

    public void checkCollisions(){
        /*Vamos a chequear collision entre elementos utilizando el método privado collision
        en el caso de haber una colisión se restará vida al objeto en cuestión
        -Balas entre enemigos y nave quita 1 punto
        -Bala nave contra muro quita 2 puntos
        -Bala enemiga contra muro quita 1 punto
         */
        if(!proyectilesJugador.isEmpty()) {
            //Caso bala propia contra muro y contra nave enemiga
            for ( Proyectile bala : proyectilesJugador){
                for (Wall muro : walls){
                    boolean res = collision(bala , muro);
                    if (res){
                        muro.setDamage(2);
                    }
                }
                for (EnemyShips naveEnemiga : enemyShips){
                    boolean res = collision(bala , naveEnemiga);
                    if (res){
                        naveEnemiga.setDamage(1);
                    }
                }
            }

        }


        if(!proyectilesEnemigos.isEmpty()){
            //caso bala enemiga contra muro y nave propia
            for ( Proyectile bala : proyectilesEnemigos){
                for (Wall muro : walls){
                    boolean res = collision(bala , muro);
                    if (res){
                        muro.setDamage(1);

                    }
                }

                if( collision(bala,nave)){
                    nave.setDamage(1);
                }
            }
        }


    }

     private boolean collision(Entity entity1, Entity entity2){

        // revisar como validar areas
        int x1 = entity1.getPosition().getX();
        int y1= entity1.getPosition().getY();
        int x2 = entity2.getPosition().getX();
        int y2= entity2.getPosition().getY();
        int e1Ancho= entity1.getArea().getAncho();
        int e1Alto=entity1.getArea().getAlto();
        int e2Ancho= entity2.getArea().getAncho();
        int e2Alto=entity2.getArea().getAlto();

         System.out.println("se detecto colision");
        // caso de colision
        return(x1 < x2+e2Ancho &&
                x1 + e1Ancho > x2 &&
                y1 < y2 + e2Alto &&
                y1 + e1Alto > y2);
    }




    public boolean checkShipHealth(){
        return nave.getHealth()<=0;
    }
}
