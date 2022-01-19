package factory;

import business.businessFreizeitbaeder.Freizeitbad;
import business.businessSporthallen.Sporthalle;

import java.io.*;

public class ConcreteCsvProduct extends Product {

	private BufferedWriter bw;

	public ConcreteCsvProduct() throws IOException {
		this.bw = new BufferedWriter(new FileWriter("Freizeitbad.csv", true));
		this.bw = new BufferedWriter(new FileWriter("Sportstaetten.csv", true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		this.bw.write(((Freizeitbad) object).gibFreizeitbadZurueck(';'));
		this.bw.write(((Sporthalle) object).gibSporthalleZurueck(','));
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.bw.close();
	}
	
}