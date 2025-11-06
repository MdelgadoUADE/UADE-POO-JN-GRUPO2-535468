package org.example.project.controler;

import org.example.project.interfaces.GameListener;
import org.example.project.models.player.LifeTracker;
import org.example.project.models.player.ScoreTracker;

import java.util.LinkedList;
import java.util.List;

public class PlayerController {

    private List<GameListener> listeners;
    private static PlayerController instance;
    private ScoreTracker scoreTracker;
    private LifeTracker lifeTracker;

    private PlayerController() {
        listeners = new LinkedList<>();
        scoreTracker = new ScoreTracker();
        lifeTracker = new LifeTracker(3);
    }

    public void restoreStatus() {
        scoreTracker.setScore(0);
        lifeTracker.setLifes(3);
    }

    public static PlayerController getInstance() {
        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }

    public void addScore(int score){
        notifyScoreChange(getScore() + score);
        if (scoreTracker.setScore(scoreTracker.getScore() + score)) addLifes(1);
        System.out.println("Score: " + scoreTracker.getScore());
    }

    public void resetScore(){
        scoreTracker.setScore(0);
    }

    public int getLifes() {
        return lifeTracker.getLifes();
    }

    public void addLifes(int quantity) {
        notifyLifeChange(getLifes() + quantity);
        if((getLifes() - quantity < 0 )|| (getLifes() == 0 && quantity < 0) ) {
            notifyGameOver();
        } else
            lifeTracker.setLifes(quantity + getLifes());

    }

    public int getScore(){
        return scoreTracker.getScore();
    }

    // logica de patron observer
    public void addListener(GameListener listener) {
        listeners.add(listener);
    }

    public void removeListener(GameListener listener) {
        listeners.remove(listener);
    }

    private void notifyGameOver() {
        for (GameListener listener : listeners) {
            listener.onGameOver();
        }
    }

    private void notifyLifeChange(int quantity) {
        for (GameListener listener : listeners) {
            listener.onLifeChange(quantity);
        }
    }

    private void notifyScoreChange(int quantity){
        for (GameListener listener : listeners) {
            listener.onScoreChange(quantity);
        }
    }
}
