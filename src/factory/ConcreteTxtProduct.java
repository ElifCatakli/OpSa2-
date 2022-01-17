package factory;

import java.io.*;

import business.businessFreizeitbaeder.Freizeitbad;

public class ConcreteTxtProduct extends Product {
	private BufferedWriter bw;

	public ConcreteTxtProduct() throws IOException {
		this.bw = new BufferedWriter(new FileWriter("Freizeitbad.txt", true));
	}

	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		this.bw.write("Daten des Freizeitbades\n");
		this.bw.write("Name des Freizeitbaedes:\t\t\t" + ((Freizeitbad) object).getName() + "\n");
		this.bw.write("Öffnungszeit des Freizeitbads:\t\t" + ((Freizeitbad) object).getGeoeffnetVon() + " - "
				+ ((Freizeitbad) object).getGeoeffnetBis() + "\n");
		this.bw.write("Beckenlänge des Freizeitbads:\t\t" + ((Freizeitbad) object).getBeckenlaenge() + "\n");
		this.bw.write("Wassertemperatur des Freizeitbads:\t" + ((Freizeitbad) object).getTemperatur() + "\n\n");
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.bw.close();
	}
}