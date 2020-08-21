package Nubari.Config;

import Nubari.GuessCount;
import Nubari.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    //== fields ==//
    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.guessCount}")
    private int guessCount;

    @Value("${game.minNumber: 5}")
    @MinNumber
    private int minNumber;

    //== bean methods ==//
    @Bean
    @MaxNumber
    public int getMaxNumber(){
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int getGuessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int getMinNumber(){
        return minNumber;
    }
}
