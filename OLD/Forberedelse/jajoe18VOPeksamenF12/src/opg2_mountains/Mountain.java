package opg2_mountains;

import java.util.Arrays;

public class Mountain implements Comparable<Mountain> {

	private String name;
	private int height;
	private int prominence;
	private String latitude;
	private String longitude;
	private String range;

	public Mountain(String name, String height, String prominence, String latitude, String longitude, String range) {
		this.name = name;
		this.height = new Integer(height);
		this.prominence = new Integer(prominence);
		this.latitude = latitude;
		this.longitude = longitude;
		this.range = range;
	}

	@Override
	public String toString() {
		return "\n" + name + " h=" + height + ", pro=" + prominence + ", lat=" + latitude + ", lon=" + longitude + ", ran=" + range;
	}



	@Override
	public int compareTo(Mountain o) {
		int i = this.prominence - o.prominence;
		if (i == 0){
			i = this.height - o.height;
		}
		return i;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Opg a:
		Mountain m = new Mountain("Mont Ventoux","1909","1148","44�10'26\"","05�16'42\"","Alps");

		System.out.println(m);
		
		// Opg b:
		Mountain[] testArray = new Mountain[3];
    	testArray[0] = new Mountain("Pica d'Estats","3143","1281","42�42'43\"","00�57'23\"","Pyrenees");
		testArray[1] = new Mountain("Mont Chaberton", "3131", "1281", "44�57'53\"","06�45'06\"", "Alps" );
		testArray[2] = new Mountain("Pic de Bure","2709", "1268", "44�37'38\"", "05�56'07\"", "Alps" );

		System.out.println("Usorteret: ");
		System.out.println(Arrays.toString(testArray));

		System.out.println("Sorteret: ");
		Arrays.sort(testArray);
		System.out.println(Arrays.toString(testArray));
	}

}
