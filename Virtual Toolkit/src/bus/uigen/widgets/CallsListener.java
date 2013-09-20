package bus.uigen.widgets;

import java.io.Serializable;
import java.util.Map;

import bus.uigen.widgets.events.VirtualListener;

public interface CallsListener extends Serializable {

	// public void updateCommands(ArrayList<Command> commands);
	public void updateListeners(Map<String, VirtualListener> vlisteners);

	public void commandReceived(Object command, String destination);

	public void listenerReceived(VirtualListener listener, String listenerID,
			String program, String destination);
}
