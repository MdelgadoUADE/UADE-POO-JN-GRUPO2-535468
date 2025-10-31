package org.example.project.views.panels;

import org.example.project.controler.GameController;
import org.example.project.models.Entity;
import org.example.project.views.imgs.ProyectileDownImg;

import org.example.project.views.imgs.ProyectileUpImg;
import org.example.project.views.imgs.ShipImg;
import org.example.project.views.views.EntityView;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;


public class GamePanelPC extends JPanel {
    private List<ProyectileDownImg> proyectilesEnemigos;
    private List<ProyectileUpImg> proyectilesJugador;
    private int anchoPanel;
    private int altoPanel;

    public GamePanelPC(int ancho, int alto) {
        this.anchoPanel = ancho;
        this.altoPanel = alto;
        setLayout(null);
        setPreferredSize(new Dimension(ancho, alto));
        setBackground(Color.DARK_GRAY);
        proyectilesJugador = new ArrayList<>();
        Timer timer = new Timer(10, e -> {
            //Mover Balas

            if (GameController.getInstancia().checkShipHealth()){
                ((Timer) e.getSource()).stop();
                // finalizar juego porq estoy muerto.
            }

            //MoverBalas
            moverProyectilesJugador();


            //Mover Naves Kiara
            //GameController.getInstancia().moveEntitys();
            //Checkear colicones Seba
            GameController.getInstancia().checkCollisions();
            //Checkear Healths Joaco
            //GameController.getInstancia().checkearHealth();
        });

        timer.start();



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
        int yInicial = altoPanel - p.getAlto(); // justo en el borde inferior del panel
        //System.out.println("xAjustado=" + xAjustado +  " yInicial=" + yInicial + " ancho=" + anchoPanel + " alto=" + altoPanel);
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


}
