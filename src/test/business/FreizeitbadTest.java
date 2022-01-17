package test.business;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.businessFreizeitbaeder.Freizeitbad;

class FreizeitbadTest {

	Freizeitbad freizeitbad;

	@BeforeEach
	void setUp() throws Exception { 	// name,        von,   bis,    bl, temp
		this.freizeitbad = new Freizeitbad("Stadtbad", "7.0", "17.0", "25", "24");
	}

	@AfterEach
	void tearDown() throws Exception {
		this.freizeitbad = null;
	}

	@Test
	void imKonstruktorEnthalten() {
		BooleanSupplier booleanSupplier;
		booleanSupplier = () -> freizeitbad.getBeckenlaenge() == 25; // pr�ft ob die Beckenlaenge im Konstruktor auf 25 gesetzt wurde
		assertTrue(booleanSupplier.getAsBoolean());
	}	
	
}