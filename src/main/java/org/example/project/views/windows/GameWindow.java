package org.example.project.views.windows;

import org.example.project.views.panels.GamePanel;

import javax.swing.*;

public class GameWindow extends JFrame {
    private GamePanel panel;

    public GameWindow(){
        System.out.println("Constructor Imagen Ventana" );
        panel = new GamePanel();
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
