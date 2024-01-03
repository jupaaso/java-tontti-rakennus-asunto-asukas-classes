import java.util.ArrayList;
import java.util.Iterator;

public class InsInfoSailioKerrostalo {

	private ArrayList<Tontti> kerrosSailio;
	
	
    // KERROSSAILIO
	public InsInfoSailioKerrostalo( ) {               // KONSTRUKTORI
		kerrosSailio = new ArrayList<Tontti>(5);      // 5 valittiin arrayn kooksi
	}                                                 // <> sisalla voisi lukea Tontti TAI <> nain olla
	
	// METODI LISAA TONTTI-OLION SAILIOON
	public void lisaa( final Tontti info ) {          // LISATAAN tieto yhdesta tontista
		kerrosSailio.add( info );
	}
    
    // METODI TULOSTAA SAILION KOKO SISALLON
    public void tulostaTietoSailio() {                         // Kirjassa sivu 321
        Iterator<Tontti> iter = kerrosSailio.iterator();       // Iteraattori oliolla voi kayda lapi sailion oliot
        System.out.println("");
        while( iter.hasNext() ) {                              // hasNext() palauttaa true, jos iteraatiossa viela olioita
            System.out.print(iter.next());                     // next() palauttaa iteraation seuraavan olion
        }
    }
}