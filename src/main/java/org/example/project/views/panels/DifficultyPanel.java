package org.example.project.views.panels;

import org.example.project.constants.DifficultyConstants;
import org.example.project.controler.GameController;
import org.example.project.views.windows.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyPanel extends JPanel {
    private JLabel panelTitle;

    private JButton cadeteBtn;
    private JButton guerreroBtn;
    private JButton maestroBtn;

    private GameWindow fatherPanel;

    public DifficultyPanel(int ancho, int alto, GameWindow fatherPanel)
    {
        setPanel(ancho, alto);
        this.fatherPanel = fatherPanel;
    }

    private void setPanel(int ancho, int alto) {

        initComponents();
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(ancho, alto));

        add(panelTitle);
        add(cadeteBtn);
        add(guerreroBtn);
        add(maestroBtn);

        addButtonActions();
    }

    private void addButtonActions(){
        cadeteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha seleccionado: " + DifficultyConstants.DIFICULTAD_CADETE.getName());
                GameController.getInstancia().setDifficulty(DifficultyConstants.DIFICULTAD_CADETE);
                fatherPanel.setGamePanel();
            }
        });

        guerreroBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha seleccionado: " + DifficultyConstants.DIFICULTAD_GUERRERO.getName());
                GameController.getInstancia().setDifficulty(DifficultyConstants.DIFICULTAD_GUERRERO);
                fatherPanel.setGamePanel();
            }
        });

        maestroBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha seleccionado: " + DifficultyConstants.DIFICULTAD_MAESTRO.getName());
                GameController.getInstancia().setDifficulty(DifficultyConstants.DIFICULTAD_MAESTRO);
                fatherPanel.setGamePanel();
            }
        });
    }

    private void initComponents()
    {
        this.setLayout(new GridLayout(4,1));
        panelTitle = new JLabel("Por favor seleccione una dificultad");

        cadeteBtn = new JButton("Cadete");
        guerreroBtn = new JButton("Guerrero");
        maestroBtn = new JButton("Maestro");
    }

}
