package org.example.project.views.panels;

import org.example.project.controler.GameController;
import org.example.project.controler.PlayerController;
import org.example.project.models.extras.Vector2;
import org.example.project.views.imgs.*;

import org.example.project.views.views.EntityView;


import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;


public class GamePanelPC extends JPanel {
    private List<EnemyShipImg> enemiesShips;
    private List<ProyectileDownImg> proyectilesEnemigos;
    private List<ProyectileUpImg> proyectilesJugador;
    private List<WallImg> walls;
    private int anchoPanel;
    private int altoPanel;
    private int contadorNavesCreadas;
    private final int TOTAL_NAVES = 15;
    private static final int ANCHO_MURO = 70;
    private static final int ALTO_MURO = 40;
    private static final int ESPACIO_HORIZONTAL = 100; // <-- El espacio
    private Timer timer;


    private final int DISTANCIA_MINIMA_PARA_NUEVA = 80;

    public GamePanelPC(int ancho, int alto) {
        this.anchoPanel = ancho;
        this.altoPanel = alto;
        setLayout(null);
        setPreferredSize(new Dimension(ancho, alto));
        setBackground(Color.BLACK);
        proyectilesJugador = new ArrayList<>();
        enemiesShips = new ArrayList<>();
        proyectilesEnemigos = new ArrayList<>();
        walls = new ArrayList<>();
        // crear muros
        crearWalls(anchoPanel,altoPanel,ANCHO_MURO,ESPACIO_HORIZONTAL,ALTO_MURO);

        contadorNavesCreadas = 0;
        // Crear la primera nave inicial
        crearNaveEnemiga();
        contadorNavesCreadas++;

        timer = new Timer(10, e -> {
            //Mover Balas

            if (GameController.getInstancia().checkShipHealth()){
                ((Timer) e.getSource()).stop();
                restoreGame();
            }

            if (GameController.getInstancia().isThereNoEnemyShipsLeft()) {
                newGame();
                PlayerController.getInstance().addScore(200);
            }

            //Crear Naves
            if (contadorNavesCreadas < TOTAL_NAVES && ultimaNaveSeMovioSuficiente()) {
                crearNaveEnemiga();
                contadorNavesCreadas++;
            }
            //MoverBalas
            moverProyectilesJugador();
            moverProyectilesEnemigos();
            //Mover Naves Kiara
            moverNaveEnemigo();
            //Disparo Enemigo
            int id = GameController.getInstancia().asignarDisparo();
            if (id!=0){
                crearProyectilEnemigo(id);
            }

            //Checkear colicones Seba
            GameController.getInstancia().checkCollisions();

            //Checkear Healths Joaco
            //GameController.getInstancia().checkearHealth();

            //Eliminar elementos
            GameController.getInstancia().limpiar();
            sincronizarVistaModelo();
            repaint();
        });

        timer.start();



    }
    //Metodo utilizado para sincronizar las views con la logica de negocio y saber si eliminar o no
    private void sincronizarVistaModelo() {

        proyectilesEnemigos.removeIf(balaImg -> {
            if(GameController.getInstancia().buscarProyectilEnemigo(balaImg.getId())==null){
                remove(balaImg);
                return true;
            }
            return false;
        } );

        proyectilesJugador.removeIf(balaImg -> {
            if(GameController.getInstancia().buscarProyectilJugador(balaImg.getId())==null){
                remove(balaImg);
                return true;
            }
            return false;
        } );

        walls.removeIf(wallImg -> {
            if(GameController.getInstancia().buscarWall(wallImg.getId())==null){
                remove(wallImg);
                return true;
            }
            return false;
        } );

        enemiesShips.removeIf(enemyShipImg -> {
            if(GameController.getInstancia().buscarNaveEnemigo(enemyShipImg.getId())==null){
                remove(enemyShipImg);
                return true;
            }
            return false;
        } );


    }

    private void crearWalls(int anchoPanel, int altoPanel, int ANCHO_MURO ,int ESPACIO_HORIZONTAL,int ALTO_MURO) {

        //bloque = ancho muro mas espacio
        int bloque = ANCHO_MURO+ESPACIO_HORIZONTAL;
        int cantWallFila = (anchoPanel+ESPACIO_HORIZONTAL)/(bloque);

        int y = altoPanel - 40;
        int x = 0;


        for(int i=0; i<cantWallFila;i++){
            int id=GameController.getInstancia().crearWall(x,y,ANCHO_MURO,ALTO_MURO);
            WallImg w = new WallImg(id);
            w.setBounds(x,y,w.getAncho(),w.getAlto());
            System.out.println("Ancho: " + w.getAncho() + " Alto: " + w.getAlto() + " X: " + x + " Y: " + y);
            add(w);
            walls.add(w);
            x += bloque;


        }
        repaint();
    }

