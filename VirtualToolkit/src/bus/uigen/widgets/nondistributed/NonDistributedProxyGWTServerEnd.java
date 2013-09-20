package bus.uigen.widgets.nondistributed;

import bus.uigen.widgets.CallsListener;
import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualListener;

public class NonDistributedProxyGWTServerEnd implements ProxyGWTServerEnd {

	String id;

	@Override
	public void join(ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {

		this.id = "" + id;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getUniqueID() {
		return id;
	}

	@Override
	public void send(Object command) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCommandsListener(CallsListener listener, String program,
			String nameOnServer) {
		// TODO Auto-generated method stub

	}

}
