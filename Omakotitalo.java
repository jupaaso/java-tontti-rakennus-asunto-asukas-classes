import java.io.*;
import java.util.ArrayList;

public class Omakotitalo extends Rakennus {

    private double asunnonPintaAla;
    private int asunnonHuoneidenLKM;
    private Asukas asukas;
	
    public Omakotitalo(int asuntojenLKM, double rakennuksenAla, int kerrokset, 
                       double asunnonAla, int huoneidenLKM, Asukas asukas) {  // KONSTRUKTORI
        super(asuntojenLKM, rakennuksenAla, kerrokset);                       // Kutsutaan yliluokan konstruktoria
		this.asunnonPintaAla = asunnonAla;
		this.asunnonHuoneidenLKM = huoneidenLKM;
 		this.asukas = asukas;
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

	public void printYhdenKiinteistonTiedot() {
		System.out.println("   Omakotitontin tiedot ovat seuraavat:");
		System.out.println("   Rakennuksen asuntojen lukumaara: " + getRakennuksenAsuntojenLKM()
					   + "\n   Rakennuksen pinta-ala:           " + getRakennuksenPintaAla()
					   + "\n   Asunnon pinta-ala:               " + getAsunnonPintaAla()
					   + "\n   Asunnon huoneiden lukumaara:     " + getAsunnonHuoneidenLKM()
					   + asukas + "\n");
	}
                
    // Tama toimii mutta vain yksi asukas tulostuu
	public String toString() {
        return "Rakennuksen asuntojen lukumaara: " + getRakennuksenAsuntojenLKM() + 
               ", Rakennuksen pinta-ala: " + getRakennuksenPintaAla() + " m2.\n" +
		       "Asunnon pinta-ala: " + asunnonPintaAla + " m2, " +
               "Asunnon huoneiden lukumaara: " + asunnonHuoneidenLKM + ".\n" +
                asukas.getAsukkaat() + "\n";			 
    }
}