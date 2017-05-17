class transposeOperator implements Operator {
    public Object execute (Matrix2D matrix) {
        // Müssen nur die beiden Elemente außerhalb der
        // Hauptdiagonalen vertauschen:
        return new Matrix2D(matrix.values[0][0], matrix.values[1][0],
                            matrix.values[0][1], matrix.values[1][1]);
    }
}
