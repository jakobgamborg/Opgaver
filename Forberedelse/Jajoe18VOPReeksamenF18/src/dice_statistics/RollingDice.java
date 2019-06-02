package dice_statistics;

import java.util.Arrays;

public class RollingDice {

    public static void main (String[] args) {
    Die d1 = new Die();
    Die d2 = new Die();
    int rolls = 1000;
    int[] sums = new int[11];
    int a,b,sum;
    for(int i = 0; i< rolls; i++) {
        a = d1.roll();
        b = d2.roll();
        sum = a + b;
        sums[sum-2]++;
       // System.out.println("d1: " + a + " d2: " + b + " sum: " + sum);
    }
        System.out.println(Arrays.toString(sums));
    }
}
