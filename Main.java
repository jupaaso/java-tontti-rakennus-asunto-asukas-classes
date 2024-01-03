import java.io.*;
import java.util.Scanner;
import java.util.*;       // try-catch InputMismatchException vaatii taman
import java.util.ArrayList;
import java.util.Iterator;

public class Vt5main {
 
    public static final Scanner lukija = new Scanner( System.in );
    
    public static void main( String [] args ) {
       
        int valinta = 0;
        int valitseTulostus = 0;
        
        InsInfoSailio omaSailio = new InsInfoSailio();
        InsInfoSailioRivitalo riviSailio = new InsInfoSailioRivitalo();
        InsInfoSailioKerrostalo kerrosSailio = new InsInfoSailioKerrostalo();
        
		ArrayList<Asukas> asukkaat = new ArrayList<Asukas>();      // Asunnon asukkaat
        ArrayList<Asunto> asunnot = new ArrayList<Asunto>(10);       // Asunnot
        ArrayList<KerrostaloAsunto> kerrostaloAsunnot = new ArrayList<KerrostaloAsunto>();
        
        System.out.println("\n" + "Voit luoda yhden jokaista tonttityyppia,");
        System.out.println("ja myos tulostaa ne kaikki,");
        System.out.println("poistumatta ohjelmasta.");
        do {
            tulostaValikko();       // TULOSTA VALIKKO -METODI kutsu
            valinta = lueInt();     // LUE INT- METODI kutsu
            
            switch ( valinta ) {
                case 1:
                    kasitteleOmakotitalo(omaSailio, asukkaat);         // 1: Lisataan omakotitalo
                    break;
                case 2:
                    kasitteleRivitalo(riviSailio, asukkaat, asunnot);  // 2: Lisataan rivitalo
                    break;
                case 3:
                    kasitteleKerrostalo(kerrosSailio, asukkaat, kerrostaloAsunnot);                             // 3: Lisataan kerrostalo
                    break;
                case 4:
                    do {
                        tulostaTulostusValikko();                      // 4: Tulostetaan lisatty ...talo
                        valitseTulostus = lueInt();
     
                        switch ( valitseTulostus ) {
                            case 1:
                                omaSailio.tulostaTietoSailio();
                                break;
                            case 2:
                                riviSailio.tulostaTietoSailio();
                                //valitseTulostus++;
                                break;
                            case 3:
                                kerrosSailio.tulostaTietoSailio();
                                break;
                            case 0:
                                System.out.println("Palataan paavalikkoon");
                                break;
                            default: 
                                System.out.println("Vaara valinta. Yrita uudelleen.");
                                break;
                        }
                    } while (valitseTulostus != 0);
                case 0:
                    break;
                default: 
                    System.out.println("Vaara valinta. Yrita uudelleen.");
                    break;
            }
        }while (valinta != 0);
    }
    // OMAKOTITALO LISATAAN
    public static void kasitteleOmakotitalo(InsInfoSailio omaSailio, ArrayList<Asukas> asukkaat) {
        Omakotitalo omakotitalo;
		Rakennus rakennus;
		Tontti tontti;
        
        asukkaat = lueAsukkaat();                           // Luetaan asukkaat
        rakennus = lueRakennus(1);                          // Luetaan rakennus
        omakotitalo = lueOmakotitalo(rakennus, asukkaat);   // Luetaan omakotitalon = yhden asunnon tiedot
        tontti = lueTontti(omakotitalo);                    // Luetaan tontti

        // LISATAAN SAILIOON                                                
        omaSailio.lisaa(new Tontti( tontti.getTontinNimi(), tontti.getTontinSijainti(), tontti.getTontinPintaAla(), 
                     new Omakotitalo( rakennus.getRakennuksenAsuntojenLKM(), rakennus.getRakennuksenPintaAla(), 
                     rakennus.getRakennuksenKerrostenLKM(),
                     omakotitalo.getAsunnonPintaAla(), omakotitalo.getAsunnonHuoneidenLKM(), 
                     new Asukas( asukkaat ))));
		
        // TULOSTETAAN SAILION SISALTO
		//System.out.println("\n" + "TULOSTETAAN TIETOSAILIO:");
        //omaSailio.tulostaTietoSailio();
    } 
    // RIVITALO LISATAAN
    public static void kasitteleRivitalo(InsInfoSailioRivitalo riviSailio, ArrayList<Asukas> asukkaat, ArrayList<Asunto> asunnot) {
		Asunto asunto;
        Rivitalo rivitalo;
        Rakennus rakennus;
        Tontti tontti;
        
        rakennus = lueRakennus(2);                           // Luetaan rakennus: pinta-ala, asuntojen lukumaara
        
        for ( int asunnonNumero = 1; asunnonNumero <= rakennus.getRakennuksenAsuntojenLKM(); asunnonNumero++) {
            System.out.println("\n" +"Anna asunnon " + asunnonNumero + " tiedot:");
            asukkaat = lueAsukkaat();                       // Luetaan asukkaat
            asunto = lueYksiAsunto(asukkaat, asunnot); // Luetaan asunnon ala, huoneiden LKM, lisataan asunnot
            asunnot.add(asunto);
            //System.out.println("ASUNTO " + asunnonNumero + ": " + asunto.toString() + "\n");
        }
        rivitalo = new Rivitalo(rakennus.getRakennuksenAsuntojenLKM(), rakennus.getRakennuksenPintaAla(), 
                                rakennus.getRakennuksenKerrostenLKM(), asunnot);
                                       
        //System.out.println("   Luotiin rivitalorakennus + asunto + asukas: \n" + rivitalo.toString());
        //System.out.println("   Luotiin RIVITALO : \n" + rivitalo.toString());
        
        tontti = lueRakennuksenTontti(rivitalo);             // Luetaan tontti
        riviSailio.lisaa(new Tontti( tontti.getTontinNimi(), tontti.getTontinSijainti(), tontti.getTontinPintaAla(),
                       new Rivitalo( rakennus.getRakennuksenAsuntojenLKM(), rakennus.getRakennuksenPintaAla(),
                       rakennus.getRakennuksenKerrostenLKM(), asunnot )));
      
        // TULOSTETAAN SAILION KOKO SISALTO
		//System.out.println("\n" + "TULOSTETAAN TIETOSAILIO:");
        //riviSailio.tulostaTietoSailio();
    }
    
