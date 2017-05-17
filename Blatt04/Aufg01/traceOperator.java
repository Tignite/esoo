class traceOperator implements Operator {
    public Object execute (Matrix2D matrix) {
        return matrix.values[0][0] + matrix.values[1][1];
    }
}
