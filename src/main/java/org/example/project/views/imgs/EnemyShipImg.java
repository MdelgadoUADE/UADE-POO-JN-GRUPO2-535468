package org.example.project.views.imgs;

import javax.swing.*;
import java.awt.*;

public class EnemyShipImg extends JLabel{
    private int ancho = 50;
    private int alto = 50;
    private int id;

    public EnemyShipImg(int id) {
        System.out.println("Constructor Imagen Nave Enemiga");
        Image imagen = new ImageIcon("naveEnemiga.png").getImage();
        Image imagenEscala = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(imagenEscala));
        setSize(ancho, alto);
        this.id = id;
    }

    public void mover(int nuevaX, int nuevaY) {
        setLocation(nuevaX, nuevaY);
        //System.out.println("Se movió imagen a X=" + nuevaX + " Y=" + nuevaY);
    }

    public int getId() {return id;}
    public int getAncho() {
        return ancho;
    }
    public int getAlto() {
        return alto;
    }
}
