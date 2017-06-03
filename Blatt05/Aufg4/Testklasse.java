import java.util.ArrayList;
import java.util.Date;

class Testklasse
{
    public static void main(String args[])
    // throws InterruptedException wegen Thread.sleep(1000) untem im Code
        throws InterruptedException {
        TestCase[] testCases =
            {new TestCase(new AndGate(), new boolean[] {false, false, false, true}),
             new TestCase(new OrGate(), new boolean[] {false, true, true, true}),
             new TestCase(new NotGate(), new boolean[] {true, true, false, false}),
             new TestCase(new XorGate(), new boolean[] {false, true, true, false}),
             new TestCase(new NandGate(), new boolean[] {true, true, true, false}),
             new TestCase(new NorGate(), new boolean[] {true, false, false, false})};

        boolean allTestsPassed = true;
        for (TestCase tc: testCases) {
            if (!tc.runTest()) {
                allTestsPassed = false;
            };
        }

        // Teste TimeGate Das kann man hier natürlich nicht korrekt
        // testen, weil ES NICHT SICHER MÖGLICH IST DEN IDENTISCHEN
        // ZEITPUNKT zu erwischen wie der, den das TimeGate selber benutzt!
        Component timeGate = new TimeGate();
        boolean evenSec = ((new Date()).getTime() / 1000) % 2 == 0 ? true : false;
        TestCase timeGateTC = new TestCase(timeGate,
                                           new boolean[] {evenSec, evenSec, evenSec, evenSec});
        if (!timeGateTC.runTest()) {
            allTestsPassed = false;
        };

        // 1 Sekunde warten ...
        System.out.println("Warte 1 Sekunde ...");
        Thread.sleep(1000);

        evenSec = ((new Date()).getTime() / 1000) % 2 == 0 ? true : false;
        timeGateTC.expectedResults = new boolean[] {evenSec, evenSec, evenSec, evenSec};

        if (!timeGateTC.runTest()) {
            allTestsPassed = false;
        };

        System.out.println((allTestsPassed ? "All Tests PASSED" : "At least one Test FAILD!"));
        System.exit(allTestsPassed ? 0 : 1);
    }
}
