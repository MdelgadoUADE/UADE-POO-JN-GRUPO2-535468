package org.example.project.views.windows;

import org.example.project.controler.PlayerController;
import org.example.project.models.Ranking;
import org.example.project.views.modals.ContinueOption;
import org.example.project.views.modals.RankingAskModal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartWindow extends JFrame {

    private JLabel titlelbl;

    private JButton startGamebtn;
    private JButton exitbtn;
    private JButton rankingTablebtn;
    private JPanel buttonpnl;

    public StartWindow(){
        this.confWindow();
        this.confEvents();
        this.setVisible(true);
        this.setSize(800,600);
    }

    public void confEvents(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Definicion de botones
        startGamebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GameWindow gw = new GameWindow();
                StartWindow.super.setVisible(false);

                gw.addWindowListener(new WindowAdapter() {
                    //Window listener permite minimizar la ventana principal sin tener que cerrarla
                    @Override
                    public void windowClosing(WindowEvent e) {

                        if (new ContinueOption(StartWindow.this).getResult() == JOptionPane.NO_OPTION){
                            Ranking.getInstance().addEntrada(new RankingAskModal(StartWindow.this).getName());
                            gw.dispose();
                            StartWindow.super.setVisible(true);
                        }
                    }
                });
            }
        });
        rankingTablebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RankingWindow rw =  new RankingWindow(StartWindow.this);
                StartWindow.super.setVisible(false);

                rw.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        StartWindow.super.setVisible(true);
                    }
                });

            }
        });
        exitbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //cierro all con el codigo exitoso
            }
        });

    }

    private void confWindow(){
        this.setTitle("Space Invaders | Main Menu");
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(2,1));

        this.titlelbl = new JLabel("<HTML><PRE>   _____                        _____                     _               <BR>" +
                "  / ____|                      |_   _|                   | |              <BR>" +
                " | (___  _ __   __ _  ___ ___    | |  _ ____   ____ _  __| | ___ _ __ ___ <BR>" +
                "  \\___ \\| '_ \\ / _` |/ __/ _ \\   | | | '_ \\ \\ / / _` |/ _` |/ _ \\ '__/ __|<BR>" +
                "  ____) | |_) | (_| | (_|  __/  _| |_| | | \\ V / (_| | (_| |  __/ |  \\__ \\<BR>" +
                " |_____/| .__/ \\__,_|\\___\\___| |_____|_| |_|\\_/ \\__,_|\\__,_|\\___|_|  |___/<BR>" +
                "        | |                                                               <BR>" +
                "        |_|                                                               </PRE></HTML>");
        this.titlelbl.setHorizontalAlignment(SwingConstants.CENTER);

        this.startGamebtn = new JButton("Comenzar Juego");
        this.rankingTablebtn = new JButton("Rankings");
        this.exitbtn = new JButton("Salir de Juego");


        buttonpnl = new JPanel();
        buttonpnl.setLayout(new GridLayout(3,1));
        buttonpnl.add(this.startGamebtn);
        buttonpnl.add(this.rankingTablebtn);
        buttonpnl.add(this.exitbtn);
        this.add(titlelbl);
        this.add(buttonpnl);
        this.pack();
    }

}