    // KERROSTALO LISATAAN
    public static void kasitteleKerrostalo(InsInfoSailioKerrostalo kerrosSailio, ArrayList<Asukas> asukkaat, 
                                           ArrayList<KerrostaloAsunto> kerrostaloAsunnot) {
        KerrostaloAsunto kerrostaloAsunto;
        Kerrostalo kerrostalo;
        Rakennus rakennus;
        Tontti tontti;
        int asuntojenLKM;
        int kerroksenAloittavaAsunto = 1;
        int asuntoLaskuri = 0;

        rakennus = lueRakennus(3);                    // Luetaan rakennus: pinta-ala, asuntojen lukumaara
        
        // LUETAAN KERROS KERRALLAAN
        for (int kerroksenNumero = 1; kerroksenNumero <= rakennus.getRakennuksenKerrostenLKM(); kerroksenNumero++) {
            //kerrostaloAsunnot.clear();
            System.out.print("\n" + "Anna kerroksen " + kerroksenNumero + " asuntojen lukumaara: ");
            asuntojenLKM = lukija.nextInt();
            lukija.nextLine(); // Lukijan tyhjennys
            //asunnot.clear();
            
            // LUETAAN KERROKSEN ASUNNOT
            for ( int asunnonNumero = kerroksenAloittavaAsunto; asunnonNumero <= asuntojenLKM+kerroksenAloittavaAsunto-1; asunnonNumero++) {  
                if (asunnonNumero == kerroksenAloittavaAsunto) {
                    asuntoLaskuri = 0;
                }
                System.out.println("");
                System.out.println("Anna asunnon " + asunnonNumero + " asukkaat:");
                asukkaat = lueAsukkaat();                       // Luetaan asukkaat
                
                // Luetaan yksi asunto kerrostaloon
                kerrostaloAsunto = lueYksiKerrostaloAsunto(kerroksenNumero, asunnonNumero, asukkaat); 
          
                kerrostaloAsunnot.add(kerrostaloAsunto);         // Listaan asunto asunnonumeron osoittamaan paikkaan
                asuntoLaskuri++;
            }

            kerroksenAloittavaAsunto = kerroksenAloittavaAsunto + asuntojenLKM;   // Seuraavan kerroksen aloitusnumero
        }
        
        kerrostalo = new Kerrostalo( rakennus.getRakennuksenAsuntojenLKM(), rakennus.getRakennuksenPintaAla(),
                       rakennus.getRakennuksenKerrostenLKM(), kerrostaloAsunnot);
                       
        //System.out.println("   Luotiin KERROSTALO : \n" + kerrostalo.toString());
        tontti = lueRakennuksenTontti(kerrostalo);                // Luetaan tontti
       
        kerrosSailio.lisaa(new Tontti( tontti.getTontinNimi(), tontti.getTontinSijainti(), tontti.getTontinPintaAla(),
                       new Kerrostalo( rakennus.getRakennuksenAsuntojenLKM(), rakennus.getRakennuksenPintaAla(),
                       rakennus.getRakennuksenKerrostenLKM(), kerrostaloAsunnot )));
                       
        // TULOSTETAAN SAILION KOKO SISALTO
		//System.out.println("\n" + "TULOSTETAAN TIETOSAILIO:");
        //kerrosSailio.tulostaTietoSailio();
    }
   
