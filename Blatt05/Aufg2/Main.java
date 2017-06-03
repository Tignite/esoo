
public class Main {

    public static void main(String[] args) {

        Auto auto1 = new Lastwagen();
        System.out.println(auto1.reifen); // Ausgabe 1
        System.out.println(((Lastwagen) auto1).reifen); //Ausgabe 2
        System.out.println(auto1.getReifen()); //Ausgabe 3
        System.out.println(((Lastwagen) auto1).getReifen()); //Ausgabe 4
    }

}

/*Teil a.)
 *
 * Ausgabe 1 : 4, denn der Statische Typ von auto1 ist "Auto", der
 * dynamische Typ "Lastwagen". Bei "reifen" handelt es sich um ein
 * Instanzfeld; es kommt in der Lastwagen Klasse also zum Verdecken
 * des Feldes aus der Auto Klasse. Beim Verdecken von Feldern bestimmt
 * der statische Typ den Wert, hier also 4.
 *
 * Ausgabe 2 : 8, denn durch Casten des statischen Typs zu
 * "Lastwagen", wird die Anzahl der Räder 8 ausgegeben; wie bei
 * Ausgabe 1 bestimmt der statische Typ den Wert.
 *
 * Ausgabe 3 : 8, denn Methoden-Aufrufe hängen vom dynamischen Typ des
 * Objekts ab (der statische Typ bestimmt hier nur welche Methoden
 * (+Signaturen) sichtbar sind) und die Methode wurde von der Klasse
 * Lastwagen überschrieben daher wird die getReifen Methode der Klasse
 * "Lastwagen" ausgefürht und 8 ausgegeben.
 *
 * Ausgabe 4: 8 das Casten des statischen Typs ändert nichts an der
 * Ausfürhung und Ausgabe der Methode, da wie oben erwähnt der
 * statische Typ zwar die sichtbaren Methoden+Signaturen festlegt, die
 * letztlich ausgeführte Implementierung aber die des dynamischen Typs
 * ist. Somit wird wieder (wie auch schon bei 3) die Implementierung
 * der Lastwagen Klasse ausgeführt.
 */

/*Teil b.)
 * Ausgabe:
 * 4
 * 8
 *
 * 4 --> da die Methode in Klasse Lastwagen nicht überschrieben wird,
 * wird die vererbte Methode der Klasse Auto ausgeführt.
 *
 * 4 --> das Casten des statishen Typs ändert nichts an der Ausführung und Ausgabe der Methode.
 */

/*Teil c.)
 * Fehlermeldung...
 */
