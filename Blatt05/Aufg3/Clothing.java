
public class Clothing extends Product {

    public String material;
    public int size;

    public Clothing(String name, String description, double price, String material, int size){
        super(name, description, price);
        this.material = material;
        this.size = size;
    }

    //Teil b.)
    public String toString() {
        return name + " - " + description + " - "+ price
            + " EUR"+ " - " + material + " - " +"size: "+ size;
    }
}
