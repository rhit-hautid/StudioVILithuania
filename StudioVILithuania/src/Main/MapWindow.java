package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The MapWindow class creates a window with a map of ten castles and ten cities
 * in Lithuania, where the user can select a city and view its distance to each
 * of the castles. The class contains a main method as well as instance
 * variables and constructors.
 * 
 * @author Isabel Haut
 */
public class MapWindow {

	// A HashMap containing the name and coordinates of each castle on the map.
	public static HashMap<String, ArrayList<Integer>> castleMap = new HashMap<String, ArrayList<Integer>>();
	// A HashMap containing the name and coordinates of each city on the map.
	public static HashMap<String, ArrayList<Integer>> cityMap = new HashMap<String, ArrayList<Integer>>();
	// An ArrayList containing the names of six locations on the map.
	public ArrayList<String> sixLocations = new ArrayList<String>();
	JFrame mapWindow;
	JPanel mapPanel;
	JLabel label;

	// The name of the castle selected by the user.
	String SaveCastleChosen = null;

	// An array of CircleButtons for each castle on the map.
	CircleButton[] circleButton = new CircleButton[10];

	// The x and y coordinates of each castle on the map.
	public static int[][] castleButtonCoordinates = { { 75, 220 }, // Klaipeda Castle button coordinates
			{ 270, 338 }, // Panemune Castle button coordinates
			{ 299, 338 }, // Raudone Castle button coordinates
			{ 385, 375 }, // Raundovaris Castle button coordinates
			{ 430, 435 }, // Kaunas Castle button coordinates
			{ 498, 103 }, // Birzai Castle button coordinates
			{ 485, 315 }, // Siesikai Castle button coordinates
			{ 604, 460 }, // Medininkai Castle button coordinates
			{ 615, 525 }, // Norviliskes Castle button coordinates
			{ 515, 455 }, // Trakai Castle button coordinates
	};

	// The x and y coordinates of each city on the map.
	public static int[][] cityButtonCoordinates = { { 105, 250 }, // Klaipedos button coordinates
			{ 185, 180 }, // Telsiai button coordinates
			{ 215, 315 }, // Taurages button coordinates
			{ 320, 180 }, // Saiauliai button coordinates
			{ 513, 180 }, // Panevezio button coordinates
			{ 410, 400 }, // Kauno button coordinates
			{ 610, 265 }, // Utenos button coordinates
			{ 548, 440 }, // Vilniaus button coordinates
			{ 423, 545 }, // Alytaus button coordinates
			{ 305, 475 }, // Marijampoles button coordinates
	};

