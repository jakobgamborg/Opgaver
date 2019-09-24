import java.util.Random;

public class CharProducer implements Runnable {

    private static final char[] CHARACTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'æ', 'ø', 'å'};

    private static Random generator = new Random();

    private CharBuffer buf;


    public CharProducer(CharBuffer buf) {
        this.buf = buf;
    }

    @Override
    public void run() {

        try {
            buf.put( CHARACTERS[generator.nextInt(28)]);
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
