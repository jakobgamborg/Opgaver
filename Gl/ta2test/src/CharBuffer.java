public class CharBuffer {


    private Character[] buf;

    private int putIndex;
    private int getIndex;

    private CallbackInterface caller;

    public CharBuffer(int bufferSize, CallbackInterface caller) {
        this.buf = new Character[bufferSize];
        this.caller = caller;
        putIndex = 0;
        getIndex = 0;
    }


    public void put(Character ch) {
        buf[putIndex] = ch;
        putIndex++;
        if (putIndex == 29)
            putIndex = 0;
    }

    public char get() {
        getIndex++;
        if (getIndex == 29)
            getIndex = 0;
        return buf[getIndex];
    }

    public synchronized void consumerUpdate(String oldName, String newName) {
        caller.updateConsumer(oldName, newName);
    }


    public static void main(String[] arg) {

        CallbackInterface caller = new CallbackInterface() {
            @Override // Implementation til test uden brugerflade:
            public void updateBuffer(int index, Character value) {
                System.out.println(index + " er opdateret med '" + value + "'");
            }

            @Override
            public void updateConsumer(String old, String name) {
                System.out.println("Consumer " + old + " -> " + name);
            }
        };

        CharBuffer rb = new CharBuffer(5, caller);

        CharProducer p1 = new CharProducer(rb);
        CharProducer p2 = new CharProducer(rb);

        CharConsumer c1 = new CharConsumer(rb, "erik");
        CharConsumer c2 = new CharConsumer(rb, "oswald");
        CharConsumer c3 = new CharConsumer(rb, "charlottemargrethe");

        Thread tp1 = new Thread(p1);
        tp1.setDaemon(true);

        Thread tp2 = new Thread(p2);
        tp2.setDaemon(true);

        new Thread(c1).start();
        tp1.start();
        new Thread(c2).start();
        tp2.start();
        new Thread(c3).start();
    }
}
