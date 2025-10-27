package org.example.project.controler;

import org.example.project.models.player.ScoreTracker;
import org.example.project.views.views.PlayerView;

public class PlayerController {

    private static PlayerController instance;
    private ScoreTracker scoreTracker;
    private PlayerView view;

    private PlayerController() {
        scoreTracker = new ScoreTracker();
        view = new PlayerView(scoreTracker.getScore());
    }

    public static PlayerController getInstance() {
        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }

    public void addScore(int score){
        scoreTracker.setScore(scoreTracker.getScore() + score);
        view.setScore(scoreTracker.getScore());
        System.out.println("Score: " + scoreTracker.getScore());
    }

    public PlayerView getView() {
        return view;
    }


}