    // LUE ASUKKAAT -METODI
    public static ArrayList<Asukas> lueAsukkaat() {
        String asukkaanNimi;
		String asukkaanSyntymaAika;
        Asukas asukas;
        ArrayList<Asukas> asukkaat = new ArrayList<Asukas>();
        String isJatketaanko;
       
        Scanner lukija = new Scanner( System.in );
        System.out.println();
        asukkaat.clear();            
        // lukija.nextLine();          // Lukijan tyhjennys, mutta jaa tahan jumiin ja vaatii enterin lyonnin
        do {
            System.out.print("Anna asukkaan nimi > ");
            asukkaanNimi = lukija.nextLine();
            System.out.print("Anna asukkaan syntymaaika > ");
            asukkaanSyntymaAika = lukija.nextLine();
			asukas = new Asukas(asukkaanNimi, asukkaanSyntymaAika, asukkaat);
            System.out.print("Anna seuraava asukas ( k tai e ) > ");
            isJatketaanko = lukija.nextLine();
		} while (isJatketaanko.charAt(0) == 'k' || isJatketaanko.charAt(0) == 'K');
          
		//System.out.println("Asunnon asukkaat: \n " + asukkaat);
       
       return asukkaat;
    }
    
    // LUE RAKENNUS -METODI
    public static Rakennus lueRakennus(int rakennuksenTyyppi) {    // 1=omakotitalo, 2=rivitalo, 3=kerrostalo
        double rakennuksenPintaAla;
		int rakennuksenAsuntojenLKM;
        int rakennuksenKerrostenLKM;
        Rakennus rakennus;
        
        //System.out.println("Rakennuksen tyyppi on: " + rakennuksenTyyppi);
        
        do {
			System.out.print("Anna rakennuksen BRUTTO pinta-ala (m2) > ");
			rakennuksenPintaAla = lukija.nextDouble();
			if (rakennuksenPintaAla <= 0) 
				System.out.println("Pinta-ala ei voi olla negatiivinen");
        } while (rakennuksenPintaAla <= 0);
        
        if (rakennuksenTyyppi == 3 ) {      // Kerrostalossa vain useampia kerroksia
            System.out.print("Anna rakennuksen kerrosten lukumaara: ");
            rakennuksenKerrostenLKM = lukija.nextInt(); 
            lukija.nextLine(); // Lukijan tyhjennys
        } 
        else {
            rakennuksenKerrostenLKM = 1;
        }
        if (rakennuksenTyyppi != 1) {       // Omakotitalossa vain yksi asunto
            System.out.print("Anna rakennuksen asuntojen lukumaara: ");
            rakennuksenAsuntojenLKM = lukija.nextInt(); 
            lukija.nextLine(); // Lukijan tyhjennys
        }
        else {
            rakennuksenAsuntojenLKM = 1;
        }
		rakennus = new Rakennus(rakennuksenAsuntojenLKM, rakennuksenPintaAla, rakennuksenKerrostenLKM); 
        
		//System.out.println("   Luotiin rakennus: \n" + rakennus.toString());    
        
        return rakennus;
    }
    
