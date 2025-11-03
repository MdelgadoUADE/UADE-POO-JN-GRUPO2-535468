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
    private final Random random = new Random();
    private long ultimoDisparo = 0;
    private static final int TIEMPO_ENTRE_DISPAROS = 2000;


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

    public  int crearEnemigoJugador(){
        System.out.println("crearEnemigoJugador controlador");
        EnemyShips e = new EnemyShips(0,0,1,50,50,area);
        enemyShips.add(e);
        return  e.getId();
    }

    public  int crearWall(int x, int y,int ancho, int alto){
        System.out.println(" creando muro");
        Wall w = new Wall(x,y,ancho,alto,area);
        walls.add(w);
        return  w.getId();
    }

    public Vector2 moverNaveEnemiga(int idNave) {
        Vector2 v = new Vector2(0, 0);

        for (int i = 0; i < enemyShips.size(); i++) {
            if (idNave == enemyShips.get(i).getId()) {
                v = enemyShips.get(i).mover();

                if (v.getY() > area.getAlto()) {
                    System.out.println("Eliminando nave enemiga id=" + idNave);
                    enemyShips.remove(i);
                }
                return v;
            }
        }
        return v;
    }

    public int crearProyectilEnemigo(int idNave){
        EntityView e = buscarNaveEnemigo(idNave);
        int centroNave = centroEntity(e);
        int y = e.getAreaObjeto().getAlto() + e.getPosition().getY();
        Proyectile p = new Proyectile(centroNave, y, 5,50,50,area);
        proyectilesEnemigos.add(p);
        return p.getId();
    }

    public int centroEntity(EntityView entity){
        return entity.getPosition().getX() + entity.getAreaObjeto().getAncho() / 2;
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

    public EntityView buscarProyectilEnemigo(int idProyectil){
        for (int i = 0; i < proyectilesEnemigos.size(); i++) {
            if (idProyectil == proyectilesEnemigos.get(i).getId()){
                return proyectilesEnemigos.get(i).getView();
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

    public int moverProyectilEnemigo(int idProyectil){
        for (int i = 0; i < proyectilesEnemigos.size(); i++) {
            if (idProyectil == proyectilesEnemigos.get(i).getId()){
                System.out.println("Se mueve");
                int nuevaY = proyectilesEnemigos.get(i).mover();
                if (nuevaY > area.getAlto()) {
                    proyectilesEnemigos.remove(proyectilesEnemigos.get(i));
                }
                return nuevaY;
            }
        }
        return 0;
    }

    public int asignarDisparo() {
        long ahora = System.currentTimeMillis();
        if (ahora - ultimoDisparo >= TIEMPO_ENTRE_DISPAROS && !enemyShips.isEmpty()) {
            if (random.nextDouble() < 0.10) {
                ultimoDisparo = ahora;
                int i = random.nextInt(enemyShips.size());
                int id = enemyShips.get(i).getId();
                System.out.println("Enemigo " + id + " dispara");
                return id;
            }
        }
        return 0;
    }

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

                    if (collision(bala , muro)){
                        System.out.println("se detecto colision");
                        muro.setDamage(2);
                    }
                }
                for (EnemyShips naveEnemiga : enemyShips){

                    if (collision(bala , naveEnemiga)){
                        System.out.println("se detecto colision");
                        naveEnemiga.setDamage(1);
                    }
                }
            }

        }


        if(!proyectilesEnemigos.isEmpty()){
            //caso bala enemiga contra muro y nave propia
            for ( Proyectile bala : proyectilesEnemigos){
                for (Wall muro : walls){
                    if (collision(bala , muro)){
                        System.out.println("se detecto colision");
                        muro.setDamage(1);

                    }
                }

                if( collisionNave(bala,nave)){
                    System.out.println("se detecto colision");
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


        // caso de colision
        return(x1 < x2+e2Ancho &&
                x1 + e1Ancho > x2 &&
                y1 < y2 + e2Alto &&
                y1 + e1Alto > y2);
    }

    private boolean collisionNave(Entity entity1, Entity entity2){
        int x1 = entity1.getPosition().getX();
        int y1= entity1.getPosition().getY();
        int x2 = entity2.getPosition().getX();
        int y2= entity2.getPosition().getY();
        int e1Ancho= entity1.getArea().getAncho();
        int e1Alto=entity1.getArea().getAlto();
        int e2Ancho= entity2.getArea().getAncho();
        int e2Alto=entity2.getArea().getAlto();
        // caso de colision
        return(x1 < x2+e2Ancho &&
                x1 + e1Ancho > x2 &&
                y1 == area.getAlto()-e1Alto);
    }

    public boolean checkShipHealth(){
        return nave.getHealth()<=0;
    }
}
