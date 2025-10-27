package org.example.project.models.player;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public class PlayerShip extends Entity {

    private int velocidad;

    public PlayerShip(int x, int y, int velocidad, int alto, int ancho, AreaDeJuego area) {
        this.position = new Vector2(x,y);
        this.velocidad = velocidad;
        this.areaObjeto= new AreaDeJuego(alto,ancho);
        this.area=area;
        this.health=3;
    }

    public int moverIzquierda() {
        if (this.position.getX() - this.velocidad > 0) {
            this.position.setX(this.position.getX() - this.velocidad);
        }
        System.out.println("Se movio izquierda objeto nave");
        return this.position.getX();
    }

    public int moverDerecha() {
        if (this.position.getX() - this.velocidad + this.areaObjeto.getAncho() <= area.getAncho()) {
            this.position.setX(this.position.getX() + this.velocidad);
        }
        System.out.println("Se movio derecha objeto nave");
        return this.position.getX();
    }


}
