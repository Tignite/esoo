interface Food {
    public String getMeal();
}

class Cauliflower implements Food {
    public String getMeal() {
        return "Blumenkohl an Gorgonzolasoße";
    }
}

class Spaghetti implements Food {
    public String getMeal() {
        return "Spaghetti Bologneser Art";
    }
}

class Mushroom implements Food {
    public String getMeal() {
        return "Pilzrahmsoße";
    }
}

class Aufgabe2
{
    public static void main(String[] args) {
        Food food;
        food = new Cauliflower();
        System.out.println(food.getMeal());
        food = new Spaghetti();
        System.out.println(food.getMeal());
        food = new Mushroom();
        System.out.println(food.getMeal());
    }
}
