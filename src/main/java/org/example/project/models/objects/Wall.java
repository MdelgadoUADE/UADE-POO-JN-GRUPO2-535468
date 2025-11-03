package org.example.project.models.objects;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public class Wall extends Entity {
    private static int contador = 0;
    private int id;

    public Wall(int x,int y, int ancho, int alto,AreaDeJuego area) {
        this.id=contador;
        this.position = new Vector2(x,y); // 'this.position' es el campo protected de Entity
        this.areaObjeto= new AreaDeJuego(alto,ancho);
        this.health = 4;
        this.area=area;
        contador++;
        this.delete=false;

    }

    public int getId() {
        return id;
    }
}


