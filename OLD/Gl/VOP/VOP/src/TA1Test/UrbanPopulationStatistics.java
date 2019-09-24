package TA1Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Udleveret kodeskelet til VOP re-eksamen 20. august 2014
 *
 * @author erso
 */
public class UrbanPopulationStatistics {

    private Set<UrbanPopulation> popSet;
    private File file;

    public UrbanPopulationStatistics(String fileName) {
        popSet = new TreeSet<UrbanPopulation>();
        file = new File(fileName);
        readFile();
    }

    private void readFile() {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner (fileReader);
            String line = " ";
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] countryPop = line.split("/");
                UrbanPopulation uP = null;
                for (int i = 0; i < countryPop.length; i++) {
                    int year1980 = Integer.parseInt(countryPop[1]);
                    int year2008 = Integer.parseInt(countryPop[4]);
                    uP = new UrbanPopulation(countryPop[0],year1980, year2008);
                }
                popSet.add(uP);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    
// Udleveret toString() metode, som giver en "pæn" formatering.
    @Override
    public String toString() {
        String s = popSet.toString().replaceAll(", ", "");
        return "UrbanPopulationStatistics:\n" + s.substring(1, s.length() - 1) + "\n";
    }

   
    //Udleveret test-metode
    public static void main(String[] args) {
        UrbanPopulationStatistics stats = new UrbanPopulationStatistics("C://Users//Gamborg//Documents//GitHub//Opgaver//VOP//VOP//src//ByBefolkning.txt");
        System.out.println(stats);
    }

}
