package org.example.project.views.windows;

import org.example.project.models.Ranking;
import org.example.structures.EntradaJugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class RankingWindow extends JFrame {

    private JLabel titlelbl;
    private JLabel textlbl;
    private JPanel rankings;
    private LinkedList<EntradaJugador> jugadores;

    private JButton backbtn;

    public RankingWindow() {
        jugadores = Ranking.getInstance().aa();

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
            }
        });
    }

    public void confWindow(){
        this.setTitle("Space Invaders | Ranking");
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(4,1));

        this.titlelbl = new JLabel("Rankings");
        this.textlbl = new JLabel("Here lie the best of the best");
        this.backbtn = new JButton("Ir Atras");



        this.add(titlelbl);
        this.add(textlbl);

        if (!jugadores.isEmpty()){
            rankings = new JPanel(new GridLayout(jugadores.size(),2));
            for (int i = 0; i < jugadores.size(); i++){
                rankings.add(new JLabel(jugadores.get(i).getNombreJugador()));
                rankings.add(new JLabel(String.valueOf(jugadores.get(i).getPuntaje())));
            }
            this.add(rankings);
        } else this.add(new JLabel("Sin Jugadores"));

        this.add(backbtn);

        this.pack();
    }


}
