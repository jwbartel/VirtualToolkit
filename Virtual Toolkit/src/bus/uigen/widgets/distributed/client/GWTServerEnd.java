package bus.uigen.widgets.distributed.client;

import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.user.client.rpc.RemoteService;

public interface GWTServerEnd extends RemoteService {

	String join(ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram);

	public void send(Command command);

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program);

	public ArrayList<Command> getInitialCommands(String recipient);

	public ArrayList<Command> getUpdateCommands(String recipient);

	public Map<String, VirtualListener> getListeners(String program);

}
