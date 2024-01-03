import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class KerrostaloAsunto {

    private int asunnonKerros;
    private int asunnonNumero;
    private double asunnonPintaAla;
    private int asunnonHuoneidenLKM;
    private Asukas asukas;           
    private ArrayList<Asukas> asukkaat;
    private ArrayList<KerrostaloAsunto> kerrostaloAsunnot;
	
    public KerrostaloAsunto(int kerros, int asunnonNRO, double asunnonAla, int huoneidenLKM, Asukas asukas) { // ArrayList<Asukas> asukkaat) { //, ArrayList<Asunto> asunnot) {  // KONSTRUKTORI
		this.asunnonKerros = kerros;
        this.asunnonNumero = asunnonNRO;
        this.asunnonPintaAla = asunnonAla;
		this.asunnonHuoneidenLKM = huoneidenLKM;
 		this.asukas = asukas;
	}
    public KerrostaloAsunto(ArrayList<KerrostaloAsunto> kerrostaloAsunnot) {
        this.kerrostaloAsunnot = kerrostaloAsunnot;
        System.out.print("Asunto kerrostaloAsunnot konstruktorissa: \n" + kerrostaloAsunnot + "\n");  // TOIMII HYVIN
    }
    public void setAsunnonKerros(int kerros) {              // SETTERIT
        asunnonKerros = kerros;
    }
	public void setAsunnonNumero(int asunnonNRO) {           
        asunnonNumero = asunnonNRO;
    }
    public void setAsunnonPintaAla(double asunnonAla) {      
		asunnonPintaAla = asunnonAla;
	}
    public void setAsunnonHuoneidenLKM(int huoneidenLKM) {
        asunnonHuoneidenLKM = huoneidenLKM;
    }
    public int getAsunnonKerros() {                         // GETTERIT
        return asunnonKerros;
    }
    public int getAsunnonNumero() {
        return asunnonNumero;
    }
	public double getAsunnonPintaAla() {                     
		return asunnonPintaAla;
	}
    public int getAsunnonHuoneidenLKM() {
        return asunnonHuoneidenLKM;
    }
    
    // TULOSTETAAN ASUNNOT MERKKIJONONA  EI TAIDA TARVIA
    public String getKerrostaloAsunnot() {
        String mjono = "";
        Iterator<KerrostaloAsunto> it = this.kerrostaloAsunnot.iterator();
        while(it.hasNext()) {
            mjono = mjono + it.next().toString();
        }
        return mjono;
    } 
     
	public String toString() {
        return "KERROS: " + asunnonKerros +
               ", Asunnon NRO: " + asunnonNumero +
               ", Asunnon pinta-ala: " + asunnonPintaAla + " m2, " +
               "Asunnon huoneiden lukumaara: " + asunnonHuoneidenLKM + ".\n" +
                asukas.getAsukkaat() + "\n";
    }
}