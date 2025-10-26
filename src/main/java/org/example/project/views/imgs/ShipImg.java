package org.example.project.views.imgs;

import javax.swing.*;
import java.awt.*;

public class ShipImg  extends JLabel{
    private int ancho = 50;
    private int alto = 50;

    public ShipImg() {
        System.out.println("Constructor Imagen Nave");
        Image imagen = new ImageIcon("nave.jpg").getImage();
        Image imagenEscala = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(imagenEscala));
        setSize(ancho, alto);
    }

    public void mover(int nuevaX, int nuevaY) {
        setLocation(nuevaX, nuevaY);
        System.out.println("Se movió imagen a X=" + nuevaX + " Y=" + nuevaY);
    }

    public int getAncho() {
        return ancho;
    }
    public int getAlto() {
        return alto;
    }
}
