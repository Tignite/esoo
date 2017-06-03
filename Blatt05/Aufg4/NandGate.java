public class NandGate extends Component {
    @Override public boolean function(java.util.ArrayList<Component> inputs) {
	for(Component c : inputs) {
	    // gebe true zurück sobald ein Eingang true ist
	    if(!c.state) return true;
	}
	// falls kein Eingang true gebe false zurück
	return false;
    }
}
