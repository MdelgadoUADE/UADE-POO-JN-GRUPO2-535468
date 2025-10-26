package org.example.project.views.windows;

import org.example.project.views.panels.GamePanel;
import org.example.project.views.panels.GamePanelPC;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GamePanel panelJugador;
    private GamePanelPC panelPC;

    public GameWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        int ancho = 400;
        int altoJugador = 120; // altura del panel de la nave
        int altoPC = 400;      // altura del panel de proyectiles

        panelPC = new GamePanelPC(ancho, altoPC);
        panelJugador = new GamePanel(ancho, altoJugador, panelPC);

        add(panelPC, BorderLayout.CENTER);
        add(panelJugador, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        /*
        configurarPanelJugador();
        pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
        */
    }

}