    // LUE OMAKOTITALO -METODI
    public static Omakotitalo lueOmakotitalo(Rakennus rakennus, ArrayList<Asukas> asukkaat) {
        double asunnonPintaAla;
        int asunnonHuoneidenLKM;
 		Omakotitalo omakotitalo;
    
        System.out.print("Anna asunnon ala (m2) > ");
        asunnonPintaAla = lueDouble();
        System.out.print("Anna asunnon huoneiden lukumaara > ");
        asunnonHuoneidenLKM = lueInt();
        
        omakotitalo = new Omakotitalo(rakennus.getRakennuksenAsuntojenLKM(), rakennus.getRakennuksenPintaAla(), 
                                      rakennus.getRakennuksenKerrostenLKM(),
                                      asunnonPintaAla, asunnonHuoneidenLKM, new Asukas( asukkaat ));
                                       
        //System.out.println("   Luotiin omakotirakennus + asunto + asukas: \n" + omakotitalo.toString());
      
        return omakotitalo;
    }
    
    // LUE RIVITALON ASUNTO -METODI
    public static Asunto lueYksiAsunto(ArrayList<Asukas> asukkaat, ArrayList<Asunto> asunnot) {
        double asunnonPintaAla;
        int asunnonHuoneidenLKM;
        Asunto asunto;
    
        System.out.print("Anna asunnon ala (m2) > ");
        asunnonPintaAla = lueDouble();
        System.out.print("Anna asunnon huoneiden lukumaara > ");
        asunnonHuoneidenLKM = lueInt();
       
        asunto = new Asunto(asunnonPintaAla, asunnonHuoneidenLKM, new Asukas( asukkaat )); 
     
        //System.out.println("   Luotiin YKSI Asunto + asukkaat: \n" + asunto.toString());
     
        return asunto;
    }
    
    // LUE KERROSTALON ASUNTO -METODI
    public static KerrostaloAsunto lueYksiKerrostaloAsunto(int asunnonKerros, int asunnonNumero, ArrayList<Asukas> asukkaat) {
        double asunnonPintaAla;
        int asunnonHuoneidenLKM;
        KerrostaloAsunto kerrostaloAsunto;
    
        System.out.print("Anna asunnon ala (m2) > ");
        asunnonPintaAla = lueDouble();
        System.out.print("Anna asunnon huoneiden lukumaara > ");
        asunnonHuoneidenLKM = lueInt();
        
        kerrostaloAsunto = new KerrostaloAsunto(asunnonKerros, asunnonNumero, asunnonPintaAla, asunnonHuoneidenLKM, new Asukas( asukkaat )); 
     
        //System.out.println("   Luotiin YKSI KT-Asunto + asukkaat: \n" + kerrostaloAsunto.toString());
     
        return kerrostaloAsunto;
    }
    