	/**
	 * 
	 * Constructor for the MapWindow class. It takes a JLabel as a parameter to
	 * 
	 * update it with the city name when a city button is clicked.
	 * 
	 * @param updateableLabel JLabel to update with the city name.
	 */
	public MapWindow(JLabel updateableLabel) {
		this.label = updateableLabel;

		JFrame mapWindow = new JFrame("Map Window");
		JPanel mapPanel = new JPanel();
		mapPanel.setLayout(null);
		mapWindow.add(mapPanel);

		// Arrays to hold the names of the cities and castles.
		String[] cityNames = { "Klaipedos", "Telsiai", "Taurages", "Saiauliai", "Panevezio", "Kauno", "Utenos",
				"Vilniaus", "Alytaus", "Marijampoles" };

		// Arrays to hold the names of the castle and castles.
		String[] castleNames = { "Klaipeda", "Panemune", "Raudone", "Raudonvaris", "Kaunas", "Birzai", "Siesikai",
				"Medininkai", "Norviliskes", "Trakai" };

		// Calculate the distance between each castle and each city
		for (int i = 0; i < cityButtonCoordinates.length; i++) {
			for (int j = 0; j < castleButtonCoordinates.length; j++) {
				int x1 = cityButtonCoordinates[i][0];
				int y1 = cityButtonCoordinates[i][1];
				int x2 = castleButtonCoordinates[j][0];
				int y2 = castleButtonCoordinates[j][1];

				double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			}
		}

		// For adding castle button names and coordinates to my ArrayList
		for (int i = 0; i < 10; i++) {

			ArrayList<Integer> castle_Array = new ArrayList<Integer>();

			castle_Array.add(castleButtonCoordinates[i][0]);
			castle_Array.add(castleButtonCoordinates[i][1]);

			castleMap.put(castleNames[i], castle_Array);
		}

		// For adding city button names and coordinates to my ArrayList

		for (int i = 0; i < 10; i++) {

			ArrayList<Integer> city_Array = new ArrayList<Integer>();

			city_Array.add(cityButtonCoordinates[i][0]);
			city_Array.add(cityButtonCoordinates[i][1]);

			cityMap.put(cityNames[i], city_Array);
		}

		// adds 10 of my circle buttons to the window for cities
		for (int i = 0; i < 10; i++) {
			circleButton[i] = new CircleButton(null);
			circleButton[i].setBounds(cityButtonCoordinates[i][0], cityButtonCoordinates[i][1], 20, 20);
			mapPanel.add(circleButton[i]);
			circleButton[i].repaint();
			circleButton[i].setName(cityNames[i]);
			circleButton[i].addActionListener(new ActionListener() {

				/**
				 * 
				 * An ActionListener that listens for actions performed on a set of CityButtons,
				 * and updates the selected city accordingly. When a CityButton is clicked, the
				 * selected city is set to that city, and the label displaying the selected city
				 * is updated.
				 * 
				 * @param e an ActionEvent indicating that a CityButton has been clicked
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < cityNames.length; i++) {
						if (e.getSource().toString().contains(cityNames[i])) {
							setSaveCastleChosen(cityNames[i]);
							label.setText(" City: " + cityNames[i]);
						}
					}
				}
			});
		}

		// adds 10 of my circle buttons to the window for the castles
		for (int i = 0; i < 10; i++) {
			circleButton[i] = new CircleButton(null);
			circleButton[i].setBounds(castleButtonCoordinates[i][0], castleButtonCoordinates[i][1], 10, 10);
			mapPanel.add(circleButton[i]);
			circleButton[i].repaint();
			circleButton[i].setName(cityNames[i]);

		}

		// add image of map to the panel
		ImageIcon myMap = new ImageIcon("StudioVILithuania/HomePageImages/LithuanianMap.PNG");
		JLabel jlPic = new JLabel(myMap);
		Dimension size = jlPic.getPreferredSize();
		jlPic.setBounds(0, 0, size.width, size.height);
		mapPanel.add(jlPic);

		mapWindow.setSize(810, 700);

		// moves the mapWindow to appear on the right side of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mapWindow.setLocation(dim.width / 2 - mapWindow.getSize().width / 8,
				dim.height / 2 - mapWindow.getSize().height / 2);

		// makes the window a fixed size that the user cannot change
		mapWindow.setResizable(false);
		mapPanel.setBackground(Color.WHITE);
		mapWindow.setVisible(true);
		mapPanel.setVisible(true);

	}

	/**
	 * 
	 * Sets the name of the castle selected by the user.
	 * 
	 * @param saveCastleChosen The name of the castle selected by the user.
	 */
	public void setSaveCastleChosen(String saveCastleChosen) {
		SaveCastleChosen = saveCastleChosen;
	}

	/**
	 * 
	 * Returns the name of the castle selected by the user.
	 * 
	 * @return The name of the castle selected by the user.
	 */

	public String getSaveCastleChosen() {
		return SaveCastleChosen;
	}

	/**
	 * 
	 * Returns the label name which is the castle selected by the user.
	 * 
	 * @return The label which is the name of the castle selected by the user.
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * 
	 * Sets the name of the label to the city selected by the user.
	 * 
	 * @param setLabel The name of the city selected by the user.
	 */
	public void setLabel(JLabel label) {
		this.label = label;
	}

}
