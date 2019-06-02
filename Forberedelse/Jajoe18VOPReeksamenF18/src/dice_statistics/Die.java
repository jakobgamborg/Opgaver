package dice_statistics;

import java.util.Random;

public class Die {
    private Random generator;
    public Die (){
        generator = new Random();
    }
    public int roll(){
        return generator.nextInt(6)+1;
    }
}
