
public class Product {

    protected String name;
    protected String description;
    protected double price; // Netto

    public Product(String name, String desc, double price) {
        this.name = name;
        this.description = desc;
        this.price = price;
    }

    protected final double getPriceWithTax() {
        return price * 1.19;
    }

    public String toString() {
        return name + " - " + description + " - " + price + " EUR";
    }
}
