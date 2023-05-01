package Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InformationScreen extends AbstractInformationScreen {

	public InformationScreen(JFrame myChangedFrame, String string) {
		super(myChangedFrame, string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SpecificInformationScreen(String string, JPanel myPanelOne, JPanel myPanelTwo, JPanel myPanelThree) {

		String fileName = "C:\\Users\\hautid\\git\\StudioVILithuania\\StudioVILithuania\\TextFiles\\Birzai";

		try (Scanner reader = new Scanner(new FileReader(fileName))) {

			String castleHistory = reader.nextLine();
			String whatsNearby = reader.nextLine();
			String gettingAround = reader.nextLine();
			String restaurants = reader.nextLine();

			System.out.println(castleHistory);
			System.out.println(whatsNearby);
			System.out.println(gettingAround);
			System.out.println(restaurants);

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		// Use the variables CastleHistory, WhatsNearby, GettingAround, Restaurants as
		// needed.
	}
}