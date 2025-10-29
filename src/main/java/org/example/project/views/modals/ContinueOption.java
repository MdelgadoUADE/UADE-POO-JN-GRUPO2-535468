package org.example.project.views.modals;

import javax.swing.*;

public class ContinueOption {
    private JFrame container;
    public ContinueOption(JFrame container) {
        this.container = container;
    }

    public int getResult(){
        return JOptionPane.showConfirmDialog(
                container,
                "Desea continuar?",
                "Confirmar Salida",
                JOptionPane.YES_NO_OPTION
        );
    }
}
