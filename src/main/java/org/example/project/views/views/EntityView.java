package org.example.project.views.views;

import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public class EntityView {

    private int velocidad;
    private int id;
    private Vector2 position;
    private int health;
    private AreaDeJuego areaObjeto;
    private AreaDeJuego area;

    public EntityView() {}

    public EntityView(AreaDeJuego areaObjeto, Vector2 position, AreaDeJuego area, int velocidad, int id, int health) {
        this.areaObjeto = areaObjeto;
        this.position = position;
        this.velocidad = velocidad;
        this.id = id;
        this.health = health;
        this.area = area;
    }


    //GETTERS
    public int getId() {return id;}
    public Vector2 getPosition() {return position;}
    public int getHealth() {return health;}
    public AreaDeJuego getAreaObjeto() {return areaObjeto;}
    public int getVelocidad() {return velocidad;}
    public AreaDeJuego getArea() {return area;}

    //SETTERS
    public void setId(int id) {this.id = id;}
    public void setPosition(Vector2 position) {this.position = position;}
    public void setHealth(int health) {this.health = health;}
    public void setArea(AreaDeJuego area) {this.area = area;}
    public void setVelocidad(int velocidad) {this.velocidad = velocidad;}
    public void setAreaObjeto(AreaDeJuego areaObjeto) {this.areaObjeto = areaObjeto;}
}
