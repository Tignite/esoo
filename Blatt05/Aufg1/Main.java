
public class Main {
	
	public static void main(String[] args) {
		
		Angestellter employee_1 = new Angestellter("Will", "Smith", 43, 1500 );
		Angestellter employee_2 = new Angestellter("Jimmy", "Fallon", 26, 2000 );
		
		employee_1.increaseSalary( 400 );
		employee_1.getOlder();
		employee_2.increaseSalary( 500 );
		employee_2.getOlder();
		
		
		employee_1.introduceEmployee();
		employee_2.introduceEmployee();
		
		Praktikant intern_1 = new Praktikant("Jerry", "Seinfeld", 17, 0);
		
		intern_1.increaseSalary(1200);
		
		
		intern_1.introduceEmployee();
		
	}

}
