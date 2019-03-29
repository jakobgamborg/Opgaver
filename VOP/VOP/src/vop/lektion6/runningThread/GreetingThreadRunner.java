package vop.lektion6.runningThread;

import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GreetingThreadRunner {
    public static void main(String[] args) throws InterruptedException {
        GreetingRunnable r1 = new GreetingRunnable("Hello");
        GreetingRunnable r2 = new GreetingRunnable("Goodbye");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //   pool.execute(r1);
        //    pool.execute(r2);
        // r1.run();
        //   r2.run();
        Thread.sleep(1);
        t1.start();
        t1.interrupt();
        //t2.start();
    }

}