    // LUE OMAKOTITONTTI -METODI
    public static Tontti lueTontti(Omakotitalo omakotitalo) {
        String tontinNimi;
		String tontinSijainti;  // osoitetta tarkoittaa
		double tontinPintaAla;
		Tontti tontti;
        
        lukija.nextLine();
        System.out.print("Anna tontin nimi > ");
        tontinNimi = lukija.nextLine();
        System.out.print("Anna tontin osoite > ");
        tontinSijainti = lukija.nextLine();

        do {
			System.out.print("Anna tontin pinta-ala (m2) > ");
			tontinPintaAla = lukija.nextDouble();
            lukija.nextLine();
			if (tontinPintaAla <= 0)
				System.out.println("Pinta-ala ei voi olla negatiivinen");
		} while (tontinPintaAla <= 0);
        tontti = new Tontti(tontinNimi, tontinSijainti, tontinPintaAla, omakotitalo );  
        
		//System.out.println("   Luotiin tontti: \n" + tontti.toString() );

        return tontti;
    }
    
    // LUE RAKENNUKSEN TONTTI -METODI
    public static Tontti lueRakennuksenTontti(Rakennus rakennus) {
        String tontinNimi;
		String tontinSijainti;  // osoitetta tarkoittaa
		double tontinPintaAla;
		Tontti tontti;
        
        System.out.println("");
        System.out.print("Anna tontin nimi > ");
        tontinNimi = lukija.nextLine();
        System.out.print("Anna tontin osoite > ");
        tontinSijainti = lukija.nextLine();

        do {
			System.out.print("Anna tontin pinta-ala (m2) > ");
			tontinPintaAla = lukija.nextDouble();
			if (tontinPintaAla <= 0)
				System.out.println("Pinta-ala ei voi olla negatiivinen");
		} while (tontinPintaAla <= 0);
        
        tontti = new Tontti(tontinNimi, tontinSijainti, tontinPintaAla, rakennus );  

		//System.out.println("   Luotiin tontti: \n" + tontti.toString() );

        return tontti;
    }
    
    // TEHTAVAN VALIKKO - METODI
	public static void tulostaValikko() {
        System.out.println("\n Lisaa seuraava tontti, sen rakennus, ja asukkaiden tiedot");
        System.out.println(" 1) Lisaa omakotitalotontti");
        System.out.println(" 2) Lisaa rivitalotontti");
        System.out.println(" 3) Lisaa kerrostalotontti");
        System.out.println(" 4) Tulostusvalikko: syottamillesi tiedoille");
        System.out.println(" 0) Lopeta");
        System.out.print("\nValintasi > ");
    }
    
    // TULOSTA VALIKKO - METODI
	public static void tulostaTulostusValikko() {
        System.out.println("\n Valitse tulostettava talo:");
        System.out.println(" 1) Tulosta omakotitalon tiedot");
        System.out.println(" 2) Tulosta rivitalon tiedot");
        System.out.println(" 3) Tulosta kerrostalon tiedot");
        System.out.println(" 0) Lopeta");
        System.out.print("\nValintasi > ");
    }
        
    // INTEGERIN LUKU -METODI
    public static int lueInt() {
        Scanner lukija = new Scanner(System.in);
        boolean ok = false;
        int luku = 0;
      
        do {
  
            try {
                luku = lukija.nextInt();
                lukija.nextLine();                     // Lukijan tyhjennys
                ok = true;
            }catch( InputMismatchException ime ){
                lukija.nextLine();                     // Lukijan tyhjennys
                System.out.print("Virhe, yrita uudelleen > ");
            }
        }while( !ok );
        
        return luku;
    }
    
    // DOUBLEN LUKU -METODI
    public static double lueDouble() {
        Scanner lukija = new Scanner(System.in);
        boolean ok = false;
        double luku = 0.0;
        
        do {
            
            try {
                luku = lukija.nextDouble();
                lukija.nextLine();                    // Lukijan tyhjennys
                ok = true;
            } catch( InputMismatchException ime ) {
                // Tanne tultaessa tapahtui InputMismatchException-tyypin virhe
                lukija.nextLine();                    // Lukijan tyhjennys
                System.out.print("Virhe, yrita uudelleen > ");
            }
        } while( !ok );
        
        return luku;
    }
}