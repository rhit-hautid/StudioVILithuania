package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

/**
 * 
 * This class represents an object that calculates the six closest locations to
 * a given city, based on a pre-defined list of cities and castles.
 * 
 * The class contains methods to get and set the list of six closest locations.
 * 
 * @author Isabel Haut
 */
public class SixClosestLocations {

	// Variables
	private JLabel myClickedLabel;
	private HashMap<String, ArrayList<Integer>> myCastleMap = MapWindow.castleMap;
	private HashMap<String, ArrayList<Integer>> myCityMap = MapWindow.cityMap;
	private HashMap<String, Integer> mySortedMap = new HashMap<String, Integer>();
	private ArrayList<Integer> myUnsortedDistances = new ArrayList<Integer>();
	private List<String> castleNames1;
	private ArrayList<String> sixLocations = new ArrayList<String>();
	private ArrayList<String> globalSix = new ArrayList<String>();
	private int[][] myCastleCoordinates = MapWindow.castleButtonCoordinates;
	private int[][] myCityCoordinates = MapWindow.cityButtonCoordinates;
	private String cityName;
	private int myLabelX;
	private int myLabelY;

	/**
	 * Constructor for SixClosestLocations class.
	 * 
	 * @param myUpdatableLabel A JLabel representing the selected city on the map.
	 */
	SixClosestLocations(JLabel myUpdatableLabel) {
		this.myClickedLabel = myUpdatableLabel;
		this.cityName = myUpdatableLabel.getText().substring(7);

		String[] cityNames = { "Klaipedos", "Telsiai", "Taurages", "Saiauliai", "Panevezio", "Kauno", "Utenos",
				"Vilniaus", "Alytaus", "Marijampoles" };

		String[] castleNames = { "Klaipeda", "Panemune", "Raudone", "Raudonvaris", "Kaunas", "Birzai", "Siesikai",
				"Medininkai", "Norviliskes", "Trakai" };

		ArrayList<Integer> myCityXAndY = myCityMap.get(cityName);
		myLabelX = myCityXAndY.get(0);
		myLabelY = myCityXAndY.get(1);

		System.out.println(this.cityName);

		// Calculate and print the distance between each castle and each city
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < myCastleCoordinates.length; j++) {

				int x1 = myLabelX;
				int y1 = myLabelY;
				int x2 = myCastleCoordinates[j][0];
				int y2 = myCastleCoordinates[j][1];

				double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
				myUnsortedDistances.add(i, (int) distance);
				mySortedMap.put(castleNames[j], (int) distance);
				System.out.println(myUnsortedDistances);
				System.out.println("Distance between " + (cityNames[i]) + " and " + (castleNames[j]) + " is " + distance
						+ " pixels");
			}
		}

		// Sort the distances and associated strings in ascending order based on the
		// distances
		// Create a list to hold the castle names
		castleNames1 = Arrays.asList("Klaipeda", "Panemune", "Raudone", "Raudonvaris", "Kaunas", "Birzai", "Siesikai",
				"Medininkai", "Norviliskes", "Trakai");

		// Sort the castle names based on their distances from the selected city
		Collections.sort(castleNames1, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// Get the distances between the city and the two castles
				int distance1 = mySortedMap.get(s1);
				int distance2 = mySortedMap.get(s2);

				// Compare the distances and return the result
				return Integer.compare(distance1, distance2);
			}
		});

		// Get the six closest locations
		List<String> sixLocations = castleNames1.subList(0, 6);

		for (int i = 0; i < 6; i++) {
			globalSix.add(i, sixLocations.get(i));
		}
		System.out.println("This is Six" + sixLocations);
		System.out.println("This is Global" + globalSix);

	}

	/**
	 * 
	 * Returns the list of six closest locations to a given city.
	 * 
	 * @return An ArrayList containing the names of the six closest locations to a
	 *         given city.
	 */
	public ArrayList<String> getGlobalSixLocations() {
		System.out.println("This is Get" + globalSix);
		return globalSix;
	}

	/**
	 * 
	 * This class represents an object that calculates the six closest locations to
	 * a given city, based on a pre-defined list of cities and castles.
	 * 
	 * The class contains methods to get and set the list of six closest locations.
	 */
	public void setSixLocations(ArrayList<String> globalSixLocations) {
		this.globalSix = globalSixLocations;
	}
}
