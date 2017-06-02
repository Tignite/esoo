public class AndGate extends Component {
    @Override public boolean function(java.util.ArrayList<Component> inputs) {
	for(Component c : inputs) {
	    // gebe false zurück sobald ein Eingang false ist
	    if(!c.state) return false;
	}
	// falls kein Eingang false gebe true zurück
	return true;
    }
}
