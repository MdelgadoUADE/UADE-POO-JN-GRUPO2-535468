package org.example.project.views.imgs;

import javax.swing.*;
import java.awt.*;

public class ShipImg  extends JLabel{
    private static final long serialVersionUID =870023;
    private int ancho;
    private int alto;

    public ShipImg(){
        System.out.println("Constructor Imagen Nave" );
        ancho = 50;
        alto = 50;
        Image imagen = new ImageIcon("nave.jpg").getImage();
        Image imagenEscala = imagen.getScaledInstance(ancho,alto,imagen.SCALE_SMOOTH);
        ImageIcon icono  = new ImageIcon(imagenEscala);
        setIcon(icono);


    }

    public void mover(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        setLocation(ancho, alto); // <-- importante
        System.out.println("Se movió imagen a X=" + ancho + " Y=" + alto);
    }
}
