package bus.uigen.widgets;

import java.util.ArrayList;

import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;

public class DefaultSynchronizer implements Synchronizer {

	public void synchronize(Object oldCmd, Object newCmd) {
		// Stub method
	}

	@Override
	public void sendCommand(String command, String replicaID,
			ProgramDescription programDescription) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEvent(String event, String replicaID,
			ProgramDescription programDescription) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRemoteBuildCommands(ArrayList<Command> buildCommands) {
		// TODO Auto-generated method stub

	}

	@Override
	public void synchronizeBuildCommands(String replicaID,
			ProgramDescription programDescription) {
		// TODO Auto-generated method stub

	}

}
