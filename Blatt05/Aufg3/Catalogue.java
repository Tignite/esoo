import java.util.HashSet;
import java.util.Iterator;


public class Catalogue {
	
	private HashSet<Product> set = new HashSet<Product>();
	
	public void printMe(){
		Iterator iterator = set.iterator();
		String output = "Catalogue: \n";
	
		while(iterator.hasNext()){
			output += iterator.next().toString() + "\n";
		}
		System.out.print(output);
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
