package vop.lektion3;

import com.sun.javaws.Main;
import org.omg.CORBA_2_3.portable.InputStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mountainSet {

    private Set<Mountain> mountainSet;

    public mountainSet() {
        this.mountainSet = new TreeSet<>();
    }

    public Set<Mountain> getMountainSet() {
        return mountainSet;
    }

    public Set<Mountain> sortByRange (Comparator comp) {
        Set<Mountain> setByRange = new TreeSet<>();
     //   setByRange = new MountainRangeComperator();
        return setByRange;
    }

    public static void main(String[] args) throws IOException {

        mountainSet mountainSet = new mountainSet();
        try {
            String csvFile = "C:\\Users\\Gamborg\\Documents\\GitHub\\Opgaver\\VOP\\VOP\\src\\vop\\lektion3\\Franskebjerge.csv";
            String line = "";
            String cvsSplitBy = ";";
            BufferedReader file = new BufferedReader(new FileReader(csvFile));
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] mountain = line.split(cvsSplitBy);
                 Mountain m = null;
               for (int i  = 0; i<mountain.length; i++){
                  m = new Mountain(mountain[0], mountain[1], mountain[2], mountain[3], mountain[4], mountain[5]);
               }
                mountainSet.getMountainSet().add(m);

            }
            System.out.println(mountainSet.getMountainSet());



        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }

    }
}
