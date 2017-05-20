class Aufgabe1 {
    public static void main(String[] args) {
        System.out.println("Blatt 04, Aufgabe1:");

        Matrix2D[] testMatrices = {new Matrix2D( 2, 3, -1, 2),

                                   //symmetrisch, Zeilen linear unabhängig
                                   new Matrix2D( 2, 3, 3, 2),

                                   // symmetrisch, Zeilen linear abhängig -> det() = 0:
                                   new Matrix2D( 1, 2, 2, 4),

                                   // nicht symmetrisch, Zeilen linear abhängig -> det() = 0;
                                   new Matrix2D( 2, 3, 4, 6)};

        Operator alloperators[] = {new determinantOperator(),
                                   new traceOperator(),
                                   new symmetryOperator(),
                                   new transposeOperator()};

        for (Matrix2D m : testMatrices) {
            System.out.println("\nWende Operatoren an auf folgende Matrix: \n" + m);

            for(Operator o : alloperators) {
                System.out.println("Ergebnis " + o.getClass().toString());
                System.out.println(m.applyOperator(o).getClass().toString() + ":");
                System.out.println(m.applyOperator(o));
            }

	    System.out.println();
        }
    }
}