    public void crearProyectil(int centroNaveX) {
        int id = GameController.getInstancia().crearProyectilJugador();
        ProyectileUpImg p = new ProyectileUpImg(id);

        int xAjustado = centroNaveX - p.getAncho() / 2;
        int yInicial = altoPanel - p.getAlto(); // justo en el borde inferior del panel

        System.out.println("xAjustado=" + xAjustado +  " yInicial=" + yInicial + " ancho=" + anchoPanel + " alto=" + altoPanel);

        p.setBounds(xAjustado, yInicial, p.getAncho(), p.getAlto());
        add(p);
        proyectilesJugador.add(p);
        repaint();
    }

    public void crearProyectilEnemigo(int idNave) {
        int id = GameController.getInstancia().crearProyectilEnemigo(idNave);

        ProyectileDownImg p = new ProyectileDownImg(id);
        EntityView e = GameController.getInstancia().buscarNaveEnemigo(idNave);

        int centroNaveX = GameController.getInstancia().centroEntity(e);
        int xAjustado = centroNaveX - p.getAncho() / 2;
        int yInicial = e.getPosition().getY() + e.getAreaObjeto().getAlto();

        p.setBounds(xAjustado, yInicial, p.getAncho(), p.getAlto());
        add(p);
        proyectilesEnemigos.add(p);
        repaint();
    }

    public void moverProyectilesJugador(){
        for (int i = 0; i < proyectilesJugador.size(); i++) {
            ProyectileUpImg p = proyectilesJugador.get(i);
            int nuevaY = GameController.getInstancia().moverProyectil(p.getId());
            if (nuevaY < -p.getAlto()) {
                remove(p);
                proyectilesJugador.remove(p);
                repaint();
            } else {
                p.mover(p.getX(), nuevaY);
            }
        }
    }
    public void moverProyectilesEnemigos(){
        for (int i = 0; i < proyectilesEnemigos.size(); i++) {
            ProyectileDownImg p = proyectilesEnemigos.get(i);
            int nuevaY = GameController.getInstancia().moverProyectilEnemigo(p.getId());
            if (nuevaY > altoPanel) {
                remove(p);
                proyectilesEnemigos.remove(p);
                repaint();
            } else {
                p.mover(p.getX(), nuevaY);
            }
        }
    }

    public void crearNaveEnemiga(){
        int idNave = GameController.getInstancia().crearEnemigoJugador();
        EnemyShipImg nave = new EnemyShipImg(idNave);
        int xInicial = 0;
        int yInicial = 0;
        nave.setBounds(xInicial, yInicial, nave.getAncho(), nave.getAlto());
        add(nave);
        enemiesShips.add(nave);

        //System.out.println("Nave enemiga creada en X=" + xInicial + ", Y=" + yInicial);
        revalidate();
        repaint();
    }
    private boolean ultimaNaveSeMovioSuficiente() {
        if (enemiesShips.isEmpty()) return false;

        EnemyShipImg ultima = enemiesShips.get(enemiesShips.size() - 1);
        return ultima.getX() >= DISTANCIA_MINIMA_PARA_NUEVA;
    }

    public void moverNaveEnemigo(){
        for (int i = 0; i < enemiesShips.size(); i++) {
            EnemyShipImg e = enemiesShips.get(i);
            Vector2 nuevoV = GameController.getInstancia().moverNaveEnemiga(e.getId());
            if (nuevoV.getY() > altoPanel){
                remove(e);
                enemiesShips.remove(e);
                repaint();
            } else {
                e.mover(nuevoV.getX(), nuevoV.getY());
            }
        }
    }

    private void restoreGame() {
        PlayerController.getInstance().addLifes(-1);
        newGame();
    }

    private void newGame() {
        GameController.getInstancia().restoreStatus();
        crearNaveEnemiga();
        contadorNavesCreadas = 1;
        crearWalls(anchoPanel,altoPanel,ANCHO_MURO,ESPACIO_HORIZONTAL,ALTO_MURO);
        timer.start();
    }
}




