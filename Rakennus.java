
public class Rakennus {

    private int rakennuksenAsuntojenLKM;
    private double rakennuksenPintaAla;
    private int rakennuksenKerrostenLKM;
  	
    public Rakennus(int asuntojenLKM, double ala, int kerroksienLKM) {    // KONSTRUKTORI
        this.rakennuksenAsuntojenLKM = asuntojenLKM;
        this.rakennuksenPintaAla = ala;
        this.rakennuksenKerrostenLKM = kerroksienLKM;
	}
    public void setRakennuksenAsuntojenLKM(int asuntojenLKM) {      // SETTERIT
        rakennuksenAsuntojenLKM = asuntojenLKM;
    }
	public void setRakennuksenPintaAla(double ala) {                 
		rakennuksenPintaAla = ala;
	}
    public void setRakennuksenKerrostenLKM(int kerroksienLKM) {
        rakennuksenKerrostenLKM = kerroksienLKM;
    }

    public int getRakennuksenAsuntojenLKM() {                       // GETTERIT
        return rakennuksenAsuntojenLKM;
    }
    public double getRakennuksenPintaAla() {                        
		return rakennuksenPintaAla;
	}
    public int getRakennuksenKerrostenLKM() {
        return rakennuksenKerrostenLKM;
	}

	public String toString() {
        return "Rakennuksen asuntojen lukumaara: " + rakennuksenAsuntojenLKM + "\n" + 
               ", Rakennuksen pinta-ala: " + rakennuksenPintaAla + " m2.\n" +
               ", Rakennuksen kerrosten lukumaara: " + rakennuksenKerrostenLKM + "\n";
    }
}