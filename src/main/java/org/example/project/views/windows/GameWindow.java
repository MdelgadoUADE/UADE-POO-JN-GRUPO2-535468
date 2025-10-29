package org.example.project.views.windows;

import org.example.project.views.panels.DifficultyPanel;
import org.example.project.views.panels.GamePanelPlayer;
import org.example.project.views.panels.GamePanelPC;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GamePanelPlayer panelJugador;
    private GamePanelPC panelPC;
    private DifficultyPanel panelDificultad;

    int ancho = 400;
    int altoJugador = 120; // altura del panel de la nave
    int altoPC = 400;      // altura del panel de proyectiles

    public GameWindow(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //DEJAR EN DO_NOTHING_ON_CLOSE PARA EVITAR CERRAR EL JUEGO
        setLayout(new BorderLayout());

        //todo añadir aca la llamada a GameController para controlar la dificultad
        panelDificultad = new DifficultyPanel(ancho, altoPC);
        add(BorderLayout.CENTER, panelDificultad);
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
    public void setGamePanel() {
        remove(panelDificultad);

        panelPC = new GamePanelPC(ancho, altoPC);
        panelJugador = new GamePanelPlayer(ancho, altoJugador, panelPC);

        add(panelPC, BorderLayout.CENTER);
        add(panelJugador, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
