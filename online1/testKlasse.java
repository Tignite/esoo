class testKlasse
{
    public static void main(String args[])
    {
        Modul m1 = new Modul("Analysis");
        Modul m2 = new Modul("OOSE");

        Student stud = new Student("Foo", "Bar", 1234, 2);

        stud.anmelden(m1);
        for (int i = 0; i <= 100; i++)
            stud.anmelden(m2);
    }
}
