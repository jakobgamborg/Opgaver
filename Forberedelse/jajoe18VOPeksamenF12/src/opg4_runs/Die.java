package opg4_runs;

import java.util.Random;

public class Die {
    private Random generator;
    private int max;

    public Die(int max) {
        this.max = max;
        this.generator = new Random();
    }

    public int throwDie() {
        return generator.nextInt(max)+1;
    }
}
