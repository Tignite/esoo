public class XorGate extends Component {

    // Gebe true zurück wenn eine ungerade Anzahl an Eingängen
    // true ist. Dies is die Erweiterung von XOR auf mehr als
    // zwei Argumente (XOR ist assoziativ).
    // https://en.wikipedia.org/wiki/Exclusive_or#/media/File:Multigrade_operator_XOR.svg
    @Override public boolean function(java.util.ArrayList<Component> inputs) {
	boolean unevenNumberOfTrue = false;

	for(Component c : inputs) {
	    // Toggle unevenNumberOfTrue bei jeden Eingang dessen state true ist
	    if (c.state) {
		unevenNumberOfTrue = !unevenNumberOfTrue;
	    }
	}

	return unevenNumberOfTrue;
    }
}
