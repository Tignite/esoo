// TestCase Klasse zum Testen eines Gates. Der Constructor erhält als
// Argumente ein Gate und ein boolean[] Array mit den erwarteten
// Werten am Ausgang des Gates für die Eingangsbelegungen von zwei
// Eingängen A und B mit
//
// A | B  | erwarteter Wert in
// ----------------------------
// 0 | 0  | expectedResults[0]
// 0 | 1  | expectedResults[1]
// 1 | 0  | expectedResults[2]
// 1 | 1  | expectedResults[3]

import java.util.ArrayList;

class TestCase {
    Component gate;
    boolean[] expectedResults;
    ArrayList<Boolean> results;
    Component inA = new PassGate();
    Component inB = new PassGate();
    Circuit circuit = new Circuit();

    TestCase(Component gate, boolean[] expectedResults) {
        this.gate = gate;
        this.expectedResults = expectedResults;
        inA.connectTo(gate);
        inB.connectTo(gate);
        circuit.exitgates.add(gate);
    }

    boolean runTest() {
        System.out.println("** Teste " + gate.getClass() + " **");

        boolean testPassed = true;
        int resultsIdx = 0;
        boolean[] inputValues = {false, true};
        for (boolean a: inputValues) {
            for (boolean b: inputValues) {
                inA.state = a;
                inB.state = b;
                ArrayList<Boolean> results = circuit.simulate();
                boolean valuesMatch = results.get(0) == expectedResults[resultsIdx];

                if (!valuesMatch) {
                    testPassed = false;
                }

                System.out.print("inA=" + (a ? 1 : 0) + ", inB=" + (b ? 1 : 0) + ": " +
                                 "Result: " + results.get(0) + ", Expected: " +
                                 expectedResults[resultsIdx] + (valuesMatch ? " OK" : " FAIL") + "\n");
                resultsIdx++;
            }
        }

        System.out.println("Test " + gate.getClass() + (testPassed ? " PASSED\n" : " FAILD\n"));

        return testPassed;
    }
}
