package org.example.project.views.panels;

import org.example.project.controler.PlayerController;
import org.example.project.views.imgs.LifeImg;
import org.example.project.views.imgs.ShipImg;
import org.example.project.controler.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanelPlayer extends JPanel {
    private ShipImg imagenNave;
    private GamePanelPC panelPC;
    private JLabel playerScoreLabel;
    private JLabel playerLifesLabel;
    private LifeImg lifeImg;
    private static final int TIEMPO_ENTRE_DISPAROS_PJ = 1000;
    private long ultimoDisparo_PJ = 0;

    public GamePanelPlayer(int ancho, int alto, GamePanelPC panelPC) {
        this.panelPC = panelPC;

        setLayout(null);
        setPreferredSize(new Dimension(ancho, alto));
        setBackground(Color.BLACK);

        imagenNave = new ShipImg();
        lifeImg = new LifeImg();
        playerScoreLabel = new JLabel("0");
        playerLifesLabel = new JLabel("0");

        // nave centrada horizontalmente
        int xInicial = (ancho - imagenNave.getAncho()) / 2;
        int yInicial = (alto - imagenNave.getAlto()) / 2;
        imagenNave.setBounds(xInicial, yInicial, imagenNave.getAncho(), imagenNave.getAlto());
        playerScoreLabel.setBounds(ancho - ancho / 5, alto - alto / 2, 100, 50);
        lifeImg.setBounds(ancho / 20, alto - alto / 2, 40, 40 );
        playerLifesLabel.setBounds(ancho / 7, alto - alto / 2, 50, 50);

        add(imagenNave);
        add(playerScoreLabel);
        add(lifeImg);
        add(playerLifesLabel);

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
                        long ahora = System.currentTimeMillis();
                        if (ahora - ultimoDisparo_PJ >= TIEMPO_ENTRE_DISPAROS_PJ) {
                            int centroNave = imagenNave.getX() + imagenNave.getAncho() / 2;
                            panelPC.crearProyectil(centroNave);
                            ultimoDisparo_PJ = ahora;
                        }
                        break;
                    case KeyEvent.VK_F1:
                        PlayerController.getInstance().addScore(200);
                        break;
                    case KeyEvent.VK_F2:
                        PlayerController.getInstance().addLifes(-1);
                        break;
                    case KeyEvent.VK_F3:
                        PlayerController.getInstance().addLifes(1);
                        break;
                }
            }
        });
    }

    public void updateLifes(int lifes){
        if (lifes < 0){
            playerLifesLabel.setText(String.valueOf(0));
        } else {
            playerLifesLabel.setText(String.valueOf(lifes));
        }
    }
    public void updateScore(int score){
        playerScoreLabel.setText("Score: " + score);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }
}
