class Lasagne implements Food {

    private char size;
    private String topping;

    public Lasagne(String topping, char size)  {
        this.topping = topping;
        this.size = size;
    }

    public String getMeal() {
        return "Lasagna Italiano in size: " + size + " with " + topping + " topping.";
    }
}
