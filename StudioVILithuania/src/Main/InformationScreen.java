package Main;

import java.awt.BorderLayout;
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

	public static final Dimension FIRST_SCREEN_SIZE = new Dimension(850, 525);
	JFrame frame = new JFrame();// creates a new frame
	JPanel panel = new JPanel(); // creates a new panel
	JButton myAdditionalInformation;
	public static String pickedLanguage = Main.pickedLanguage;
	String castleHistory;
	String whatsNearby;
	String gettingAround;
	String restaurants;
	String usefulInformation;

	public InformationScreen(JFrame myChangedFrame, String string) {
		super(myChangedFrame, string);
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

		String fileName = "StudioVILithuania/TextFiles/" + string;

		if (pickedLanguage.equals("Lithuanian")) {
			try (Scanner reader = new Scanner(new FileReader(fileName))) {

				for (int i = 0; i < 6; i++) {
					reader.nextLine();
				}

				castleHistory = reader.nextLine();
				whatsNearby = reader.nextLine();
				gettingAround = reader.nextLine();
				restaurants = reader.nextLine();
				usefulInformation = reader.nextLine();

			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage());
			}
		}

		else {
			try (Scanner reader = new Scanner(new FileReader(fileName))) {

				castleHistory = reader.nextLine();
				whatsNearby = reader.nextLine();
				gettingAround = reader.nextLine();
				restaurants = reader.nextLine();
				usefulInformation = reader.nextLine();

			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage());
			}
		}

		// Create a new JLabel and set the castleHistory text to it
		JLabel castleHistoryLabel = new JLabel("<html>" + castleHistory);
		castleHistoryLabel.setFont(new Font(castleHistoryLabel.getText(), Font.PLAIN, 19));

		// Add the castleHistoryLabel to the appropriate panel (myPanelOne in this case)
		myPanelOne.add(castleHistoryLabel);

		// Create a new JLabel and set the castleHistory text to it
		JLabel myDescriptionLabel = new JLabel(
				"<html>" + whatsNearby + gettingAround + restaurants + usefulInformation);
		myDescriptionLabel.setFont(new Font(myDescriptionLabel.getText(), Font.PLAIN, 19));

		// Add the castleHistoryLabel to the appropriate panel (myPanelOne in this case)
		myPanelTwo.add(myDescriptionLabel);

		// Use the variables CastleHistory, WhatsNearby, GettingAround, Restaurants as
		// needed.

		if (pickedLanguage.equals("Lithuanian")) {
			myAdditionalInformation = new JButton("Daugiau Informacijos Apie " + string);

		} else {
			myAdditionalInformation = new JButton("More Info About " + string);

		}

		myAdditionalInformation.setName("MoreInfo");
		myAdditionalInformation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setSize(FIRST_SCREEN_SIZE);
				panel.setSize(FIRST_SCREEN_SIZE);
				frame.add(panel);

				if (pickedLanguage.equals("Lithuanian")) {
					frame.setTitle("Papildoma Informacija");
				} else {
					frame.setTitle("Additional Information");
				}

				Color myYellow = new Color(245, 185, 19);
				panel.setBackground(myYellow);

				// add image of map to the panel
				ImageIcon myAddInfo = new ImageIcon("StudioVILithuania/AdditionalInformation/" + string + ".PNG");
				JLabel jlPic = new JLabel(myAddInfo);
				panel.add(jlPic, BorderLayout.CENTER);

				// moves the mapWindow to appear on the right side of the screen
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width / 2 - frame.getSize().width / 8,
						dim.height / 2 - frame.getSize().height / 2);

				setVisabillity(true);
				frame.setVisible(true);
				frame.setResizable(false);

			}
		});

		myPanelTwo.add(myAdditionalInformation);
	}

	public void setVisabillity(Boolean source) {
		frame.setVisible(source);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}