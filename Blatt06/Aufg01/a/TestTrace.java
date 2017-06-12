// Aufgabe 1 a)

class CallEg {
    public void methodA() throws ArithmeticException {
        int infinity = 1 / 0;
    }

    public void methodB() throws ArithmeticException { }
    public void methodC() throws ArithmeticException { }
}

public class TestTrace {
    public static void main(String[] args) {
        CallEg eg = new CallEg(); // use default constructor
        try {
            eg.methodA();
        } catch (ArithmeticException oops) {
            oops.printStackTrace();
        }
    }
}
