package bus.uigen.widgets.nondistributed;

import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.WidgetServer;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualListener;

public class ANonDistributedWidgetServer implements WidgetServer {

	protected ProgramDescription programDescription;

	ProxyGWTServerEnd proxy;

	public ANonDistributedWidgetServer() {

		proxy = new NonDistributedProxyGWTServerEnd();
		proxy.join(null, null, false, false, false);
	}

	public ANonDistributedWidgetServer(ProgramDescription programDescription,
			String replicaID) {
		this.programDescription = programDescription;

		proxy = new NonDistributedProxyGWTServerEnd();
		proxy.join(programDescription, replicaID, false, false, false);
	}

	/*
	 * public static String[] parseJoinDescription(String joinDescription) {
	 * String[] retVal = new String[4];
	 * 
	 * int argPos = joinDescription.indexOf('?'); String serverAndApp =
	 * joinDescription.substring(0, argPos); String sessionAndKind =
	 * joinDescription.substring(argPos + 1);
	 * 
	 * while (serverAndApp.charAt(serverAndApp.length() - 1) == '/') {
	 * serverAndApp = serverAndApp.substring(0, serverAndApp.length() - 1); }
	 * 
	 * int serverEnd = serverAndApp.lastIndexOf('/'); String server =
	 * serverAndApp.substring(0, serverEnd); String app =
	 * serverAndApp.substring(serverEnd + 1);
	 * 
	 * int sessionEnd = sessionAndKind.indexOf('&'); String session =
	 * sessionAndKind.substring(0, sessionEnd); session =
	 * session.substring("session=".length());
	 * 
	 * String kind = sessionAndKind.substring(sessionEnd + 1); kind =
	 * kind.substring("kind=".length());
	 * 
	 * retVal[0] = server; retVal[1] = app; retVal[2] = session; retVal[3] =
	 * kind; return retVal; }
	 * 
	 * public static String extractPort(String server) { int colonPos =
	 * server.lastIndexOf(':'); if (colonPos >= 0) { return
	 * server.substring(colonPos + 1); } else { return null; } }
	 */

	@Override
	public String getServer() {
		return programDescription.getServer();
	}

	@Override
	public String getPort() {
		return programDescription.getPort();
	}

	@Override
	public String getApplication() {
		return programDescription.getApp();
	}

	@Override
	public String getUniqueID() {
		return proxy.getUniqueID();
	}

	@Override
	public boolean isCentralProgram() {
		return false;
	}

	@Override
	public void checkCommandsAndListeners() {
	}

	@Override
	public void commandReceived(Object command, String destination) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listenerReceived(VirtualListener listener, String listenerID,
			String program, String destination) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateListeners(Map<String, VirtualListener> vlisteners) {
		// TODO Auto-generated method stub

	}

	@Override
	public void runCommands() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program) {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(Object command) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProxyGWTServerEnd getProxy() {
		return proxy;
	}

	@Override
	public void processCommand(Object cmd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void runCommand(Object cmd) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> getCentralizedListenerWidgets() {
		return null;
	}

	@Override
	public void setID(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNameOnServer() {
		// TODO Auto-generated method stub
		return null;
	}

}
