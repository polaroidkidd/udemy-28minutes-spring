package dev.dle.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    @Autowired
    private GameingConsole gameingConsole;

    public GameRunner(GameingConsole gameingConsole) {

        this.gameingConsole = gameingConsole;
    }

    public void run() {
        this.gameingConsole.up();
        this.gameingConsole.down();
        this.gameingConsole.left();
        this.gameingConsole.right();
    }
}
