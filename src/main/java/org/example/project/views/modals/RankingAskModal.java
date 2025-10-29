package org.example.project.views.modals;

import javax.swing.*;

public class RankingAskModal {
    private JFrame container;

    public RankingAskModal(JFrame container) {
        this.container = container;
    }

    public String getName() {
        return  (String)JOptionPane.showInputDialog(
                container,
                "Ingrese su nombre:",
                "HAS PERDIDO",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );
    }
    public void showWarning() {
        JOptionPane.showMessageDialog(null, "No sera guardado el ranking", "HAS PERDIDO", JOptionPane.WARNING_MESSAGE);
    }

}
