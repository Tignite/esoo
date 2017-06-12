// Aufgabe 1 c)

class CallEg {
    public void methodA() throws ArithmeticException {
        System.out.println("methodA");
        try {
            methodB();
        } catch (Exception e) {
            // e.printStackTrace();
            throw (e);
        }
    }

    public void methodB() throws ArithmeticException {
        System.out.println("methodB");
        try {
            methodC();
        } catch (Exception e) {
            // e.printStackTrace();
            throw (e);
        }
    }

    public void methodC() throws ArithmeticException {
        System.out.println("methodC");
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
