package org.example.project.views.panels;

import org.example.project.constants.DifficultyConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyPanel extends JPanel {
    private JLabel panelTitle;

    private JButton cadeteBtn;
    private JButton guerreroBtn;
    private JButton maestroBtn;

    public DifficultyPanel(int ancho, int alto)
    {
        setPanel(ancho, alto);
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
            }
        });

        guerreroBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha seleccionado: " + DifficultyConstants.DIFICULTAD_GUERRERO.getName());
            }
        });

        maestroBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha seleccionado: " + DifficultyConstants.DIFICULTAD_MAESTRO.getName());
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
