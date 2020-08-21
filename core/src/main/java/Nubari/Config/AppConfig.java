package Nubari.Config;

import Nubari.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "Nubari")
public class AppConfig {
    //== Bean Methods ==//

    @Bean
    public Game game() {
        return new GameImpl();
    }
    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }
}
