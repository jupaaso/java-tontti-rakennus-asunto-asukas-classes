import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Asukas {

	private String asukkaanNimi;
	private String asukkaanSyntymaAika; 
    private ArrayList<Asukas> asukkaat;
	  
    public Asukas(String nimi, String syntymaAika, ArrayList<Asukas> asukkaat) {       // KONSTRUKTORI
		asukkaanNimi = nimi;
		asukkaanSyntymaAika = syntymaAika;
        this.asukkaat = asukkaat;
        this.asukkaat.add(this); 
	}
    public Asukas(ArrayList<Asukas> asukkaat) {
        this.asukkaat = asukkaat;
    }

    // TULOSTETAAN ASUKKAAT MERKKIJONONA
    public String getAsukkaat() {
        String mjono = "";
        Iterator<Asukas> it = asukkaat.iterator();
        while(it.hasNext()) {
            mjono = mjono + it.next().toString();
        }
        return mjono;
    }
   
	public void setAsukkaanNimi(String nimi) {                  // SETTERIT
		asukkaanNimi = nimi;
	}
	public void setAsukkaanSyntymaAika(String syntymaAika) {
		asukkaanSyntymaAika = syntymaAika;
	}
	public String getAsukkaanNimi() {                           // GETTERIT
		return asukkaanNimi;
	}
	public String getAsukkaanSyntymaAika() {
		return asukkaanSyntymaAika;
	}
    
    public String toString() {
		return "Asukkaan nimi: " + asukkaanNimi + 
		       ". Asukkaan syntyma-aika: " + asukkaanSyntymaAika + ".\n";
    }
}