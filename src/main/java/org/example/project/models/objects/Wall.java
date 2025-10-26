package org.example.project.models.objects;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public class Wall extends Entity {

    private int health = 1;
    private Vector2 posicion;
    private int alto;
    private int ancho;
    private AreaDeJuego area;


    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public Vector2 getPosicion() {
        return posicion;
    }
}


