import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Kerrostalo extends Rakennus {

    private ArrayList<KerrostaloAsunto> kerrostaloAsunnot;
	
    public Kerrostalo(int asuntojenLKM, double rakennuksenAla, int kerroksienLKM, 
                      ArrayList<KerrostaloAsunto> kerrostaloAsunnot) {  // KONSTRUKTORI
        super(asuntojenLKM, rakennuksenAla, kerroksienLKM);             // Kutsutaan yliluokan konstruktoria
        this.kerrostaloAsunnot = kerrostaloAsunnot;
	}
       
    // TULOSTETAAN MERKKIJONOON
    public String getKerrostaloAsunnot() {
        String mjono ="";
        Iterator<KerrostaloAsunto> it = kerrostaloAsunnot.iterator();
        while(it.hasNext()) {
            mjono = mjono + it.next().toString();
        }
        return mjono;
    } 
    
	public String toString() {
        return "Rakennuksen asuntojen lukumaara: " + getRakennuksenAsuntojenLKM() + ",\n" +
               "Rakennuksen pinta-ala: " + getRakennuksenPintaAla() + " m2,\n" +
               "Rakennuksen kerrosten lukumaara: " + getRakennuksenKerrostenLKM() + "\n" + "\n" +
		       getKerrostaloAsunnot() + "\n";
    }
}