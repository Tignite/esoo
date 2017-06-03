class Student {
    private String vorname;
    private String nachname;
    private int matrikelnummer;
    private int semester;

    Student (String vorname, String nachname, int matrikelnummer, int semester) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.matrikelnummer = matrikelnummer;
        this.semester = semester;
    }

    String getVorname() {
        return this.vorname;
    }

    String getNachname() {
        return this.nachname;
    }

    int getMatrikelnummer() {
        return this.matrikelnummer;
    }

    int getSemester() {
        return this.semester;
    }

    void anmelden(Modul m) {
        System.out.println(vorname + " " + nachname + ": "
                           + (m.bearbeiteAnmeldung(this) ? "" : "nicht")
                           + " zugelassen für " + m.getName());
    }
}
