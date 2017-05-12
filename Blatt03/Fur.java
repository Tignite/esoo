public class Fur implements Cloneable {
    public int length;

    public Fur(int length) {
        this.length = length;
    }

    public String toString() {
        return "Felllaenge: " + length;
    }

    // Das ist effektiv ein Deep Clone, da Fur nur eine
    // Instanzvariable hat und diese vom Typ int, also einem
    // primitiven Datentyp ist und nicht auf ein weiteres Objekt
    // verweist.
    public Fur clone() {
        try {
            return (Fur) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean equals(Fur f) {
        return (f instanceof Fur) &&
            length == f.length;
    }
}
