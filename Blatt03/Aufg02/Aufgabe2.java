class Aufgabe2
{
    public static void main(String[] args) {
        Food food;
        food = new Cauliflower();
        System.out.println(food.getMeal());
        food = new Spaghetti();
        System.out.println(food.getMeal());
        // Aufgabe 2b Stichwort: Dynamic Binding, Nachricht an Objekt
        // hat verschiedene Effekte je nach Empfängertyp

        // Aufgabe 2c
        food = new Lasagne("Veggies", 'M');
        System.out.println(food.getMeal());
    }
}
