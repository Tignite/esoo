import java.util.ArrayList;

public class Konto {
	private final String name;
	private final String vorname;
	private final int kontoNummer;
	private long kontoStand;
	private ArrayList<Long> kontoAuszug = new ArrayList<Long>();
	

	public Konto(String name, String vorname) {
		this(name, vorname, 111111111, 0);
	} 
	public Konto(String name, String vorname, int kontoNummer) {
		this(name, vorname, kontoNummer, 0);
	} 
	public Konto(String name, String vorname, int kontoNummer, long kontoStand) {
		this.name = name;
		this.vorname = vorname;
		this.kontoNummer = kontoNummer;
		this.kontoStand = kontoStand;
	} 
	
	public long einzahlen(long betrag) {
		this.kontoStand += betrag;
		kontoAuszug.add(betrag);
		return this.kontoStand;
	} 
	public long auszahlen(long  betrag){
		if(betrag > this.kontoStand){
			System.out.println("Ihr aktuelles Guthaben reicht nicht aus.\nEs können maximal " + this.kontoStand + " [EUR] abgehoben werden.");
		}
		else{
			this.kontoStand -= betrag;
			kontoAuszug.add(-betrag);
		}
		return this.kontoStand;
	}
	
	public String erstelleAuszug() {
		StringBuilder sb = new StringBuilder();
		for(long i: kontoAuszug) {
			if(i > 0) sb.append("+");
			sb.append(i + " [EUR]\n");
		}
		kontoAuszug.clear();
		return sb.toString();
	}
	
	public String getName(){
		return this.name;
	}
	public String getVorname(){
		return this.vorname;
	}
	public int getKontoNummer(){
		return this.kontoNummer;
	}
	public long getKontoStand(){
		return this.kontoStand;
	}
	public String toString() {
		return name + ", " + vorname + "\nKontonummer: " + kontoNummer + "\nKontostand: " + kontoStand + " [EUR]" ;
	}
}