package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * This class provides an abstract implementation of an ActionListener for a
 * JButton.
 * 
 * It contains variables for the name of the button, the button itself, and the
 * JFrame it is associated with.
 * 
 * It also provides getter methods for each of these variables.
 * 
 * Additionally, it defines abstract methods for handling button presses and
 * action events.
 * 
 * @author Isabel Haut
 */

public abstract class AbstractButtonListener implements ActionListener {

	// Variables
	private String myButtonName;
	private JButton myClickedButton;
	private JFrame myFrame;

	/**
	 * 
	 * Constructs an AbstractButtonListener with a given JButton and JFrame.
	 * 
	 * @param myClickedButton the button that is being listened to
	 * @param myFrame         the frame associated with the button
	 */
	public AbstractButtonListener(JButton myClickedButton, JFrame myFrame) {
		this.myClickedButton = myClickedButton;
		this.myButtonName = myClickedButton.getText();
		this.myFrame = myFrame;
	}

	/**
	 * 
	 * This method handles button presses.
	 * 
	 * @param e the ActionEvent associated with the button press
	 */
	public abstract void handleButtonPress(ActionEvent e);

	/**
	 * 
	 * This method handles action events.
	 * 
	 * @param e the ActionEvent associated with the button
	 */
	public abstract void actionPerformed(ActionEvent e);

	/**
	 * 
	 * Returns the JButton associated with this listener.
	 * 
	 * @return the JButton associated with this listener
	 */
	public JButton getButton() {
		return myClickedButton;
	}

	/**
	 * 
	 * Returns the name of the button associated with this listener.
	 * 
	 * @return the name of the button associated with this listener
	 */
	public String getMyButtonName() {
		return myButtonName;
	}

	/**
	 * 
	 * Returns the JFrame associated with this listener.
	 * 
	 * @return the JFrame associated with this listener
	 */
	public JFrame getMyFrame() {
		return myFrame;
	}

}