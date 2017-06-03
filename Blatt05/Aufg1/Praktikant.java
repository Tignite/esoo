// Teil b.)
public class Praktikant extends Angestellter {

    public Praktikant(String vorname, String nachname, int  alter, int  gehalt){
        super(vorname, nachname, alter, 400); //calls constructor of superclass (Angestellter)
    }

    public void increaseSalary(int bonus){
        System.out.println("ERROR: Intern Salaries can not exceed 400$ limit!");
    }
}
