package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * The InformationScreen class represents a screen that displays information
 * about a specific city.
 * 
 * @author Isabel Haut
 */
public abstract class AbstractInformationScreen {

	protected JFrame myFrame;
	private String cityClicked;
	private JButton mySelectionButton;
	private JPanel mySelectionPanel;
	private JPanel mySelectionPanelTwo;
	private JPanel mySelectionPanelThree;
	private JPanel myInformationPanel;
	private JPanel myPanelOne;
	private JPanel myPanelTwo;

	/**
	 * Constructor for the InformationScreen class.
	 * 
	 * @param myChangedFrame the JFrame that will be changed to display the
	 *                       information screen
	 * @param string         the name of the city whose information will be
	 *                       displayed on the screen
	 */
	public AbstractInformationScreen(JFrame myChangedFrame, String string) {

		this.myFrame = myChangedFrame;
		this.cityClicked = string;

		// Color yellow
		Color myYellow = new Color(245, 224, 143);

		// The panel containing the home button
		mySelectionPanel = new JPanel();
		mySelectionPanel.setPreferredSize(new Dimension(1500, (int) 16.6667));
		mySelectionPanelTwo = new JPanel();
		mySelectionPanelTwo.setPreferredSize(new Dimension(1500, (int) 16.6667));
		mySelectionPanelThree = new JPanel();
		mySelectionPanelThree.setPreferredSize(new Dimension(1500, (int) 16.6667));

		mySelectionPanel.setBackground(myYellow);
		mySelectionPanelTwo.setBackground(Color.GREEN);
		mySelectionPanelThree.setBackground(Color.RED);

		JPanel myFlagPanel = new JPanel(new GridLayout(3, 1));
		myFlagPanel.add(mySelectionPanel);
		myFlagPanel.add(mySelectionPanelTwo);
		myFlagPanel.add(mySelectionPanelThree);
		myFrame.getContentPane().add(myFlagPanel, BorderLayout.NORTH);
		


		// The panel containing the location panel
		myInformationPanel = new JPanel(new GridLayout(1, 2)); // Create a 1 by 2 GridLayout
		// Set gaps between cells in the GridLayout
		myInformationPanel.setLayout(new GridLayout(1, 2, 10, 0)); // Set horizontal and vertical gap to 50 pixels
		// Set border around the GridLayout
		myInformationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Set top, left, bottom, right
																						// border to 50 pixels
		myInformationPanel.setPreferredSize(new Dimension(1500, 880));
		myInformationPanel.setBounds(0, 200, 1500, 800);

		mySelectionButton = new JButton("Selection Screen");
		mySelectionButton.setName("Selection Screen");
		mySelectionPanel.add(mySelectionButton);
		mySelectionButton.addActionListener(new ButtonListener(mySelectionButton, myFrame));

		myFrame.add(myInformationPanel);
		myInformationPanel.setBackground(Color.WHITE);

		myPanelOne = new JPanel();
		myInformationPanel.add(myPanelOne);

		myPanelTwo = new JPanel();
		myInformationPanel.add(myPanelTwo);

		SpecificInformationScreen(cityClicked, myPanelOne, myPanelTwo);

		myFrame.revalidate();
		myFrame.repaint();
	}

	public abstract void SpecificInformationScreen(String string, JPanel myPanelOne, JPanel myPanelTwo);

}
