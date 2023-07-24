package dev.dle.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperContraGame implements GameingConsole {

    public void up() {
        System.out.println("SuperContra up");
    }

    public void down() {
        System.out.println("SuperContra down");
    }

    public void left() {
        System.out.println("SuperContra left");
    }

    public void right() {
        System.out.println("SuperContra right");
    }
}
