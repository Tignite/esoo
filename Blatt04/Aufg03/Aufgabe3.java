class Aufgabe3
{
    public static void main(String args[])
    {
        Student student = new Student();

        Cauliflower essen1 = new Cauliflower();
        student.eat(essen1);

        Spaghetti essen2 = new Spaghetti();
        student.eat(essen2);

        Food essen = new Cauliflower();
        student.eat(essen);
    }
}
