package Nubari;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{

    //== constants ==//
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    //== fields ==//
    @Autowired
    private Game game;

    //== init ==//
    @PostConstruct
    public void init(){
        log.info("game is {}", game);
    }

    // == public methods ==//
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + " can you guess it ?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
        return "You guessed it! the number was " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You lost :( , the number was " + game.getNumber();
        } else if(!game.isValidNumberRange()) {
            return "Invalid Number Range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess";
        } else  {
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return  direction + " ! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
