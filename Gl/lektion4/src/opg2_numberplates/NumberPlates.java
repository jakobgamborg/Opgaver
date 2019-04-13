package opg2_numberplates;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * VOP eksamen F2014 
 * Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates {

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade
    
    private Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds
    
    private VehicleType[] vehicleTypes = {      // Intervaller for anvendelse
        new VehicleType("Motorcykel", 10000, 19999),
        new VehicleType("Privat personvogn", 20000, 45999),
        new VehicleType("Udlejningsvogn", 46000, 46999),
        new VehicleType("Hyrevogn", 47000, 48999),
        new VehicleType("Skolevogn", 49000, 49899),
        new VehicleType("Ambulance el. lign.", 49900, 49999),
        new VehicleType("Diverse andre ", 50000, 84999)
    };

    public NumberPlates() throws FileNotFoundException {
        districtMap = new HashMap<>();
        readFile();
    }

    public void readFile() throws FileNotFoundException {
        Scanner scanner = null;
            FileReader fileReader = new FileReader("Nummerplader.txt");
            scanner = new Scanner(fileReader);
            String[] keyVal;
            while (scanner.hasNextLine()) {
                keyVal = scanner.nextLine().split(":");
                districtMap.put(keyVal[0], keyVal[1]);
            }

    }


    public String validate(String plate) {
        if(plate.length() != LENGTH)
            return "Længden på nummerpladen er forkert";
        String district = validateDistrict(plate.substring(0,2).toUpperCase());
        Integer number = Integer.parseInt(plate.substring(2));
        return plate + " " + validateVehicleType(number) + " fra " + district;
    }

    private String validateDistrict(String districtCode) {
        if (!districtMap.containsKey(districtCode))
            return " Kreds findes ikke";
        return districtMap.get(districtCode);
    }

    private String validateVehicleType(int number) {
        for(VehicleType vehicleType: vehicleTypes){
            if(vehicleType.isA(number))
              return vehicleType.getVehicleType();
        }
        return " Illegalt nummmer " + number;
    }

    public static void main(String[] arg) throws FileNotFoundException {
        // Opg 2) Kan benyttes til test af opgave 2a og 2b
        NumberPlates pd = new NumberPlates();

        System.out.println("KC39078: " + pd.validate("KC39078"));
        System.out.println("kc49900: " + pd.validate("kc49900"));
        System.out.println("KO47078: " + pd.validate("KO47078"));
        System.out.println("EN19022: " + pd.validate("EN19022"));
        System.out.println("EN190220: " + pd.validate("EN190220"));
    }

}
