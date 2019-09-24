package opg3_gui_io;

import java.io.*;

public class ObjFile implements FileIOInterface, Serializable {
    private static File file = new File("Opg4File.obj");
    private String txt;

    @Override
    public void writeToFile(String text) {
        this.txt = text;
        ObjectOutput oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String readFromFile() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ObjFile obj = (ObjFile) ois.readObject();
            return obj.getTxt();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "Error in ObjFile";
    }

    public String getTxt() {
        return this.txt;
    }
}
