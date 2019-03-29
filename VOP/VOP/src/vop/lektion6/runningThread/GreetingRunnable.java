package vop.lektion6.runningThread;

import java.util.Date;

public class GreetingRunnable implements Runnable {
    private String greeting;
    private static int REPETITIONS = 10;
    private static int DELAY = 1000;

    public GreetingRunnable(String aGreeting) {
        greeting = aGreeting;
    }

    public void run() {
        try {
            for (int i = 1; i <= REPETITIONS && !Thread.interrupted(); i++){
                Date now = new Date();
                System.out.println(now + " " + greeting);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException exception) {
            System.out.println("The thread is interrupted");
        }
    }



}
