package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

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
	public Boolean MapCheck = false;
	JFrame Test;
	MapWindow MapWindowSave = new MapWindow(MyHomePage.updatableLabel);

	// SpecificInformationScreen AdditionalInfo = new
	// SpecificInformationScreen(cityClicked, new JPanel(), new JPanel());
	// SpecificInformationScreen SaveIt = new SpecificInformationScreen();
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

		
		// If the "Map" button is clicked
		if (buttonName.equals("Map")) {
			MapWindowSave.VisibilitySet(true);
		}
		// If the "Search" button is clicked
		if (buttonName.equals("Search")) {

			// Check if a location has been selected, if no city selected an error message 
			//appears. also checks what language was selected by the user. 
			if (myLabelText.equals(" Click Map")) {

				JOptionPane pane = new JOptionPane("No Location Selected, Click Map and Proceed!",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = pane.createDialog("Please Select Your Location!");

				dialog.setAlwaysOnTop(true);
				dialog.setModal(false);
				dialog.setVisible(true);

				// Close the dialog after 3 seconds
				Timer timer = new Timer(3000, event -> {
					dialog.dispose();
				});

				timer.setRepeats(false);
				timer.start();

				return;
			} else if (myLabelText.equals(" Stumkite žemėlapį")) {

				JOptionPane pane = new JOptionPane("Vietovės Nepasirinkta, Spustelėkite Žemėlapį ir Tęskite!",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = pane.createDialog("Prašome Pasirinkti Savo Buvimo Vietą!");

				dialog.setAlwaysOnTop(true);
				dialog.setModal(false);
				dialog.setVisible(true);

				// Close the dialog after 3 seconds
				Timer timer = new Timer(3000, event -> {
					dialog.dispose();
				});

				timer.setRepeats(false);
				timer.start();

				return;
			}

			else {

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

		// If the "Home" button is clicked
		if (buttonName.equals("Home")) {
			myChangedFrame.getContentPane().removeAll();
			myChangedFrame.getContentPane().repaint();
			new MyHomePage(myChangedFrame);
		}

		if (buttonName.equals("Selection Screen")) {

			myChangedFrame.getContentPane().removeAll();
			new SelectionScreen(myChangedFrame, myLabel);
		}
		// If the "Additional Information: City" button is clicked
		if (buttonName.equals("MoreInfo")) {
			myChangedFrame.getContentPane().removeAll();
			myChangedFrame.getContentPane().repaint();

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

	public void setMapCheck(Boolean mapCheck) {
		MapCheck = mapCheck;
	}
}
