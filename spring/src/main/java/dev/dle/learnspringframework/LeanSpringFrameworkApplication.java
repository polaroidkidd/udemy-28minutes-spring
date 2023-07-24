package dev.dle.learnspringframework;


import dev.dle.learnspringframework.enterprise.web.MyWebController;
import dev.dle.learnspringframework.game.GameRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LeanSpringFrameworkApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LeanSpringFrameworkApplication.class, args);


//		MarioGameingConsole game = new MarioGameingConsole();
//		SuperContraGameingConsole game = new SuperContraGameingConsole();
//		GameRunner runner = new GameRunner(game);

        GameRunner runner = context.getBean(GameRunner.class);
        runner.run();

         MyWebController controller = context.getBean(MyWebController.class);
        System.out.println(controller.returnValueFromBusinessService());
    }

}
