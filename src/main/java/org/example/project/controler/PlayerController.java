package org.example.project.controler;

import org.example.project.models.Ranking;
import org.example.project.models.player.LifeTracker;
import org.example.project.models.player.ScoreTracker;

public class PlayerController {

    private static PlayerController instance;
    private ScoreTracker scoreTracker;
    private LifeTracker lifeTracker;

    private PlayerController() {
        scoreTracker = new ScoreTracker();
        lifeTracker = new LifeTracker(3);
    }

    public static PlayerController getInstance() {
        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }

    public void addScore(int score){
        scoreTracker.setScore(scoreTracker.getScore() + score);
        System.out.println("Score: " + scoreTracker.getScore());
    }

    public void resetScore(){
        scoreTracker.setScore(0);
    }

    public int getLifes() {
        return lifeTracker.getLifes();
    }

    public void addLifes(int quantity) {
        if(getLifes() == 0 && quantity < 0) {
            gameOver();
        } else
            lifeTracker.setLifes(quantity + getLifes());
    }

    public int getScore(){
        return scoreTracker.getScore();
    }

    public void gameOver() {

        System.out.println("U ded");
    }


}
