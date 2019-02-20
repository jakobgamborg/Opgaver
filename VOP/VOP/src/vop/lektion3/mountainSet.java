
package vop.lektion3;

import com.sun.javaws.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mountainSet {

    private Set<Mountain> mountainSet;

    public mountainSet () {
        this.mountainSet = new TreeSet<>();
    }

    public Set<Mountain> getMountainSet() {
        return mountainSet;
    }
    
    
    public static void main(String[] args) {
        
        mountainSet mountainSet = new mountainSet();
        
        File file = new File ("FranskeBjerge.csv");
        
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mountainSet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
       
        
    }
}
