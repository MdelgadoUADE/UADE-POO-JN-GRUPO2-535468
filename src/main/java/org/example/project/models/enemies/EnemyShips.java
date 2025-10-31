package org.example.project.models.enemies;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;
import org.example.project.views.views.EntityView;

public class EnemyShips extends Entity {
    private static int contador;
    private int id;
    private int velocidad;
    
    public EnemyShips(int x, int y, int velocidad, int alto, int ancho, AreaDeJuego area){
        this.position = new Vector2(x,y);
        this.areaObjeto = new AreaDeJuego(alto,ancho);
        this.health = 4;
        this.area=area;
        this.velocidad=velocidad;
        this.id=contador;
        contador++;
    }

    public EntityView getView() {
        return new EntityView(areaObjeto,position,area,velocidad,id,health);
    }

    public int getId() {return id;}
}
