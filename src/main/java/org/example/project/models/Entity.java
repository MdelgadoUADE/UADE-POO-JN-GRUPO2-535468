package org.example.project.models;

import org.example.project.models.extras.AreaDeJuego;
import org.example.project.models.extras.Vector2;

public abstract class Entity {
    protected Vector2 position;
    protected int health;
    protected AreaDeJuego areaObjeto;
    protected AreaDeJuego area;
    protected boolean delete;


    public Vector2 getPosition() {
        return position;
    }

    public int getHealth() {
        return health;
    }
/*
    public void setPosition(Vector2 position) {
        this.position = position;
    }
*/
    protected void setHealth(int health) {
        this.health = health;
    }

    public  void setDamage(int damage){this.setHealth(this.getHealth()-damage);}

    public AreaDeJuego getArea() {
        return areaObjeto;
    }

    public void setDelete(){
        this.delete =true;
    }

    public boolean isDelete() {
        return delete;
    }
}
