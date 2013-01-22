package bus.uigen.widgets.distributed.client;

import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GWTServerEndAsync {

	void send(Command command, AsyncCallback<Void> callback);

	void join(ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram, AsyncCallback<String> callback);

	void getInitialCommands(String recipient,
			AsyncCallback<ArrayList<Command>> callback);

	void sendListener(VirtualListener listener, String id, String application,
			String session, String program, AsyncCallback<Void> callback);

	void getListeners(String program,
			AsyncCallback<Map<String, VirtualListener>> callback);

	void getUpdateCommands(String recipient,
			AsyncCallback<ArrayList<Command>> callback);

}
