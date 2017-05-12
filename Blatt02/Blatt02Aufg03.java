import java.util.LinkedList;

// Aufgabe 3a
class Car {
    private String licensePlate = "Default Plate";
    private String owner = "Default Owner";
    private String address = "Default Address";
    private LinkedList<Delict> delicts = new LinkedList<Delict>();
    private final int MAX_DELICTS = 5;

    private static int numberCars = 0;

    public Car() {
        // calls super()
        numberCars++;
    }

    public Car(String licensePlate, String owner, String address){
        numberCars++;
        this.licensePlate = licensePlate;
        this.owner = owner;
        this.address = address;
    }

    public static int getNumberCars() {
        return numberCars;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwner() {
        return owner;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return String.format("L: %s, O: %s A: %s",
                             licensePlate, owner, address);
    }

    public void registerDelict(Delict del) {
        // Entferne das älteste Delikt
        if (delicts.size() >= 5)
            delicts.removeLast();
        delicts.addFirst(del);
    }

    public void printDelicts() {
        int count = 0;
        for (Delict del : delicts) {
            System.out.printf("Delict %2d: %6.2f€ fees, %3d points\n",
                              ++count, del.getFees(), del.getPoints());
        }
        System.out.println();
    }
}


// Aufgabe 3c
class TrafficOffice {

    static LinkedList<Car> carList = new LinkedList<Car>();

    public void registerCar(Car c) {
        if (this.getCar(c.getLicensePlate()) == null)
            carList.addFirst(c);
        else
            System.out.println("Car " + c + " already registered!");
    }

    public Car getCar(String licensePlate) {
        for (Car c : carList) {
            if (licensePlate.equals(c.getLicensePlate()))
                return c;
        }
        return null;
    }
}

// Aufgabe 3d
class Delict {
    private int points;
    private double fees;

    public Delict (double fees, int points) {
        this.points = points;
        this.fees = fees;
    }

    public int getPoints() {
        return points;
    }

    public double getFees() {
        return fees;
    }
}

class CarFactory {
    public static Car buildCar(String owner, String owneraddress) {
        return new Car(randomString(), owner, owneraddress);
    }

    private static String randomString() {
        java.util.Random rnd = new java.util.Random(); // oder auch klassenweit
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            sb.append((char)((rnd.nextInt(25)+65)));
        }
        return sb.toString();
    }
}

// Aufgabe 3b
class Myprogram {
    public static void main (String args[]) {

        Car car1 = new Car("B-KN 4127", "Max M.", "Kreuzbergweg 2");
        Car car2 = new Car("K-LM 5135", "Simon S.", "Roemerstraße 164");
        // Aufgabe 3g
        Car car3 = CarFactory.buildCar("Robin H.", "Hindenburgwall 212");

        TrafficOffice to1 = new TrafficOffice();
        to1.registerCar(car1);
        to1.registerCar(car2);
        to1.registerCar(car3);
        // Sollte Max M. ausgeben::
        System.out.println(to1.getCar(car1.getLicensePlate()).getOwner());
        car2.registerDelict(new Delict(48.5, 2));
        car2.registerDelict(new Delict(20., 0));
        car3.registerDelict(new Delict(100., 5));
        // Sollte K-LM 5135 und Simon S. ausgeben:
        System.out.println("Delikte für " + car2.getLicensePlate() + " (" + car2.getOwner() + "):");
        // Sollte die zwei obigen Delikte ausgeben:
        car2.printDelicts();

        System.out.println("Delikte für " + car3.getLicensePlate() + " (" + car3.getOwner() + "):");
        // Sollte die zwei obigen Delikte ausgeben:
        car3.printDelicts();
    }
}
