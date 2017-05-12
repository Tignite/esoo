public class Sheep implements Cloneable {
    public String name;
    public Fur fur;

    public Sheep(String name, Fur fur) {
        this.name = name;
        this.fur = fur;
    }

    public void shear() {
        fur.length = 0;
    }

    public String toString() {
        return "Name: " + name + ", " + fur.toString();
    }

    // Laut Java Dokumentation sollte eigentlich x.clone() != x gelten,
    // was mit dieser Implementierung aber nicht der Fall ist!
    // http://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#clone--
    public Sheep clone() {
        return this;
    }

    public Sheep shallowclone() {
        try {
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            return null;
        }
    }

    public Sheep deepclone() {
        Sheep s = this.shallowclone();
        s.fur = this.fur.clone();

        // WICHTIG: s.name = String (this.name), also das Kopieren des
        // Namens ist nicht erforderlich, da Strings unveränderlich
        // sind. Wird später eines der Schaafe umbenannt, so wird ja
        // nicht die String Instanz die .name referenziert verändert,
        // sondern dem Feld .name wird die Adresse des Strings, der
        // den neuen Namen enthält, zugewiesen. Die ursprüngliche
        // String Instanz (im anderen Schaaf verwendet) bleibt
        // hingegen unverändert. Damit ist beim Clonen kein Kopieren
        // von Feldern des Typs String nötig.

        //s.name = String(this.name);

        return s;
    }

    // Vergleicht zwei Schaafe rekursiv anhand der Werte ihrer
    // Instanzfelder und nicht anhand der Gleicheit von Referenzen
    // http://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-

    // Hier könnte(sollte?) wohl eigentlich der Typ Object als
    // Argument stehen (was soll sonst der test 's instanceof Sheep'?!)
    // aber dan gibt es Warnungen wegen nicht implemnetierter Hash
    // Funktion...
    public boolean equals (Sheep s) {
        return (s instanceof Sheep)
            && name.equals(s.name)
            // Setze equals recursiv auf den Feldern von Sheep fort ...
            && fur.equals(s.fur);
    }
}
