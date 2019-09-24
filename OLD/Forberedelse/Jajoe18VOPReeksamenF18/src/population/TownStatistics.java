/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Udleveret kodeskelet til VOP F18 re-eksamen opg 2b
 * @author erso
 */
public class TownStatistics {

    private List<DanishTown> townList;

    public TownStatistics () {
        this.townList = new ArrayList<>();
    }


    @Override
    public String toString() {
        String s = townList.toString();
        return "TownStatistics:\n" + s.substring(1, s.length()-1) + "\n";
    }

    public void sort() {
       Collections.sort(townList);
    }

    public void readFile(String fileName) {
        townList.clear();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
            String[] city;
            while(scanner.hasNextLine()) {
                city = scanner.nextLine().split("/");
                int pop12 = Integer.parseInt(city[2]);
                int pop18 = Integer.parseInt(city[3]);
                townList.add(new DanishTown(city[1],pop12,pop18));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TownStatistics ts = new TownStatistics();
        ts.readFile("Danske Byer.txt");
        System.out.println("Unsorted " + ts);
        ts.sort();
        System.out.println("Sorted " + ts);

    }

}
