import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {
	private ArrayList<Konto> konten = new ArrayList<Konto>();
	private ArrayList<Integer> kontoNummern = new ArrayList<Integer>();
	private ArrayList<String> jahresProtokoll = new ArrayList<String>();
	private String bankName;
	private long ruecklage;
	private long ruecklageJahresanfang;
	private long anlagen;

	public Bank(){
		this("BlankBank");
	}
	public Bank(String bankName){
		this(bankName, 10000000);
	}
	public Bank(String bankName, long ruecklage){
		this.bankName = bankName;
		this.ruecklage = ruecklage;
		this.ruecklageJahresanfang = ruecklage;
	}
	
	public void kontoHinzufuegen(Object obj){
		if(obj instanceof Konto){
			Konto ref = (Konto) obj;
			int kontoNummer = ref.getKontoNummer();
			boolean create = false;
			for(int x: kontoNummern){
				if(x == kontoNummer){
					create = true;
				}
			}
			if(create){
				String name = ref.getName();
				String vorname = ref.getVorname();
				long kontoStand = ref.getKontoStand();
				Object buffer = kontoErstellen(name, vorname);
				((Konto) buffer).einzahlen(kontoStand);
				kontoNummer = ((Konto) buffer).getKontoNummer();
			}
			else{
				konten.add(ref);
				bilanz(ref.getKontoStand(), "Konto hinzugefügt");
			}
			kontoNummern.add(kontoNummer);
		}
	}
	
	public Object kontoErstellen(String name, String vorname){
		int kontoNummer = erstelleKontoNummer();
		return kontoErstellen(name, vorname, kontoNummer);
	}
	
	public Object kontoErstellen(String name, String vorname, int kontoNummer){
		Konto neuesKonto = new Konto(name, vorname, kontoNummer);
		kontoHinzufuegen(neuesKonto);
		return neuesKonto;
	}
	
	public void kontoEntfernen(Object obj){
		if(obj instanceof Konto){
			Konto ref = (Konto) obj;
			int index = kontoNummern.indexOf(ref.getKontoNummer());
			if(index != -1) {
				kontoNummern.remove(index);
			}
			else {
				System.out.println("Konto nicht gefunden\n");
			}
			bilanz( - ref.getKontoStand(), "Kontoauflösung");
			index = konten.indexOf(ref);
			if(index != -1) konten.remove(index);
			else System.out.println("Konto nicht gefunden\n");
		}
	}
	
	public void kontoTransferieren(Object bank, Object konto){
		if((konto instanceof Konto) && (bank instanceof Bank)){
			((Bank) bank).kontoHinzufuegen(konto);
			kontoEntfernen(konto);
			System.out.println("Konto " + ((Konto) konto).getKontoNummer() + " erfolgreich zu " + ((Bank) bank).getBankName() + " transferiert.\n");
		}
	}

	public void kontoTransferieren(Object bank, long kontoNummer){
		if(bank instanceof Bank){
			Search:
			for(Konto x: konten){
				if(kontoNummer == x.getKontoNummer()) {
					((Bank) bank).kontoHinzufuegen(x);
					kontoEntfernen(x);
					System.out.println("Konto " + kontoNummer + " erfolgreich zu " + ((Bank) bank).getBankName() + " transferiert.\n");
					break Search;
				}
			}
		}
	}
	
	public long kapitalErmitteln(){
		long kapital = 0;
		for(Konto k: konten){
			kapital += k.getKontoStand();
		}
		this.anlagen = kapital;
		return kapital;
	}
	
	public double invest(){
		if(ruecklage > 0){
			kapitalErmitteln();
			long maxInvest = anlagen - (ruecklage / 2);
			if(maxInvest > 0){
				double rand = ThreadLocalRandom.current().nextDouble(0.0, 50.000001);
				rand = 1.0 + ((rand - 30.0) / 100.0);
				double ertrag = (anlagen * rand) - anlagen;
				bilanz(ertrag, "Investments");
				ruecklage += ertrag;
				if(ruecklage < 0) {
					bilanz(ruecklage, "Bankrott, Restschulden siehe links");
				}
				return rand;
			}
		}
		return 0;
	}
	private void bilanz(long betrag, String beschreibung){
		StringBuilder sb = new StringBuilder();
		if(betrag > 0) sb.append("+");
		sb.append(betrag + " - " + beschreibung);
		jahresProtokoll.add(sb.toString());
	}
	private void bilanz(double betrag, String beschreibung){
		StringBuilder sb = new StringBuilder();
		if(betrag > 0) sb.append("+");
		sb.append(betrag + " - " + beschreibung);
		jahresProtokoll.add(sb.toString());
	}
	
	public void jahresBericht(){
		System.out.println("Jahresbericht der " + bankName + "\n");
		for(String x: jahresProtokoll){
			System.out.println(x);
		}
		System.out.println("\nGesamt Rücklagen Differenz (total): " + (ruecklage - ruecklageJahresanfang));
		double prozent = ( ((double) ruecklageJahresanfang) / ((double) ruecklage) ) - 1;
		System.out.println("Gesamt Rücklagen Differenz (prozentual): " + (100 * prozent) + "\n\n");
		jahresProtokoll.clear();
	}
	
	
	//Hilfsmethoden
	
	public void einzahlen(int kontoNummer, long betrag){
		for(Konto x: konten){
			if(x.getKontoNummer() == kontoNummer){
				x.einzahlen(betrag);
				bilanz(betrag, "Einzahlung");
			}
		}
	}
	public void einzahlen(Object obj, long betrag){
		if(obj instanceof Konto){
			Konto ref = (Konto) obj;
			einzahlen(ref.getKontoNummer(), betrag);
		}
	}
	public void auszahlen(int kontoNummer, long betrag){
		for(Konto ref: konten){
			if(ref.getKontoNummer() == kontoNummer){
				ref.auszahlen(betrag);
				bilanz(-betrag, "Auszahlung");
			}
		}
	}
	public void auszahlen(Object obj, long betrag){
		if(obj instanceof Konto){
			Konto ref = (Konto) obj;
			auszahlen(ref.getKontoNummer(), betrag);
		}
	}
	private int erstelleKontoNummer(){
		int rand = ThreadLocalRandom.current().nextInt(100000000, 999999999);
		for(long x: kontoNummern){
			if(x == rand) return erstelleKontoNummer();
		}
		return rand;
	}
	
	
	public String getBankName(){
		return bankName;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(bankName + "\n");
		sb.append("Gesamtanlagen: " + kapitalErmitteln() + " [EUR]\n");
		sb.append("Gesamtrücklagen: " + ruecklage + " [EUR]\n\n");
		for(Konto x: konten){
			sb.append(x + "\n\n");
		}
		return sb.toString();
	}
}
