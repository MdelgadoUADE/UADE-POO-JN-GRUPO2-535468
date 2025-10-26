package org.example.project.models.objects;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public class Proyectile extends Entity {
    private int health = 1;
    private Vector2 posicion;
    private int velocidad;
    private int alto;
    private int ancho;
    private AreaDeJuego area;

    public Proyectile(int x, int y, int velocidad, int alto, int ancho, AreaDeJuego area) {
        this.posicion = new Vector2(x,y);
        this.velocidad = velocidad;
        this.alto = alto;
        this.ancho = ancho;
        this.area = area;
    }

    public int mover() {
        if (this.posicion.getX() - this.velocidad + this.ancho <= area.getAncho()) {
            this.posicion.setX(this.posicion.getX() + this.velocidad);
        }
        System.out.println("Se movio izquierda objeto proyectil");
        return this.posicion.getX();
    }
}
