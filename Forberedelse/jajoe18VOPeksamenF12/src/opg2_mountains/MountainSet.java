package opg2_mountains;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MountainSet {
    private Set<Mountain> mountains;

    public MountainSet () {
        this.mountains = new TreeSet<>();
    }

    public void addMountain(Mountain m) {
        this.mountains.add(m);
    }
     @Override
    public String toString(){
        return mountains.toString();
    }

    public static void main(String[] args){
        MountainSet mountainSet = new MountainSet();
        Scanner scanner = null;


        try {
            scanner = new Scanner(new File("FranskeBjerge.csv"));
            String[] mountainFromFile;
            String line;
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                mountainFromFile = line.split(";");
                mountainSet.addMountain(new Mountain(mountainFromFile[0],mountainFromFile[1],mountainFromFile[2],mountainFromFile[3],mountainFromFile[4],mountainFromFile[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }

        System.out.println(mountainSet);
    }
}
