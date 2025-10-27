package org.example.project.models.enemies;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public class EnemyShips extends Entity {
    
    private int velocidad;
    
    public EnemyShips(int x, int y, int velocidad, int alto, int ancho, AreaDeJuego area){
        this.position = new Vector2(x,y);
        this.areaObjeto = new AreaDeJuego(alto,ancho);
        this.health = 4;
        this.area=area;
        this.velocidad=velocidad;
    }

}
