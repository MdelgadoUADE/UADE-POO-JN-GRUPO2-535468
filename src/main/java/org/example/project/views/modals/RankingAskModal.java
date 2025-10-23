package org.example.project.views.modals;

import javax.swing.*;

public class RankingAskModal {
    private JFrame container;

    public RankingAskModal(JFrame container) {
        this.container = container;
    }

    public String getName() {
        String s = (String)JOptionPane.showInputDialog(
                container,
                "Ingrese su nombre:",
                "PERDISTE",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );
        return s;
    }

}
