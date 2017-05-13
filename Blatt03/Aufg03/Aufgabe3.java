class Aufgabe3 {
    public static void main (String[] args) {
        C1 a = new C2();
        C2 b = new C2();

        // Stelle 1

        ((C2) a).f1();                     // "C2::f1"
        ((C1) b).f1();                     // "C1::f1" Cast auf Elternklasse möglich
        System.out.println(a.s);           // "1"
        b.f1();                            // "C1::f1"
        b.f2();                            // "C1::f1" vererbte Methode von C1
        b.f3();                            // "C2::f3"

        // Kompilierfehler, f3() ist nur für die Unterklasse C2 definiert
        // C1 c = new C1(); c.f3();

        // Laufzeitfehler, da c Instanz der Klasse C1 und ein Cast auf
        // C2 (eine Unterklasse von C1) nicht möglich ist
        C1 c = new C1(); ((C2) c).f1();
    }
}
