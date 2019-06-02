
public class CharConsumer implements Runnable {

    private String name;
    private CharBuffer buf;

    public CharConsumer(CharBuffer buf, String name) {
        this.buf = buf;
        this.name = name.toLowerCase();
        changeCharInString();
    }

    public String changeCharInString () {
        String oldName = name;
        while(!name.equals(name.toUpperCase())) {
            name = name.replace(buf.get(),Character.toUpperCase(buf.get()));
        }
        buf.consumerUpdate(oldName, name);
        return name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 28; i++) {
                buf.get();
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
