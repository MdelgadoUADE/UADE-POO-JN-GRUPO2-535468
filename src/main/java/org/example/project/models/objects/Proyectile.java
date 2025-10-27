package org.example.project.models.objects;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public class Proyectile extends Entity {

    private int velocidad;

    public Proyectile(int x, int y, int velocidad, int alto, int ancho,AreaDeJuego area) {
        this.position = new Vector2(x,y);
        this.velocidad = velocidad;
        this.areaObjeto =new AreaDeJuego(alto,ancho);
        this.health =1;
        this.area=area;
    }


    public int mover() {
        if (this.position.getX() - this.velocidad + this.areaObjeto.getAncho() <= area.getAncho()) {
            this.position.setX(this.position.getX() + this.velocidad);
        }
        System.out.println("Se movio izquierda objeto proyectil");
        return this.position.getX();
    }


}
