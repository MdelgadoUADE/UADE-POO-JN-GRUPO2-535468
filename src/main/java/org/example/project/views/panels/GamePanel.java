package org.example.project.views.panels;

import org.example.project.views.imgs.ShipImg;
import org.example.project.views.listeners.KeyListenerAdapter;
import org.example.project.controler.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private ShipImg imagenNave;

    public GamePanel() {
        System.out.println("Constructor Imagen Panel");

        // Config panel
        setLayout(null);
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);

        // Crear imagen
        imagenNave = new ShipImg();
        imagenNave.setBounds(200, 350, 50, 50);
        add(imagenNave);

        setFocusable(true);
        requestFocusInWindow();

        // KeyListener usando tu clase personalizada
        addKeyListener(new KeyListenerAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Si querés también que funcione con flechas:
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        int nuevaXI = GameController.getInstancia().moverNaveIzquierda();
                        imagenNave.mover(imagenNave.getY(), nuevaXI);
                        break;
                    case KeyEvent.VK_RIGHT:
                        int nuevaXD = GameController.getInstancia().moverNaveDerecha();
                        imagenNave.mover(imagenNave.getY(), nuevaXD);
                        break;
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
