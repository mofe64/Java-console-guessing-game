package Nubari;

import Nubari.Config.MinNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {
    // == FIELDS == //
    private  final Random random = new Random();
    private final int maxNumber;
    private final int minNumber;

    //== constructor ==//
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber){
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //== PUBLIC METHODS ==//
    @Override
    public int next() {
        return random.nextInt(maxNumber-minNumber) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
