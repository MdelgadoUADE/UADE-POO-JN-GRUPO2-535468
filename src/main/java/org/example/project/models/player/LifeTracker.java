package org.example.project.models.player;

public class LifeTracker {
    private int lifes;

    public LifeTracker(int lifes) {
        this.lifes = lifes;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
        System.out.println("La vida ahora es: " + lifes);
    }
}
