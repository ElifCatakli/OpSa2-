package factory;

import java.io.*;

public abstract class Product {

	public abstract void fuegeInDateiHinzu(Object object) throws IOException;

	public abstract void schliesseDatei() throws IOException;
}