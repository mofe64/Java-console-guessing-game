package Nubari.console;

import Nubari.Game;
import Nubari.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess   {
    //== Constants ==//
    private final static Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //== Fields ==//
    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    //== Event Listener ==//
    @EventListener(ContextRefreshedEvent.class)
    public void start () {
        log.info("Container ready for use");

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play Again y/n ?");

                String playAgainString = scanner.next().trim();
                if(!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
