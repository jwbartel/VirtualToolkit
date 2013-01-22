package bus.uigen.widgets;

import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.events.VirtualListener;

public interface WidgetServer {

	public String getServer();

	public String getPort();

	public String getApplication();

	public boolean isCentralProgram();

	public void setID(String id);

	public String getUniqueID();

	public String getNameOnServer();

	public void checkCommandsAndListeners();

	public void commandReceived(Object command, String destination);

	public void listenerReceived(VirtualListener listener, String listenerID,
			String program, String destination);

	public void updateListeners(Map<String, VirtualListener> vlisteners);

	public void runCommands();

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program);

	public void send(Object command);

	public ProxyGWTServerEnd getProxy();

	public void processCommand(Object cmd);

	public void runCommand(Object cmd);

	public ArrayList<String> getCentralizedListenerWidgets();
}
