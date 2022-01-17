package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.businessFreizeitbaeder.Freizeitbad;
import business.businessSporthallen.*;

public class ConcreteCreator extends Creator {

	private BufferedReader br = null;
	private FileWriter writer;
	
	public Product factoryMethod(String typ) throws IOException {
		if (typ.equals("csv"))
			return new ConcreteCsvProduct();
		else
			return new ConcreteTxtProduct();
	}

	@Override
	public ArrayList<Freizeitbad> freizeitbad() throws IOException {
		ArrayList<Freizeitbad> freizeitbad = new ArrayList<>();
		this.setBr(new BufferedReader(new FileReader("Freizeitbaeder.csv")));
		return freizeitbad;
	}
	
	public ArrayList<Sporthalle> sporthalle() throws IOException {
		ArrayList<Sporthalle> sporthalle= new ArrayList<>();
		this.setBr(new BufferedReader(new FileReader("Sporthallen.csv")));
		return sporthalle;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public FileWriter getWriter() {
		return writer;
	}

	public void setWriter(FileWriter writer) {
		this.writer = writer;
	}
}