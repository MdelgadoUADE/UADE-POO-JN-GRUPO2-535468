package org.example.project.models.objects;

import org.example.project.models.Entity;
import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;
import org.example.project.views.views.EntityView;

public class Proyectile extends Entity {

    private static int contador = 0;

    private int velocidad;
    private int id;

    public Proyectile(int x, int y, int velocidad, int alto, int ancho,AreaDeJuego area) {

        this.position = new Vector2(x,y);
        this.velocidad = velocidad;
        this.areaObjeto =new AreaDeJuego(alto,ancho);
        this.health =1;
        this.area=area;
        this.id=contador;
        this.delete=false;
        contador++;
        System.out.println("NEW Proyectil x: "+ this.position.getX() +" y: "+ this.position.getY() + "velocidad: "+ this.velocidad);
    }

    public EntityView getView() {
        return new EntityView(areaObjeto,position,area,velocidad,id,health);
    }


    public int mover() {
        if (this.position.getY() + this.velocidad > -this.areaObjeto.getAlto()*2) {
            this.position.setY(this.position.getY() + this.velocidad);
        }
        System.out.println("Se movio objeto proyectil nuevaY: " + this.position.getY());
        return this.position.getY();
    }

    public int getId() {
        return id;
    }
}
