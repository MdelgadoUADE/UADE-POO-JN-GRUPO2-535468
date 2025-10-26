package org.example.project.views.panels;

import org.example.project.controler.GameController;
import org.example.project.views.imgs.ProyectileImg;
import org.example.project.views.imgs.ShipImg;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;


public class GamePanelPC extends JPanel {
    private List<ProyectileImg> proyectiles;
    private int anchoPanel;
    private int altoPanel;

    public GamePanelPC(int ancho, int alto) {
        this.anchoPanel = ancho;
        this.altoPanel = alto;
        setLayout(null);
        setPreferredSize(new Dimension(ancho, alto));
        setBackground(Color.BLACK);
        proyectiles = new ArrayList<>();
    }

    public void crearProyectil(int centroNaveX) {
        ProyectileImg p = new ProyectileImg();

        int xAjustado = centroNaveX - p.getAncho() / 2;
        int yInicial = altoPanel - p.getAlto(); // justo en el borde inferior del panel
        System.out.println("xAjustado=" + xAjustado +  " yInicial=" + yInicial + " ancho=" + anchoPanel + " alto=" + altoPanel);
        p.setBounds(xAjustado, yInicial, p.getAncho(), p.getAlto());
        add(p);
        proyectiles.add(p);
        repaint();

        // Animación hacia arriba
        Timer timer = new Timer(10, e -> {
            int nuevaY = p.getY() - 5;
            if (nuevaY < -p.getAlto()) {
                remove(p);
                proyectiles.remove(p);
                ((Timer) e.getSource()).stop();
                repaint();
            } else {
                p.mover(p.getX(), nuevaY);
            }
        });
        timer.start();
    }
}
