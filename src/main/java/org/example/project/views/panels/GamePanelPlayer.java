package org.example.project.views.panels;

import org.example.project.controler.PlayerController;
import org.example.project.views.imgs.ShipImg;
import org.example.project.controler.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanelPlayer extends JPanel {
    private ShipImg imagenNave;
    private GamePanelPC panelPC;

    public GamePanelPlayer(int ancho, int alto, GamePanelPC panelPC) {
        this.panelPC = panelPC;

        setLayout(null);
        setPreferredSize(new Dimension(ancho, alto));
        setBackground(Color.BLACK);

        imagenNave = new ShipImg();
        // colocar nave centrada horizontalmente
        int xInicial = (ancho - imagenNave.getAncho()) / 2;
        int yInicial = (alto - imagenNave.getAlto()) / 2;
        imagenNave.setBounds(xInicial, yInicial, imagenNave.getAncho(), imagenNave.getAlto());
        add(imagenNave);

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        int nuevaXI = GameController.getInstancia().moverNaveIzquierda();
                        imagenNave.mover(nuevaXI, imagenNave.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        int nuevaXD = GameController.getInstancia().moverNaveDerecha();
                        imagenNave.mover(nuevaXD, imagenNave.getY());
                        break;
                    case KeyEvent.VK_SPACE:
                        int centroNave = imagenNave.getX() + imagenNave.getAncho() / 2;
                        panelPC.crearProyectil(centroNave);
                        break;
                    case KeyEvent.VK_F1:
                        PlayerController.getInstance().addScore(5);
                    case KeyEvent.VK_F2:
                        PlayerController.getInstance().addLifes(-1);
                    case KeyEvent.VK_F3:
                        PlayerController.getInstance().addLifes(1);
                }
            }
        });
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }
}
