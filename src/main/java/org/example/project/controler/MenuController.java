package org.example.project.controler;

import org.example.project.models.others.Credits;
import org.example.project.views.windows.StartWindow;

public class MenuController {
    private static MenuController instance;
    private Credits credits;

    public static MenuController getInstance() {
        if (instance == null) instance = new MenuController();
        return instance;
    }

    private MenuController(){
        credits = new Credits(0);
    }

    public void startMainMenu() {
        new StartWindow();
    }

    public int availableCoins(){
        return credits.getCreditsAvailable();
    }

    public void addCoins(int quantity) {
        credits.setCreditsAvailable(credits.getCreditsAvailable() + quantity);
    }
}
