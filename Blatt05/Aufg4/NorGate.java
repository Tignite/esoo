public class NorGate extends Component {
    // Funktioniert genau wie das OrGate, nur dass der Ausgang negiert wird
    @Override public boolean function(java.util.ArrayList<Component> inputs) {
	for(Component c : inputs) {
	    // gebe false zurück sobald ein Eingang true ist
	    if(c.state) return false;
	}

	// falls kein Eingang true gebe true zurück
	return true;
    }
}
