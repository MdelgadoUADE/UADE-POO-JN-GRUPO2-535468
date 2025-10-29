package org.example.project.models.others;

public class Difficulty {
    private String name;

    private int enemyVelocity;
    private int enemyLife;
    private int enemyROF;

    private int wallLife;

    public Difficulty(int enemyVelocity, int enemyLife, int enemyROF, int wallLife, String name) {
        this.name = name;
        this.enemyVelocity = enemyVelocity;
        this.enemyLife = enemyLife;
        this.enemyROF = enemyROF;
        this.wallLife = wallLife;
    }

    public int getEnemyVelocity() {
        return enemyVelocity;
    }

    public int getEnemyLife() {
        return enemyLife;
    }

    public int getEnemyROF() {
        return enemyROF;
    }

    public int getWallLife() {
        return wallLife;
    }

    public  String getName() {
        return name;
    }
}
