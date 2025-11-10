package org.example.project.models.others;

public class Credits {
    private int creditsAvailable;

    public Credits(int coinsAvailable) {
        this.creditsAvailable = coinsAvailable;
    }

    public int getCreditsAvailable() {
        return creditsAvailable;
    }

    public void setCreditsAvailable(int creditsAvailable) {
        this.creditsAvailable = creditsAvailable;
    }

    public boolean creditsAvailable(){
        return creditsAvailable > 0;
    }
}
