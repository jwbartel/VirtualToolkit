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
