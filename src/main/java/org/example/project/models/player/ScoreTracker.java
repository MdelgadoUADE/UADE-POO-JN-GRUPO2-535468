package org.example.project.models.player;

public class ScoreTracker {
    private int score;
    private int livesIncremented;

    public ScoreTracker() {
        this.score = 0;
        this.livesIncremented = 1;
    }

    public int getScore() {
        return score;
    }

    public boolean setScore(int score) {
        // set score devuelve true si el cambio de score generaria un aumento de vida, false si no.
        this.score = score;
        if ((score / livesIncremented) / 500 >= 1) {
            livesIncremented++;
            return true;
        }
        return false;

    }
}
