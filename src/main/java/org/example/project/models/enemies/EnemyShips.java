package org.example.project.models.enemies;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public class EnemyShips extends Entity {
    private int health = 1;
    private Vector2 posicion;
    private int velocidad;
    private int alto;
    private int ancho;
    private AreaDeJuego area;

    public int getHealth() {
        return health;
    }

    public Vector2 getPosicion() {
        return posicion;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPosicion(Vector2 posicion) {
        this.posicion = posicion;
    }
}
