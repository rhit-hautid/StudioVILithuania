package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * The SelectionScreen class displays a selection screen to the user. The screen
 * contains buttons with the names of six global locations and their
 * corresponding labels. The buttons and labels are created dynamically based on
 * the user's selection of a city in a previous screen.
 * 
 * @author Isabel Haut
 */
public class SelectionScreen {

	private JFrame myFrame;
	private String myClickedCityString;
	private JButton myHomeButton;

	private JPanel myLocationPanel;
	private int MYHEIGHT = 50;
	private int MYWIDTH = 200;

	// Stores the names of the six global locations
	protected ArrayList<String> mySixLocations = new ArrayList<String>();
	// Stores the six JButtons dynamically created for the six global locations
	private JButton[] mySixButtons = new JButton[6];
	// Stores the six JLabels dynamically created for the six global locations
	private JLabel[] mySixLabels = new JLabel[6];
	public static String pickedLanguage = Main.pickedLanguage;

	/**
	 * Constructs a SelectionScreen object with a JFrame and a JLabel representing
	 * the user's selected city in a previous screen. The method calls the
	 * SixClosestLocations class to get the names of the six global locations
	 * closest to the user's selected city, and then dynamically creates JButtons
	 * and JLabels for each location.
	 * 
	 * @param myFrame            The JFrame object on which the SelectionScreen is
	 *                           displayed.
	 * @param myClickedCityLabel The JLabel object representing the user's selected
	 *                           city in a previous screen.
	 * 
	 */
	public SelectionScreen(JFrame myFrame, JLabel myClickedCityLabel) {

		this.myFrame = myFrame;
		// The name of the clicked city.
		this.myClickedCityString = myClickedCityLabel.getText().substring(7);

		// Color yellow
		Color myYellow = new Color(245, 185, 19);
		Color myGreen = new Color(0, 106, 68);
		Color myRed = new Color(193, 39, 45);

		JPanel myHomePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(myYellow);
				g.fillRect(0, 0, myFrame.getWidth(), 25); // left half
				g.setColor(myGreen);
				g.fillRect(0, 25, myFrame.getWidth(), 50); // right half
				g.setColor(myRed);
				g.fillRect(0, 50, myFrame.getWidth(), 75); // right half
			}
		};

		// gives you positioning terms for the computer to reference
		Insets insets = myHomePanel.getInsets();

		myHomePanel.setPreferredSize(new Dimension(1500, 75));
		myFrame.add(myHomePanel, BorderLayout.NORTH);

		// The button to return to the home screen.
		// changes the language of my home button
		// depending on if Lithuanian or English Language was chosen
		if (pickedLanguage.equals("Lithuanian")) {
			myHomeButton = new JButton("Namai");
		} else {
			myHomeButton = new JButton("Home");
		}
		myHomeButton.setName("Home");
		myHomeButton.addActionListener(new ButtonListener(myHomeButton, myFrame));
		myHomePanel.add(myHomeButton);

		// Lets you position the button where specifically to a location you choose
		myHomePanel.setLayout(null);

		myHomeButton.setFont(new Font("American Typewriter", Font.BOLD, 20));
		myHomeButton.setBounds(650 + insets.left, 10 + insets.top, MYWIDTH, MYHEIGHT);
		myHomeButton.setVisible(true);
		myHomeButton.addActionListener(new ButtonListener(myHomeButton, myFrame));

		// The panel containing the location panel
		myLocationPanel = new JPanel(new GridLayout(2, 3)); // Create a 3 by 3 GridLayout
		// Set gaps between cells in the GridLayout
		myLocationPanel.setLayout(new GridLayout(2, 3, 60, 15)); // Set horizontal and vertical gap to 50 pixels
		// Set border around the GridLayout
		myLocationPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 35, 50)); // Set top, left, bottom, right
																					// border to 50 pixels

		myLocationPanel.setPreferredSize(new Dimension(1500, 950));

		myLocationPanel.setBackground(myYellow);

		myFrame.add(myLocationPanel);
		myLocationPanel.setBackground(Color.WHITE);
		myFrame.add(myHomePanel, BorderLayout.NORTH);
		myHomePanel.setBackground(myYellow);

		// Get the names of the six global locations closest to the user's selected city
		SixClosestLocations getLocations = new SixClosestLocations(myClickedCityLabel);
		mySixLocations = getLocations.getGlobalSixLocations();

		specificSelectionScreen(myLocationPanel, myClickedCityString, mySixLocations, mySixButtons, mySixLabels);

		myFrame.revalidate();
		myFrame.repaint();

	}

	/**
	 * Overrides the specificSelectionScreen method in the AbstractSelectionScreen
	 * class. This method sets up the layout of the selection screen by adding the
	 * dynamically created JButtons and JLabels to a JPanel with a GridLayout.
	 * 
	 * @param myLocationPanel     The JPanel object on which the JButtons and
	 *                            JLabels are displayed.
	 * @param myClickedCityString The name of the user's selected city in a previous
	 *                            screen. sdsd
	 */
	protected void specificSelectionScreen(JPanel myLocationPanel, String myClickedCityString,
			ArrayList<String> mySixLocations, JButton[] mySixButtons, JLabel[] mySixLabels) {

		// Creates JButtons and JLabels for each location
		for (int i = 0; i < mySixButtons.length; i++) {

			mySixButtons[i] = new JButton();

			mySixButtons[i].setName(mySixLocations.get(i));
			mySixButtons[i].addActionListener(new ButtonListener(mySixButtons[i], myFrame));
			mySixLabels[i] = new JLabel(mySixLocations.get(i));
			mySixLabels[i].setFont(new Font("American Typewriter", Font.BOLD, 20));
			mySixLabels[i].setBackground(Color.WHITE);
			mySixLabels[i].setOpaque(true); // Make label opaque so background color is visible
			mySixLabels[i].setPreferredSize(new Dimension(350, 65));
			System.out.println(mySixButtons[i].getName());

			String mySixImagePath = "StudioVILithuania/CastleImages/" + mySixLocations.get(i) + "Castle.PNG";
			ImageIcon mySixImages = new ImageIcon(mySixImagePath);
			mySixButtons[i].setIcon(mySixImages);

			JPanel locationPanel = new JPanel(new BorderLayout());
			locationPanel.add(mySixButtons[i], BorderLayout.CENTER);
			locationPanel.add(mySixLabels[i], BorderLayout.SOUTH);

			locationPanel.setPreferredSize(new Dimension(350, 365));
			locationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			locationPanel.setBackground(Color.WHITE);

			myLocationPanel.add(locationPanel);

		}
	}

}
