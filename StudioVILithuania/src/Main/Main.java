package Main;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * The Main class is the entry point of the application. It contains the main()
 * method which is invoked when the program starts running.
 * 
 * @author Isabel Haut
 */
public class Main {

	/**
	 * The constant FIRST_SCREEN_SIZE represents the dimensions of the first screen
	 * displayed when the application is started.
	 */
	public static final Dimension FIRST_SCREEN_SIZE = new Dimension(1500, 1000);
	private static final String[] LANGUAGES = {"English", "Lithuanian"};
	protected static String pickedLanguage;

	/**
	 * The main() method is the entry point of the application. It instantiates the
	 * Main class and invokes its myStartApp() method.
	 * 
	 * @param args the command line arguments (not used in this application)
	 */
	public static void main(String[] args) {
		Main myMainPage = new Main();
		myMainPage.myStartApp();

		
	}

	/**
	 * The myStartApp() method is responsible for starting the application by
	 * creating and displaying the initial home page.
	 */
	private void myStartApp() {

		pickedLanguage = (String) JOptionPane.showInputDialog(null, "Please select a languge:", "Language Option", JOptionPane.PLAIN_MESSAGE, null, LANGUAGES, LANGUAGES[0]);
		new MyHomePage(new JFrame());

	}
}