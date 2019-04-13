package sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
      /*  ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new PrintChar('a', 50));
        executor.execute(new PrintChar('b', 50));
        executor.shutdown();
    */
        PrintChar a = new PrintChar('a', 50);
        PrintChar b = new PrintChar('b', 50);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();

    }


    private static class PrintChar implements Runnable {
        private char a;
        private int repititions;
        private Lock printCharLock;
        private Condition condition;

        public PrintChar(char a, int repititions) {
            this.a = a;
            this.repititions = repititions;
            printCharLock = new ReentrantLock();
            condition = printCharLock.newCondition();
        }

        @Override
        public synchronized void run() {
            printCharLock.lock();
            try {
                for (int i = 0; i < repititions; i++) {
                    System.out.println(a);
                    Thread.sleep(50);
                    condition.signalAll();;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                printCharLock.unlock();
            }
        }
    }
}
