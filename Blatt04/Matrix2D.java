class Matrix2D {
    // Standardmäßig werden alle Elemente im Array auf ihren
    // Standardwert (hier also 0d) gesetzt
    private double[][] values = new double[2][2];

    // Legt die Formatierung der Array Einträge in der toString()
    // Methode fest.
    private final String formatString = "%04.2f";

    // Gibt eine 0-Matrix zurück
    public Matrix2D() {

    }

    // Gibt die Einheitmatrix multipliziert mit einem doulbe Skalar
    // zurück. new Matrix2D(1) gibt also die Einheitsmatrix zurück
    public Matrix2D(double scalar) {
        this();
        values[0][0] = scalar;
        values[1][1] = scalar;
    }
    // Gibt eine Matrix zurück, initialisiert mit den Werten a00, a01,
    // a10, a11
    public Matrix2D(double a00, double a01,
                     double a10, double a11) {
        values[0][0] = a00; values[0][1] = a01;
        values[1][0] = a10; values[1][1] = a11;

        // Alternativ: Neues Array erzeugen:
        // double[][] n = {{a00, a01}, {a10, a11}};
        // values = n;
    }

    public String toString() {
        return String.format("[ " + formatString + " " + formatString + "]\n" +
                             "[ " + formatString + " " + formatString + "]\n",
                             values[0][0], values[0][1],
                             values[1][0], values[1][1]);
    }
}
