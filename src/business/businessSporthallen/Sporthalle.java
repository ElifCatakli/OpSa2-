package business.businessSporthallen;

import ownUtil.PlausiException;

public class Sporthalle {
	
// Name der Sporthalle
    	private String name;
    	// Groesse der Flaeche
    	private int anzahlQuadratmeter;
    	// Bodenbelag
    	private String bodenbelag;

    	public Sporthalle(String name, String anzahlQuadratmeter, 
 		String bodenbelag)
        	throws PlausiException{
    		String feldname 
 			= pruefeFormal(name, anzahlQuadratmeter, bodenbelag);
    	 	if(feldname == null){
    		 	this.name = name;
      	     	this.anzahlQuadratmeter 
 				= Integer.parseInt(anzahlQuadratmeter);
       	    	this.bodenbelag = bodenbelag;
       	    	feldname = pruefeInhaltlich();
       	    	if(feldname != null) {
      	        	throw new PlausiException(
 					PlausiException.INHALTLICH, feldname);
       	    	}
        	}
    		else {
            	throw new PlausiException(PlausiException.FORMAL,
 				feldname);
        	} 
    	}  
  
    	private String pruefeFormal(String name, 
    		String anzahlQuadratmeter, String bodenbelag) {
        	String erg = null;
        	if(name == null || "".equals(name)){
        		return "Name";
    		}
        	else{
	        	try {
	            	Integer.parseInt(anzahlQuadratmeter);
	        	}
	        	catch(NumberFormatException exc) {
	            	return "Anzahl Quadratmeter";
	        	}
	        	if(bodenbelag == null || "".equals(bodenbelag)){
	        		return "Bodenbelag";
	        	}
        	}
        	return erg;
    	}
    
    	private String pruefeInhaltlich() {
        	String erg = null;
        	if(this.anzahlQuadratmeter <= 0){
        		return "Anzahl Quadratmeter";
        	}
        	return erg;
    	}
           
	public String gibSporthalleZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getAnzahlQuadratmeter() + trenner
  		    	+ this.getBodenbelag();
   	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnzahlQuadratmeter() {
		return anzahlQuadratmeter;
	}

	public void setAnzahlQuadratmeter(int anzahlQuadratmeter) {
		this.anzahlQuadratmeter = anzahlQuadratmeter;
	}

	public String getBodenbelag() {
		return bodenbelag;
	}

	public void setBodenbelag(String bodenbelag) {
		this.bodenbelag = bodenbelag;
	}
}