package vop.lektion3;

import com.sun.javaws.Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException {

        mountainSet mountainSet = new mountainSet();
        try {
            String csvFile = "C:\\Users\\jakob\\Documents\\GitHub\\Opgaver\\VOP\\VOP\\src\\vop\\lektion3\\FranskeBjerge.csv";
            String line = "";
            String cvsSplitBy = ";";
            
            BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\jakob\\Documents\\GitHub\\Opgaver\\VOP\\VOP\\src\\vop\\lektion3\\FranskeBjerge.csv"));
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] mountain = line.split(cvsSplitBy);
                 Mountain m = null;
               for (int i  = 0; i<mountain.length; i++){ 
                   for(int j = 0; j < 5;j++)
                  m = new Mountain(mountain[j], mountain[j], mountain[j], mountain[j], mountain[j], mountain[j]);
               }
                mountainSet.getMountainSet().add(m);
                System.out.println(mountainSet.getMountainSet());
                    
              //  System.out.println(mountainSet.getMountainSet().size());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }

    }
}
