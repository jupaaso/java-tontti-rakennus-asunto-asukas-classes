import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Asunto {

    private double asunnonPintaAla;
    private int asunnonHuoneidenLKM;
    private Asukas asukas;           
    private ArrayList<Asunto> asunnot;
	
    public Asunto(double asunnonAla, int huoneidenLKM, Asukas asukas) { //  KONSTRUKTORI
		this.asunnonPintaAla = asunnonAla;
		this.asunnonHuoneidenLKM = huoneidenLKM;
 		this.asukas = asukas;
	}
    public Asunto(ArrayList<Asunto> asunnot) {
        this.asunnot = asunnot;
    }
	public void setAsunnonPintaAla(double asunnonAla) {       // SETTERIT
		asunnonPintaAla = asunnonAla;
	}
    public void setAsunnonHuoneidenLKM(int huoneidenLKM) {
        asunnonHuoneidenLKM = huoneidenLKM;
    }
 
	public double getAsunnonPintaAla() {                      // GETTERIT
		return asunnonPintaAla;
	}
    public int getAsunnonHuoneidenLKM() {
        return asunnonHuoneidenLKM;
    }
    
    // TULOSTETAAN ASUNNOT MERKKIJONONA
    public String getAsunnot() {
        String mjono = "";
        Iterator<Asunto> it = this.asunnot.iterator();
        while(it.hasNext()) {
            mjono = mjono + it.next().toString();
        }
        return mjono;
    }
     
	public String toString() {
        return "Asunnon pinta-ala: " + asunnonPintaAla + " m2, " +
               "Asunnon huoneiden lukumaara: " + asunnonHuoneidenLKM + ".\n" +
                asukas.getAsukkaat() + "\n";
    }
}