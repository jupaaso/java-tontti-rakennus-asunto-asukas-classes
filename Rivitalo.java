import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Rivitalo extends Rakennus {

    private double asunnonPintaAla;
    private int asunnonHuoneidenLKM;
    private ArrayList<Asunto> asunnot;
	
    public Rivitalo(int asuntojenLKM, double rakennuksenAla, int kerrokset, ArrayList<Asunto> asunnot) {  // KONSTRUKTORI
        super(asuntojenLKM, rakennuksenAla, kerrokset);                  // Kutsutaan yliluokan konstruktoria
        this.asunnot = asunnot;
	}

	public void setAsunnonPintaAla(double asunnonAla) {       // SETTERIT
		asunnonPintaAla = asunnonAla;
	}
    public void setAsunnonHuoneidenLKM(int huoneidenLKM) {
        asunnonHuoneidenLKM = huoneidenLKM;
    }
    // TULOSTETAAN 
    public String getRivitalonAsunnot() {
        int i = 0;
        String mjono ="";
        Iterator<Asunto> it = asunnot.iterator();
        System.out.println("");
        while(it.hasNext()) {
            i++;
            mjono = mjono + "Asunto " + i + ": ";
            mjono = mjono + it.next().toString();
        }
        return mjono;
    }
	public double getAsunnonPintaAla() {                      // GETTERIT
		return asunnonPintaAla;
	}
    public int getAsunnonHuoneidenLKM() {
        return asunnonHuoneidenLKM;
    }

	public String toString() {
        return "Rakennuksen asuntojen lukumaara: " + getRakennuksenAsuntojenLKM() + 
               ", Rakennuksen pinta-ala: " + getRakennuksenPintaAla() + " m2.\n" +
		       getRivitalonAsunnot();
    }
}