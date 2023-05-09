package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;

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

		JPanel myClearPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(myYellow);
				g.fillRect(0, 0, myFrame.getWidth(), 25); // left half
				g.setColor(Color.GREEN);
				g.fillRect(0, 25, myFrame.getWidth(), 50); // right half
				g.setColor(Color.RED);
				g.fillRect(0, 50, myFrame.getWidth(), 75); // right half
			}
		};
		
		myClearPanel.setPreferredSize(new Dimension(1500, 75));
		myFrame.add(myClearPanel, BorderLayout.NORTH);
		mySelectionButton = new JButton("Selection Screen");
		mySelectionButton.setName("Selection Screen");
		mySelectionButton.addActionListener(new ButtonListener(mySelectionButton, myFrame));
		
		myClearPanel.add(mySelectionButton);

//		

		// The panel containing the location panel
		myInformationPanel = new JPanel(new GridLayout(1, 2)); // Create a 1 by 2 GridLayout
		// Set gaps between cells in the GridLayout
		myInformationPanel.setLayout(new GridLayout(1, 2, 10, 0)); // Set horizontal and vertical gap to 50 pixels
		// Set border around the GridLayout
		myInformationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Set top, left, bottom, right
																						// border to 50 pixels
		myInformationPanel.setPreferredSize(new Dimension(1500, 880));
		myInformationPanel.setBounds(0, 200, 1500, 800);

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
