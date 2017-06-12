// Aufgabe 1 b)

class CallEg {
    public void methodA() throws ArithmeticException {
        methodB();
    }

    public void methodB() throws ArithmeticException {
        methodC();
    }

    public void methodC() throws ArithmeticException {
        int infinity = 1 / 0;
    }
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
