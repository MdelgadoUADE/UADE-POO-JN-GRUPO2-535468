package org.example.project.views.windows;

import org.example.project.models.Ranking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankingWindow extends JFrame {

    private JFrame lastPanel;
    private JLabel titlelbl;
    private JLabel textlbl;
    private JPanel rankings;

    private JButton backbtn;

    public RankingWindow(JFrame lastPanel) {
        this.lastPanel = lastPanel;
        this.confWindow();
        this.confEvents();
        this.setVisible(true);
        this.setSize(800,600);
    }

    public void confEvents(){
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RankingWindow.super.dispose();
                lastPanel.setVisible(true);
            }
        });
    }

    public void confWindow(){
        this.setTitle("Space Invaders | Ranking");
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(4,1));

        this.titlelbl = new JLabel("Rankings", SwingConstants.CENTER);
        this.textlbl = new JLabel("Here lie the best of the best", SwingConstants.CENTER);
        this.backbtn = new JButton("Ir Atras");

        this.add(titlelbl);
        this.add(textlbl);


        if (!Ranking.getInstance().getRankingView().isEmpty()) {
            int pSize = Ranking.getInstance().getRankingView().size();

            rankings = new JPanel(new GridLayout(
                    pSize,
                    2
            ));
            for (int i = 0; i < pSize; i++) {
                String name = Ranking.getInstance().getRankingView().getEntradaJugador(i).getNombreJugador();
                int puntaje = Ranking.getInstance().getRankingView().getEntradaJugador(i).getPuntaje();
                rankings.add(new JLabel(name + ": ", SwingConstants.RIGHT));
                rankings.add(new JLabel(" " + puntaje));
            }
            this.add(rankings);
        } else this.add(new JLabel("Sin Jugadores", SwingConstants.CENTER));

        this.add(backbtn);

        this.pack();
    }


}
