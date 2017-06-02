import java.util.Date;

public class TimeGate extends Component {

    // Gibt true zurück, falls die aktuelle Sekundenzahl gerade ist,
    // sonst false
    @Override public boolean function(java.util.ArrayList<Component> inputs) {
	Date now = new Date();
	// Returns the number of milliseconds since January 1, 1970,
	// 00:00:00 GMT represented by this Date object.
	long seconds = now.getTime() / 1000;
	return (seconds % 2) == 0;
    }
}
