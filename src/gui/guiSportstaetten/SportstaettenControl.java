package gui.guiSportstaetten;

import java.io.IOException;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import javafx.stage.Stage;
import patterns.Observer;

public class SportstaettenControl implements Observer {

	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenView sportstaettenView;
	private SporthallenModel sporthallenModel;

	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sporthallenModel = SporthallenModel.getInstance();
		this.sportstaettenView = new SportstaettenView(primaryStage, this, this.freizeitbaederModel,
				this.sporthallenModel);
		this.freizeitbaederModel.addObserver(this);
	}

	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				// Aufruf des Models zum Schreiben des
				// Freizeitbads in die Datei des vorgegebenen
				// Typs und Ausgabe der Meldung
				this.sportstaettenView.zeigeInformationsfensterAn(
						"Die Freizeitb�der wurden erfolgreich in die csv-Datei eingetragen");
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
			} else if ("txt".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				sportstaettenView.zeigeInformationsfensterAn(
						"Die Freizeitb�der wurden erfolgreich in die txt-Datei eingetragen.");
			} else {
				sportstaettenView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			sportstaettenView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!", exc.toString());
		} catch (Exception exc) {
			sportstaettenView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!", exc.toString());
		}
	}

	@Override
	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}
	
}