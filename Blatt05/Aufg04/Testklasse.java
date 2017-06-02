import java.util.ArrayList;

class Testklasse
{
    // testCircuit testet den Circuit c, in dem es c.simulate()
    // aufruft und die zurückgegebene ArrayList mit der übergebenen
    // ArrayList expectedResults, die die erwarteten Ergebnisse
    // enthält, auf Gleicheit vergleicht.
    // Rückgabewert: true, falls alle Werte übereinstimmen, false sonst
    static boolean testCircuit(Circuit c, ArrayList expectedResults) {
	boolean testPassed = true;
	ArrayList results = c.simulate();

	if (results.size() != expectedResults.size()) {
	    System.out.println("len(results) != len(expectedResults)\n");
	    testPassed =  false;
	} else {
	    for (int i = 0; i < results.size(); i++) {
		if (results.get(i) != expectedResults.get(i)) {
		    testPassed = false;
		}
	    }
	}

	return testPassed;
    }

    ////////////////////////////////////////////////////
    // TODO: Alle Componenten mit testCircuit testen! //
    ////////////////////////////////////////////////////

    // Aufgabe 4 b
    static boolean testXor() {
	Component in1 =  new PassGate(); // A
	Component in2 =  new PassGate(); // B

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
	in2.connectTo(not1);

	// and1 = (NOT B) OR A
	not1.connectTo(and1);
	in1.connectTo(and1);

	// not2 = NOT A
	in1.connectTo(not2);

	// and2 = (NOT A) OR B
	not2.connectTo(and2);
	in2.connectTo(and2);

	// or = (A AND (NOT B)) OR ((NOT B) AND B)
	and1.connectTo(or);
	and2.connectTo(or);

	///////////////////////////////////////////
	// XOR Gate selbst, zum Vergleich        //
	///////////////////////////////////////////

	in1.connectTo(xor);
	in2.connectTo(xor);

	/////////////
	// Circuit //
	/////////////

	Circuit testCircuit = new Circuit();
	testCircuit.exitgates.add(or);
	testCircuit.exitgates.add(xor);

	////////////////
	// Vergleiche //
	////////////////
	boolean testPassed = false;

	boolean[] bools = {false, true};
	for (boolean a : bools) {
	    for (boolean b : bools) {
		in1.state = a;
		in2.state = b;
		// Schaltunk aktualisieren
		ArrayList<Boolean> results = testCircuit.simulate();
		System.out.printf("A=%b, B=%b :", a, b);
		System.out.println(testCircuit.simulate() + " "
				   + (results.get(0) == results.get(1) ?
				      "PASSED" : "FAILED"));
	    }
	}

	return true;
    }

    public static void main(String args[])
    {
	testXor();
	// // Benötigte Komponenten instanzieren
	// Component in1 = new PassGate(); // A
	// Component in2 = new PassGate(); // B
	// Component n1 = new NotGate();
	// Component a1 = new AndGate();

	// // Bauteile vernetzen
	// in1.connectTo(a1); // A direkt mit AND verbinden
	// in2.connectTo(n1); // B zunächst mit NOT verbinden
	// n1.connectTo(a1); // NOT mit AND verbinden

	// // Circuit-Klasse instanzieren und Ausgang von AND registrieren
	// Circuit c1 = new Circuit();
	// c1.exitgates.add(a1);
	// in1.state = true; // Eingang A festlegen
	// in2.state = false; // Eingang B festlegen
	// // Schaltung simulieren und Wert des ersten und einzigen Ausgang ausgeben

	// System.out.println(c1.simulate().get(0));
    }
}
