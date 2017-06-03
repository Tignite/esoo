import java.util.ArrayList;

class Testklasse
{
    public static void main(String args[])
    {
        TestCase[] testCases = {new TestCase(new OrGate(), new boolean[] {false, true, true, true}),
                                new TestCase(new NotGate(), new boolean[] {true, true, false, false}),
                                new TestCase(new XorGate(), new boolean[] {false, true, true, false}),
                                new TestCase(new NorGate(), new boolean[] {true, false, false, false})};

        boolean allTestsPassed = true;
        for (TestCase tc: testCases) {

            if (!tc.runTest()) {
                allTestsPassed = false;
            };
        }

        System.out.println((allTestsPassed ? "All Tests PASSED" : "At least one Test FAILD!"));
        System.exit(allTestsPassed ? 0 : 1);
    }
}
