package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Abstract class for a selection screen that displays a grid layout of
 * locations for a specific city. Provides functionality for returning to the
 * home screen.
 * 
 * @author Isabel Haut
 */
public abstract class AbstractSelectionScreen {

	// Variables
	private JFrame myFrame;
	private JPanel myGridLayoutPanel;
	private JLabel myClickedCityLabel;
	private String myClickedCityString;
	private JButton myHomeButton;
	private JPanel myHomePanel;
	private JPanel myLocationPanel;

	/**
	 * Constructs a new AbstractSelectionScreen with the given main frame and
	 * clicked city label.
	 * 
	 * @param myFrame            The main frame for the selection screen.
	 * @param myClickedCityLabel The label displaying the name of the clicked city.
	 */
	public AbstractSelectionScreen(JFrame myFrame, JLabel myClickedCityLabel) {
		this.myFrame = myFrame;
		this.myClickedCityLabel = myClickedCityLabel;
		// The name of the clicked city.
		this.myClickedCityString = myClickedCityLabel.getText().substring(7);

		// The panel containing the home button
		myHomePanel = new JPanel();
		myHomePanel.setPreferredSize(new Dimension(1500, 50));

		// The panel containing the location panel
		myLocationPanel = new JPanel(new GridLayout(2, 3)); // Create a 3 by 3 GridLayout
		// Set gaps between cells in the GridLayout
		myLocationPanel.setLayout(new GridLayout(2, 3, 60, 15)); // Set horizontal and vertical gap to 50 pixels
		// Set border around the GridLayout
		myLocationPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 35, 50)); // Set top, left, bottom, right
																					// border to 50 pixels

		myLocationPanel.setPreferredSize(new Dimension(1500, 950));

		// The button to return to the home screen.
		myHomeButton = new JButton("Home");
		myHomeButton.addActionListener(new ButtonListener(myHomeButton, myFrame));
		myHomePanel.add(myHomeButton);

		// Color blue
		Color myYellow = new Color(245, 224, 143);

		myLocationPanel.setBackground(myYellow);

		myFrame.add(myLocationPanel);
		myLocationPanel.setBackground(Color.WHITE);
		myFrame.add(myHomePanel, BorderLayout.NORTH);
		myHomePanel.setBackground(myYellow);

		specificSelectionScreen(myLocationPanel, myClickedCityString);
		myFrame.revalidate();
		myFrame.repaint();

	}

	/**
	 * Abstract method that specifies the contents of the selection screen's
	 * location panel.
	 * 
	 * @param myLocationPanel     The panel containing the location grid layout.
	 * @param myClickedCityString The name of the clicked city.
	 */
	protected abstract void specificSelectionScreen(JPanel myLocationPanel, String myClickedCityString);

}
