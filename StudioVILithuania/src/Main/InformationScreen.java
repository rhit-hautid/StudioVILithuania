package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 *
 * @author Isabel Haut
 */

public class InformationScreen extends AbstractInformationScreen {

	public static final Dimension FIRST_SCREEN_SIZE = new Dimension(810, 700);

	public InformationScreen(JFrame myChangedFrame, String string) {
		super(myChangedFrame, string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SpecificInformationScreen(String string, JPanel myPanelOne, JPanel myPanelTwo) {

		JButton myManyImages = new JButton();
		myManyImages.setPreferredSize(new Dimension(720, 400));

		String myManyImagesPath = "StudioVILithuania/CastleImages/" + string + "Castle.PNG";
		ImageIcon myManyImage = new ImageIcon(myManyImagesPath);
		myManyImages.setContentAreaFilled(false);
		myManyImages.setBorderPainted(false);
		myManyImages.setIcon(myManyImage);
		myPanelOne.add(myManyImages);

		JButton myAdditionalInformation = new JButton("More Info About " + string);
		myAdditionalInformation.setName("MoreInfo");
		myPanelTwo.add(myAdditionalInformation);

		myAdditionalInformation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame(); // creates a new frame
				JPanel panel = new JPanel(); // creates a new panel

				frame.setSize(FIRST_SCREEN_SIZE);
				panel.setSize(FIRST_SCREEN_SIZE);
				frame.add(panel);
				frame.setTitle("Additional Information");
				Color myYellow = new Color(245, 224, 143);

				panel.setBackground(myYellow);

				// moves the mapWindow to appear on the right side of the screen
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width / 2 - frame.getSize().width / 8,
						dim.height / 2 - frame.getSize().height / 2);

				frame.setVisible(true);
				frame.setResizable(false);

			}
		});

		String fileName = "C:\\Users\\hautid\\git\\StudioVILithuania\\StudioVILithuania\\TextFiles\\Birzai";

		try (Scanner reader = new Scanner(new FileReader(fileName))) {

			String castleHistory = reader.nextLine();
			String whatsNearby = reader.nextLine();
			String gettingAround = reader.nextLine();
			String restaurants = reader.nextLine();

			// Create a new JLabel and set the castleHistory text to it
			JLabel castleHistoryLabel = new JLabel("<html>" + castleHistory);
			castleHistoryLabel.setFont(new Font(castleHistoryLabel.getText(), Font.PLAIN, 20));

			// Add the castleHistoryLabel to the appropriate panel (myPanelOne in this case)
			myPanelOne.add(castleHistoryLabel);

			// Create a new JLabel and set the castleHistory text to it
			JLabel whatsNearbyLabel = new JLabel("<html>" + whatsNearby);
			whatsNearbyLabel.setFont(new Font(whatsNearbyLabel.getText(), Font.PLAIN, 20));

			// Add the castleHistoryLabel to the appropriate panel (myPanelOne in this case)
			myPanelTwo.add(whatsNearbyLabel);

			// Create a new JLabel and set the castleHistory text to it
			JLabel gettingAroundLabel = new JLabel("<html>" + gettingAround);
			gettingAroundLabel.setFont(new Font(gettingAroundLabel.getText(), Font.PLAIN, 20));

			// Add the castleHistoryLabel to the appropriate panel (myPanelOne in this case)
			myPanelTwo.add(gettingAroundLabel);

			// Create a new JLabel and set the castleHistory text to it
			JLabel restaurantsLabel = new JLabel("<html>" + restaurants);
			restaurantsLabel.setFont(new Font(restaurantsLabel.getText(), Font.PLAIN, 20));

			// Add the castleHistoryLabel to the appropriate panel (myPanelOne in this case)
			myPanelTwo.add(restaurantsLabel);

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		// Use the variables CastleHistory, WhatsNearby, GettingAround, Restaurants as
		// needed.
	}
}