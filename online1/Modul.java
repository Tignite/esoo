public class Modul {
    private String name;
    private java.util.ArrayList<Student> hoerer = new java.util.ArrayList<>();
    // Methoden etc...

    Modul(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    boolean bearbeiteAnmeldung(Student s) {
        if(hoerer.size() >= 100) {
            return false;
        } else {
            hoerer.add(s);
            return true;
        }
    }
}
