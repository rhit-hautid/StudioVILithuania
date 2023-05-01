package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
		String CastleHistory = null;
		String WhatsNearby = null;
		String GettingAround = null;
		String Restaurants = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("<b> Castle History")) {
					CastleHistory = sb.toString().trim();
					sb.setLength(0);
					System.out.println(CastleHistory);
					
				} else if (line.startsWith("<b> What's Nearby")) {
					WhatsNearby = sb.toString().trim();
					sb.setLength(0);
					System.out.println(WhatsNearby);

				} else if (line.startsWith("<b> Getting Around")) {
					GettingAround = sb.toString().trim();
					sb.setLength(0);
					System.out.println(GettingAround);

				} else if (line.startsWith("<b> Restaurants")) {
					Restaurants = sb.toString().trim();
					sb.setLength(0);
					System.out.println(Restaurants);
					System.out.println(Restaurants);

				} else {
					sb.append(line).append("\n");
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		// Use the variables CastleHistory, WhatsNearby, GettingAround, Restaurants as
		// needed.
	}
}