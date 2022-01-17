package factory;

import java.io.IOException;
import java.util.ArrayList;

import business.businessFreizeitbaeder.Freizeitbad;
import business.businessSporthallen.Sporthalle;

public abstract class Creator {

	public abstract Product factoryMethod(String typ) throws IOException;

	public abstract ArrayList<Freizeitbad> freizeitbad() throws IOException;

	public abstract ArrayList<Sporthalle> sporthalle() throws IOException;
}