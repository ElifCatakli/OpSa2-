package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import ownUtil.PlausiException;
import patterns.Observer;

public class SporthallenModel {

	private ArrayList<Sporthalle> sporthalle;
	private static SporthallenModel instance = null;
	Vector<Observer> observers = new Vector<Observer>();

	private SporthallenModel() {
	}

	public static SporthallenModel getInstance() {
		if (instance == null)
			instance = new SporthallenModel();
		return instance;
	}

	public void leseSporthallenAusCsvDatei() throws IOException, PlausiException {
		BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
		ArrayList<Sporthalle> ergebnis = new ArrayList<>();
		String zeileStr = ein.readLine();
		while (zeileStr != null) {
			String[] zeile = zeileStr.split(";");			
			//ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
			ergebnis.add(new Sporthalle(zeile[0].substring(1), zeile[1], zeile[2].substring(0,zeile[2].length()-1)));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.sporthalle = ergebnis;
	}

	public ArrayList<Sporthalle> getSporthalle() {
		return sporthalle;
	}

	public void setSporthallen(ArrayList<Sporthalle> sporthalle) {
		this.sporthalle = sporthalle;
	}
	
}