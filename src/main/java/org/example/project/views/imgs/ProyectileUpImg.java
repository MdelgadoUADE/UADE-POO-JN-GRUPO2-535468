package org.example.project.views.imgs;

import javax.swing.*;
import java.awt.*;

public class ProyectileUpImg extends JLabel {
    private  int ancho;
    private  int alto;
    private int id;

    public ProyectileUpImg(int id) {
        //System.out.println("Constructor Imagen Proyectil");
        this.id = id;
        ancho = 50;
        alto = 50;
        Image imagen = new ImageIcon("proyectileUp.png").getImage();
        Image imagenEscala = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(imagenEscala));
        setSize(ancho, alto); // muy importante para que Swing sepa el tamaño
    }

    public void mover(int nuevaX, int nuevaY) {
        setLocation(nuevaX, nuevaY);
        System.out.println("Se movió imagen a X=" + nuevaX + " Y=" + nuevaY);
    }

    // GETTERS
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; }
    public int getId() {return id;}
}
