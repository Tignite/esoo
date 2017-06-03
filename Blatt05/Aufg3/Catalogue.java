import java.util.HashSet;
import java.util.Iterator;

public class Catalogue {

    private HashSet<Product> set = new HashSet<Product>();

    public void printMe() {
        System.out.println("Catalogue:");

        for (Product p : set) {
            System.out.printf("%s, Preis inkl. MWST: %.2f\n", p, p.getPriceWithTax());
        }
    }

    public void add(Product p){
        set.add(p);
    }

    public static void main (String [] args) {

        Catalogue cat = new Catalogue();
        Product p1 = new Product("Papier", "A4", 2.52);
        Clothing c1 = new Clothing ("Hemd", "Herren-Hemd", 33.61, "Baumwolle", 48);

        cat.add(p1);
        cat.add(c1);

        cat.printMe();
    }
}
