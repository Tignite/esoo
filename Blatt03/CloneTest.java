class Person implements Cloneable {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString () {
        return name + ":" + age;
    }

    public Person clone() {
        try {
            return (Person) super.clone ();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            return null;
        }
    }
}

public class CloneTest
{
    public static void main(String args[])
    {
        Person p1 = new Person("Harald", 21);
        Person p2 = p1.clone();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.name == p2.name);

        // Hier wird ein neues Objekt vom Typ String erzeugt und
        // p1.name referenziert diesen neuen String.
        p1.name = "Torben";
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.name == p2.name);
    }
}
