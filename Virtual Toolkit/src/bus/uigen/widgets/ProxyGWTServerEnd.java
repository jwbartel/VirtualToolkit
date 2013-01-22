package bus.uigen.widgets;

import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualListener;

public interface ProxyGWTServerEnd {

	public void join(ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram);

	public String getID();

	public String getUniqueID();

	public void send(Object command);

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program);

	// public void checkCommands();
	// public void checkListeners();
	public void addCommandsListener(CallsListener listener, String program,
			String nameOnServer);

}
