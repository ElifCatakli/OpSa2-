package business.businessFreizeitbaeder;

import patterns.Observable;
import patterns.Observer;
import java.io.IOException;
import java.util.Vector;
import java.util.ArrayList;
import factory.ConcreteCreator;
import factory.ConcreteCsvProduct;
import factory.ConcreteTxtProduct;
import factory.Creator;

public class FreizeitbaederModel implements Observable {

	ArrayList<Freizeitbad> freizeitbad = new ArrayList<>(); // ArrayList
	private static FreizeitbaederModel instance = null;
	Vector<Observer> observers = new Vector<Observer>();

	private FreizeitbaederModel() {
	}

	public static FreizeitbaederModel getInstance() {
		if (instance == null)
			instance = new FreizeitbaederModel();
		return instance;
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator csv = new ConcreteCreator();
		ConcreteCsvProduct writer = (ConcreteCsvProduct) csv.factoryMethod("csv");
		for (Freizeitbad fzb : freizeitbad) {
			writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliesseDatei();
	}

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator txt = new ConcreteCreator();
		ConcreteTxtProduct writer = (ConcreteTxtProduct) txt.factoryMethod("txt");
		for (Freizeitbad fzb : freizeitbad) {
			writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliesseDatei();
	}

	// angepasste get-Methode
	public ArrayList<Freizeitbad> getFreizeitbad() {
		return freizeitbad;
	}

	// ausgetauschte set-Methode
	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
		this.notifyObservers();
	}

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.removeElement(obs);
	}

	@Override
	public void notifyObservers() {
		for (Observer obs : observers) {
			obs.update();
		}	
	}
}