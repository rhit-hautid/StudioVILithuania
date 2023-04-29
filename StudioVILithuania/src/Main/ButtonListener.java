package Main;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 * ButtonListener is a class that extends AbstractButtonListener and implements
 * ActionListener. It listens for button clicks and performs actions based on
 * the button that was clicked. It can perform different actions based on the
 * button that was clicked, such as opening a new window or displaying a
 * message.
 * 
 * @author Isabel Haut
 */
public class ButtonListener extends AbstractButtonListener {

	// Variables
	String buttonName;

	/**
	 * Constructor for ButtonListener class. Calls the constructor of the superclass
	 * (AbstractButtonListener) to initialize the variables.
	 * 
	 * @param myClickedButton - The JButton that was clicked.
	 * @param myFrame         - The JFrame associated with the button that was
	 *                        clicked.
	 */
	public ButtonListener(JButton myClickedButton, JFrame myFrame) {
		super(myClickedButton, myFrame);

	}

	/**
	 * Overrides the actionPerformed method in the ActionListener interface to
	 * define what happens when a button is clicked.
	 * 
	 * @param e - The ActionEvent that was triggered by the button click.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		buttonName = this.getButton().getName();

		JFrame myChangedFrame = this.getMyFrame();
		JLabel myLabel = MyHomePage.updatableLabel;
		String myLabelText = MyHomePage.updatableLabel.getText();
		String[] castleNames = { "Klaipeda", "Panemune", "Raudone", "Raudonvaris", "Kaunas", "Birzai", "Siesikai",
				"Medininkai", "Norviliskes", "Trakai" };

		// If the "Search" button is clicked
		if (buttonName.equals("Search")) {

			// Check if a location has been selected
			if (myLabelText.equals(" None Selected")) {
				JOptionPane.showMessageDialog(myChangedFrame, "No Location Selected, Click Map and Proceed!",
						"Please Select Your Location!", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				myChangedFrame.getContentPane().removeAll();
				myChangedFrame.getContentPane().repaint();
				new SelectionScreen(myChangedFrame, myLabel);

			}

		}

		// If one of the city buttons is clicked
		for (int i = 0; i < castleNames.length; i++) {
			if (buttonName.equals(castleNames[i])) {
				myChangedFrame.getContentPane().removeAll();
				myChangedFrame.getContentPane().repaint();
				new InformationScreen(myChangedFrame, castleNames[i]);

			}

		}
		// If the "Map" button is clicked
		if (buttonName.equals("Map")) {

			// TODO: Prevent user from opening multiple MapWindows at a time

			new MapWindow(myLabel);

		}
		// If the "Home" button is clicked
		if (buttonName.equals("Home")) {
			new MyHomePage();
		}

	}

	/**
	 * Overrides the handleButtonPress method in the AbstractButtonListener class to
	 * handle button press events.
	 * 
	 * @param e - The ActionEvent that was triggered by the button press.
	 */
	@Override
	public void handleButtonPress(ActionEvent e) {

		// Keep Empty For Now

	}

}
