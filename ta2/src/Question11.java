public class Question11 {

    public static int recursiveMethod (int x, int n) {
        int returning;
        if(n <0 ) {
            System.out.println("n must be >0, returning -1 ");
            return -1;
        }
        returning = x^n;
        return returning;
    }﻿﻿﻿

    public static void main(String[] args) {

        System.out.println(recursiveMethod(2,2));
    }

}﻿﻿﻿