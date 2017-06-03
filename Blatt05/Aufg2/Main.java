
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
 * Ausgabe 1 : 1 , da auto1 vom statischen Typ "Auto" ist, wird enstprechend die Anzahl der Reifen 4 ausgegeben.
 *
 * Ausgabe 2 : 8  durch Casten des statischen Typs zu "Lastwagen", wird die Anzahl der Räder 8 ausgegeben.
 *
 * Ausgabe 3 : 8  Methoden-Aufrufe hängen vom dynamischen Typ des Objekts ab und die Methode wurde von der Klasse Lastwagen überschrieben daher wird die getReifen Methode der Klasse "Lastwaren" ausgefürht und 8 ausgegeben.
 *
 * Ausgabe 4: 8  das Casten des statischen Typs ändert nichts an der Ausfürhung und Ausgabe der Methode.
 */

/*Teil b.)
 * Ausgabe:
 * 4
 * 8
 * 4 --> da die Methode in Klasse Lastwagen nicht überschrieben wird, wird die vererbte Methode der Klasse Auto ausgeführt.
 * 4 --> das Casten des statishen Typs ändert nichts an der Ausführung und Ausgabe der Methode.
 */

/*Teil c.)
 * Fehlermeldung...
 */
