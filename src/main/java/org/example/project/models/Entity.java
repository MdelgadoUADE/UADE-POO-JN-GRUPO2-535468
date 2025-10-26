package org.example.project.models;

import org.example.project.models.extras.Vector2;

public class Entity {
    protected Vector2 position;
    protected short health;
    // protected Vector2 hitbox[]; definir implementacion de hitboxes


    public Vector2 getPosition() {
        return position;
    }
}
