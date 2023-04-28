package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

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
public class SelectionScreen extends AbstractSelectionScreen {

	// Stores the names of the six global locations
	protected ArrayList<String> mySixLocations = new ArrayList<String>();
	// Stores the six JButtons dynamically created for the six global locations
	private JButton[] mySixButtons = new JButton[6];
	// Stores the six JLabels dynamically created for the six global locations
	private JLabel[] mySixLabels = new JLabel[6];

	/**
	 * Constructs a SelectionScreen object with a JFrame and a JLabel representing
	 * the user's selected city in a previous screen. The method calls the
	 * SixClosestLocations class to get the names of the six global locations
	 * closest to the user's selected city, and then dynamically creates JButtons
	 * and JLabels for each location.
	 * 
	 * @param myFrame The JFrame object on which the SelectionScreen is displayed.
	 * @param myClickedCityLabel The JLabel object representing the user's selected city in a previous screen.
	 * 
	 */
	public SelectionScreen(JFrame myFrame, JLabel myClickedCityLabel) {
		super(myFrame, myClickedCityLabel);
		// Get the names of the six global locations closest to the user's selected city
		SixClosestLocations getLocations = new SixClosestLocations(myClickedCityLabel);
		mySixLocations = getLocations.getGlobalSixLocations();
		System.out.println("This is SelctionScreen" + mySixLocations);

		// Creates JButtons and JLabels for each location
		for (int i = 0; i < mySixButtons.length; i++) {
			mySixButtons[i] = new JButton(mySixLocations.get(i));
			mySixButtons[i].setName(mySixLocations.get(i));

			mySixLabels[i] = new JLabel(mySixLocations.get(i));

			mySixLabels[i].setFont(new Font("American Typewriter", Font.BOLD, 20));

			mySixLabels[i].setBackground(Color.WHITE);
			mySixLabels[i].setOpaque(true); // Make label opaque so background color is visible
			mySixButtons[i].setPreferredSize(new Dimension(350, 300));
			mySixLabels[i].setPreferredSize(new Dimension(350, 65));
			System.out.println("Hello");

		}

		System.out.println(mySixButtons);
		System.out.println(mySixLabels);

	}

	/**
	 * Overrides the specificSelectionScreen method in the AbstractSelectionScreen
	 * class. This method sets up the layout of the selection screen by adding the
	 * dynamically created JButtons and JLabels to a JPanel with a GridLayout.
	 * 
	 * @param myLocationPanel The JPanel object on which the JButtons and JLabels are displayed.
	 * @param myClickedCityString The name of the user's selected city in a previous screen.
	 * 
	 */
	@Override
	protected void specificSelectionScreen(JPanel myLocationPanel, String myClickedCityString) {

		// Iterates through the GridLayout adding labels and buttons
		for (int i = 0; i < 2; i++) { // Rows
			for (int j = 0; j < 3; j++) { // Columns

				// Create a new JPanel with BorderLayout for each cell
				JPanel cellPanel = new JPanel(new BorderLayout());
//				cellPanel.add(mySixButtons[i], BorderLayout.NORTH); // Add the button to the NORTH position
//				cellPanel.add(mySixLabels[j], BorderLayout.CENTER); // Add the label to the CENTER position

				myLocationPanel.add(cellPanel); // Add the new JPanel with BorderLayout to the GridLayout
			}
		}

	}

}
