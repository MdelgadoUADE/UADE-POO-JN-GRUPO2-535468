package org.example.project.views.windows;

import javax.swing.*;
import java.awt.*;

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
