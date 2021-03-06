class Aufgabe3
{
    public static void main(String args[])
    {
        Student student = new Student();

        Cauliflower essen1 = new Cauliflower();
        student.eat(essen1); // I don't like Blumenkohl an Gorgonzolasoße
	// Statischer Typ und dynamischer Typ von essen1 sind hier
	// gleich. Es wird die spezifischste Methode mit Signatur
	// (Cauliflower) benutzt.

        Spaghetti essen2 = new Spaghetti();
        student.eat(essen2); // I like Spaghetti Bologneser Art
	// Statischer Typ und dynamischer Typ von essen2 sind hier
	// gleich.  Es wird die spezifischste .eat() Methode
	// aufgerufen; diese hat die Signatur (Food), da keine
	// spezifischere Signatur (Spaghetti) existiert.

        Food essen = new Cauliflower();
        student.eat(essen); // I like Blumenkohl an Gorgonzolasoße
	// Statischer Typ und dynamischer Typ von essen sind hier
	// nicht gleich. Somit bestimmt der Statische Typ was
	// "sichtbar" ist. Somit wird hier die Student.eat(Food food)
	// Methode aufgerufen.
    }
}
