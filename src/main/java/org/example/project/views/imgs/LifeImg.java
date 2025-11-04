package org.example.project.views.imgs;

import javax.swing.*;
import java.awt.*;

public class LifeImg extends JLabel{
    private int ancho = 30;
    private int alto = 30;

    public LifeImg() {
        Image imagen = new ImageIcon("life.png").getImage();
        Image imagenEscala = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(imagenEscala));
        setSize(ancho, alto);
    }

    public int getAncho() {
        return ancho;
    }
    public int getAlto() {
        return alto;
    }

}
