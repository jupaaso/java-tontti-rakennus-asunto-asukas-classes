
public class Tontti {

    private String tontinNimi;
    private String tontinSijainti;
    private double tontinPintaAla;
	
	private Rakennus rakennus;
    
    public Tontti(String nimi, String sijainti, double ala, Rakennus rakennus) {   // KONSTRUKTORI JOTA EI KAYTETA
        this.tontinNimi = nimi;
        this.tontinSijainti = sijainti;
        this.tontinPintaAla = ala;
		this.rakennus = rakennus;
    }
	
    public Tontti(String nimi, String sijainti, double ala, Omakotitalo omakotitalo) {  // KONSTRUKTORI
        this.tontinNimi = nimi;
        this.tontinSijainti = sijainti;
        this.tontinPintaAla = ala;
		this.rakennus = omakotitalo;
    }
    public void setTontinNimi(String nimi) {
        tontinNimi = nimi;
    }
    public void setTontinSijainti(String sijainti) {
        tontinSijainti = sijainti;
    }
    public void setTontinPintaAla(double ala) {
        tontinPintaAla = ala;
    }
    public String getTontinNimi() {
        return tontinNimi;
    }
    public String getTontinSijainti() {
        return tontinSijainti;
    }
    public double getTontinPintaAla() {
        return tontinPintaAla;
    }
	public void setRakennusTontille(Rakennus rakennus) {       // Rakennus tontille
		this.rakennus = rakennus;
	}
	public Rakennus getRakennusTontilta() {                  // Rakennus tontilta
		return this.rakennus;                           
	}
	public String toString() {
 		return "Tontin nimi " + tontinNimi + ",\n" +
		       "Tontin osoite " + tontinSijainti + ",\n" + 
			   "Tontin pinta-ala " + tontinPintaAla + " m2. \n" +
			   rakennus;
	}
}
