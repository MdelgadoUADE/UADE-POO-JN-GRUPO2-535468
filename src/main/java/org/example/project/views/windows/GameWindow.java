package org.example.project.views.windows;

import org.example.project.controler.GameController;
import org.example.project.controler.PlayerController;
import org.example.project.interfaces.GameListener;
import org.example.project.models.Ranking;
import org.example.project.views.modals.RankingAskModal;
import org.example.project.views.panels.DifficultyPanel;
import org.example.project.views.panels.GamePanelPlayer;
import org.example.project.views.panels.GamePanelPC;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame implements GameListener {
    private JFrame previousFrame;
    private GamePanelPlayer panelJugador;
    private GamePanelPC panelPC;
    private DifficultyPanel panelDificultad;

    int ancho = 420;
    int altoJugador = 120; // altura del panel de la nave
    int altoPC = 400;      // altura del panel de proyectiles

    public GameWindow(JFrame previousFrame){
        PlayerController.getInstance().addListener(this);
        PlayerController.getInstance().restoreStatus();
        GameController.getInstancia().restoreStatus();

        this.previousFrame = previousFrame;
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //DEJAR EN DO_NOTHING_ON_CLOSE PARA EVITAR CERRAR EL JUEGO
        setLayout(new BorderLayout());

        panelDificultad = new DifficultyPanel(ancho, altoPC, this);
        add(BorderLayout.CENTER, panelDificultad);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void setGamePanel() {
        remove(panelDificultad);

        panelPC = new GamePanelPC(ancho, altoPC);
        panelJugador = new GamePanelPlayer(ancho, altoJugador, panelPC);

        panelJugador.updateScore(PlayerController.getInstance().getScore());
        panelJugador.updateLifes(PlayerController.getInstance().getLifes());

        add(panelPC, BorderLayout.CENTER);
        add(panelJugador, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void onGameOver() {
        String name = new RankingAskModal(this).getName();
        if (name != null){
            Ranking.getInstance().addEntrada(name);
        } else new RankingAskModal(this).showWarning();

        PlayerController.getInstance().removeListener(this);
        previousFrame.setVisible(true);
        this.dispose();
    }

    public void stopTimer(){
        panelPC.stopTimer();
    }

    @Override
    public void onScoreChange(int score) {
        if (panelJugador != null) {
            panelJugador.updateScore(score);
        }
    }

    @Override
    public void onLifeChange(int life) {
        panelJugador.updateLifes(life);
    }
}
