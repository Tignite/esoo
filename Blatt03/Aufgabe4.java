// Siehe 8.8.10 Preventing Instantiation of a Class,
// The Java Language Specification

class Singleton {
    private static Singleton onlyInstance = null;

    public static Singleton getSingleton() {
        if (onlyInstance != null)
            return onlyInstance;
        else
            return new Singleton();
    }

    private Singleton() {
        Singleton.onlyInstance = this;
    }
}

class Aufgabe4
{
    public static void main(String args[])
    {
        Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();
        System.out.println(s1 + ", " + s2);
        System.out.println(s1 + (s1 == s2 ? " == " : " != ") + s2);
    }
}
