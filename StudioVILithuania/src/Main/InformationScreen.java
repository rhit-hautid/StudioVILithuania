package Main;

import java.awt.Color;
import java.awt.Dimension;

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
public class InformationScreen {

	private JFrame myFrame;
	private JButton mySelectionButton;
	private JPanel mySelectionPanel;
	/**
	 * Constructor for the InformationScreen class.
	 * 
	 * @param myChangedFrame the JFrame that will be changed to display the
	 *                       information screen
	 * @param string         the name of the city whose information will be
	 *                       displayed on the screen
	 */
	public InformationScreen(JFrame myChangedFrame, String string) {
		
		this.myFrame = myChangedFrame;
		
		// Color blue
		Color myYellow = new Color(245, 224, 143);
		
		// The panel containing the home button
		mySelectionPanel = new JPanel();
		mySelectionPanel.setPreferredSize(new Dimension(1500, 50));
		myFrame.add(mySelectionPanel);
		
		mySelectionButton = new JButton("Selection Screen");
		mySelectionButton.setName("Selection Screen");
		mySelectionPanel.setBackground(myYellow);

		mySelectionButton.addActionListener(new ButtonListener(mySelectionButton, myFrame));
		mySelectionPanel.add(mySelectionButton);
		
		
		myFrame.revalidate();
		myFrame.repaint();
	}

}
