package org.example.project.interfaces;

public interface GameListener {
    void onGameOver();

    void onScoreChange(int score);

    void onLifeChange(int life);
}
