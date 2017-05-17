class symmetryOperator implements Operator {
    public Object execute (Matrix2D matrix) {
        // Müssen nur die beiden Elemente außerhalb der
        // Hauptdiagonalen vergleichen:
        return matrix.values[1][0] == matrix.values[0][1];
    }
}
