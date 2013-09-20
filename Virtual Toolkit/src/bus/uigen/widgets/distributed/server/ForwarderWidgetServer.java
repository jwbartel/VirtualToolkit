package bus.uigen.widgets.distributed.server;

import java.util.ArrayList;

import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.nongwt.ADistributedRMIWidgetServer;
import bus.uigen.widgets.events.VirtualListener;

public class ForwarderWidgetServer extends ADistributedRMIWidgetServer {
	PipingReplica pipingReplica;

	public ForwarderWidgetServer(PipingReplica pipingReplica) {
		this.pipingReplica = pipingReplica;
	}

	public boolean isCentralProgram() {
		return super.isCentralProgram() || pipingReplica != null;
	}

	public String getUniqueID() {
		if (pipingReplica != null)
			return id;
		return super.getUniqueID();
	}

	public String getNameOnServer() {
		if (pipingReplica != null)
			return id;
		return null;
	}

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program) {

		pipingReplica.sendListener(listener, id);
	}

	public void send(Object commandObj) {
		Command command = (Command) commandObj;

		pipingReplica.broadcastCommand(command, false);
	}

	@Override
	public ArrayList<String> getCentralizedListenerWidgets() {
		return pipingReplica.getSharedListenerWidgets();
	}

	public void checkCommandsAndListeners() {
		if (pipingReplica == null)
			super.checkCommandsAndListeners();
	}
}
