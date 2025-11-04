package org.example.project.views.imgs;

import javax.swing.*;
import java.awt.*;

public class WallImg  extends JLabel {
    private int ancho = 70;
    private int alto = 40;
    private int id;

    public WallImg(int id){
        this.id=id;
        System.out.println("Constructor Imagen wall");
        Image imagen = new ImageIcon("wall2.png").getImage();
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

    public int getId() {
        return id;
    }
}
