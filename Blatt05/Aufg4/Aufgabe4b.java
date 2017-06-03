// Aufgabe04b
import java.util.ArrayList;

class Aufgabe4b {
    static boolean testXor() {
        Component inA =  new PassGate(); // A
        Component inB =  new PassGate(); // B

        Component xor = new XorGate();

        // Komponenten zur Simulation des Xor-Gates
        Component and1 = new AndGate();
        Component and2 = new AndGate();
        Component not1 = new NotGate();
        Component not2 = new NotGate();
        Component or = new OrGate();

        ///////////////////////////////////////////
        // Simuliere XOR mit NOT, AND, OR        //
        ///////////////////////////////////////////

        // not1 = NOT B
        inB.connectTo(not1);

        // and1 = (NOT B) OR A
        not1.connectTo(and1);
        inA.connectTo(and1);

        // not2 = NOT A
        inA.connectTo(not2);

        // and2 = (NOT A) OR B
        not2.connectTo(and2);
        inB.connectTo(and2);

        // or = (A AND (NOT B)) OR ((NOT B) AND B)
        and1.connectTo(or);
        and2.connectTo(or);

        ///////////////////////////////////////////
        // XOR Gate selbst, zum Vergleich        //
        ///////////////////////////////////////////

        inA.connectTo(xor);
        inB.connectTo(xor);

        /////////////
        // Circuit //
        /////////////

        Circuit testCircuit = new Circuit();
        testCircuit.exitgates.add(or);
        testCircuit.exitgates.add(xor);

        ////////////////
        // Vergleiche //
        ////////////////
        boolean testPassed = true;
        boolean[] bools = {false, true};
        for (boolean a : bools) {
            for (boolean b : bools) {
                inA.state = a;
                inB.state = b;
                // Schaltunk aktualisieren
                ArrayList<Boolean> results = testCircuit.simulate();
                boolean valuesMatch = results.get(0) ==  results.get(1);
                System.out.printf("A=%d, B=%d, Results: ", a ? 1 : 1, b ? 1 : 0);
                System.out.println(testCircuit.simulate() + " "
                                   + (valuesMatch ? "PASSED" : "FAILED"));
                if (!valuesMatch) {
                    testPassed = false;
                }
            }
        }

        return testPassed;
    }

    public static void main(String[] args) {
        System.out.println("Aufgabe 4b");

        boolean testPassed = testXor();
        System.out.println(testPassed ? "Test PASSED" : "Test FAILD");
        System.exit(testPassed ? 0 : 1);
    }
}
