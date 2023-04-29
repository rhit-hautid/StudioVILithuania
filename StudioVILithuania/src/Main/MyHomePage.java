package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 
 * The MyHomePage class is a GUI class for a Lithuanian Travel App, which allows
 * users to search for venues, castles, restaurants, museums, and hotels. This
 * class creates a JFrame and a JPanel for the home page. The home page contains
 * two drop-down menus for selecting venue type and number of people, a label
 * for displaying the selected city, and two buttons: "Search" and "Map". It
 * creates two drop-down menus for selecting venue type and number of people. It
 * creates a label for displaying the selected city, and a button for searching
 * for places. It also creates a button for viewing a map of selected locations.
 * Finally, it sets the properties of these components, such as their size,
 * location, and font, and adds them to the panel.
 * 
 * @author Isabel Haut
 **/
public class MyHomePage {

	// Variables
	JFrame frame;
	JPanel panel;
	JPanel panel2;
	public static final Dimension FIRST_SCREEN_SIZE = new Dimension(1500, 1000);
	JButton searchButton = new JButton("Search");
	JButton mapButton = new JButton("Map");
	private String cityClicked;
	public static JLabel updatableLabel = new JLabel();

	String[] TopPlaces = new String[6];

	public MyHomePage() {

		JFrame frame = new JFrame(); // creates a new frame
		JPanel panel = new JPanel(); // creates a new panel

		frame.setSize(FIRST_SCREEN_SIZE);
		panel.setPreferredSize(FIRST_SCREEN_SIZE);
		frame.setTitle("Lithuanian Travel App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Takes off automatic placement, lets you position where you specifically want
		// objects on screen
		panel.setLayout(null);

		// gives you positioning terms for the computer to reference
		Insets insets = panel.getInsets();

		// Code for DropDown Button One
		String[] choices = { "Venue", "Castles", "Restaurants", "Museums", "Hotels" };
		final JComboBox<String> dropDownButton = new JComboBox<String>(choices);
		dropDownButton.setPreferredSize(new Dimension(400, 70));
		dropDownButton.setFont(new Font("American Typewriter", Font.BOLD, 20));
		Dimension sizeTwo = dropDownButton.getPreferredSize();
		dropDownButton.setBounds(215 + insets.left, 275 + insets.bottom, sizeTwo.width, sizeTwo.height);
		dropDownButton.setVisible(true);
		panel.add(dropDownButton);

		// Code for DropDown Button Two
		String[] choicesTwo = { "Number of People", "1", "2", "3", "4", "5+" };
		final JComboBox<String> dropDownButtonTwo = new JComboBox<String>(choicesTwo);
		dropDownButtonTwo.setPreferredSize(new Dimension(400, 70));
		dropDownButtonTwo.setFont(new Font("American Typewriter", Font.BOLD, 20));
		Dimension sizeThree = dropDownButtonTwo.getPreferredSize();
		dropDownButtonTwo.setBounds(215 + insets.left, 375 + insets.bottom, sizeThree.width, sizeThree.height);
		dropDownButtonTwo.setVisible(true);
		panel.add(dropDownButtonTwo);

		// Color blue
		Color myDarkBlue = new Color(122, 138, 153);

		// Creates the bounding box for my label
		Border border = BorderFactory.createLineBorder(myDarkBlue, 1);
		updatableLabel.setBorder(border);

		// code for the updatableLabel
		updatableLabel.setPreferredSize(new Dimension(200, 70));
		Dimension sizeFour = updatableLabel.getPreferredSize();
		updatableLabel.setText(" None Selected");
		updatableLabel.setBounds(215 + insets.left, 475 + insets.bottom, sizeFour.width, sizeFour.height);
		updatableLabel.setFont(new Font("American Typewriter", Font.BOLD, 20));
		updatableLabel.setVisible(true);
		panel.add(updatableLabel);
		updatableLabel.setVisible(true);

		// code for search button
		searchButton.addActionListener(new ButtonListener(searchButton, frame));
		searchButton.setPreferredSize(new Dimension(400, 70));
		searchButton.setName("Search");
		frame.add(panel, BorderLayout.NORTH);
		searchButton.setFont(new Font("American Typewriter", Font.BOLD, 20));
		Dimension sizeFive = searchButton.getPreferredSize();
		searchButton.setBounds(215 + insets.left, 575 + insets.bottom, sizeFive.width, sizeFive.height);
		panel.add(searchButton);

		// code for map button
		mapButton.addActionListener(new ButtonListener(mapButton, frame));
		mapButton.setPreferredSize(new Dimension(190, 70)); //
		mapButton.setName("Map");
		mapButton.setFont(new Font("American Typewriter", Font.BOLD, 20));
		Dimension sizeNine = mapButton.getPreferredSize();
		mapButton.setBounds(425 + insets.left, 475 + insets.bottom, sizeNine.width, sizeNine.height);
		panel.add(mapButton);

		// code for my heading
		JLabel label = new JLabel("Find A Place To Visit");
		label.setPreferredSize(new Dimension(400, 70));
		Dimension sizeSeven = label.getPreferredSize();
		panel.add(label);
		label.setFont(new Font("American Typewriter", Font.BOLD, 20));
		label.setBounds(305 + insets.left, 125 + insets.bottom, sizeSeven.width, sizeSeven.height);

		// code for my short description
		JLabel labelTwo = new JLabel("Come here to explore the beautiful castles of Lithuania");
		labelTwo.setPreferredSize(new Dimension(600, 100));
		Dimension sizeEight = labelTwo.getPreferredSize();
		panel.add(labelTwo);
		labelTwo.setFont(new Font("American Typewriter", Font.BOLD, 15));
		labelTwo.setBounds(210 + insets.left, 160 + insets.bottom, sizeEight.width, sizeEight.height);

		// code to put white square image on the window
		ImageIcon mySquare = new ImageIcon("StudioVILithuania/HomePageImages/MySquare.PNG");
		JLabel jlPic = new JLabel(mySquare);
		Dimension size = jlPic.getPreferredSize();
		jlPic.setBounds(155 + insets.left, 125 + insets.bottom, size.width, size.height);
		panel.add(jlPic);

		// code to put castle image on the window
		ImageIcon CastleHome = new ImageIcon("StudioVILithuania/HomePageImages/CastleHomePage.PNG");
		JLabel jlPic2 = new JLabel(CastleHome);
		Dimension sizeSix = jlPic2.getPreferredSize();
		jlPic2.setBounds(280 + insets.left, -33 + insets.bottom, sizeSix.width, 200 + sizeSix.height);
		panel.add(jlPic2);

		// Color blue
		Color myBlue = new Color(245, 224, 143);

		// sets panel to my custom color
		panel.setBackground(myBlue);
		// makes frame visible

		frame.setVisible(true);

	}
}
