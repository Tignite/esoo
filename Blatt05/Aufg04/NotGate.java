public class NotGate extends Component {
    @Override public boolean function(java.util.ArrayList<Component> inputs) {
	// negiere den ersten Eingang, ignoriere die übrigen Eingänge
	return !inputs.get(0).state;
    }
}
