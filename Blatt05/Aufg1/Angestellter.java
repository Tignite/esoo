
public class Angestellter {
	
	private String vorname;
	private String nachname;
	private int alter;
	private int gehalt;
	
	public Angestellter(String vorname, String nachname, int alter, int gehalt){
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
		this.gehalt = gehalt;
	
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public int getAge() {
		return alter;
	}
	
	public int getGehalt() {
		return gehalt; 
	}
	
	public void increaseSalary(int bonus) { 
		this.gehalt += bonus;
	}
	
	public void getOlder(){
		this.alter++;
	}
	
	
	public void introduceEmployee() {
		System.out.println("Hello, my name is " + this.vorname + " " + this.nachname+ ".\n" + "I am " + this.alter + " years old and I earn " + this.gehalt + " $ monthly.");
	}
}
