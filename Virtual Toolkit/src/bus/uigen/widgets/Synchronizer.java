package bus.uigen.widgets;

import java.util.ArrayList;

import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;

public interface Synchronizer {

	public void synchronize(Object oldCmd, Object newCmd);

	public void sendCommand(String command, String replicaID,
			ProgramDescription programDescription);

	public void sendEvent(String event, String replicaID,
			ProgramDescription programDescription);

	public void setRemoteBuildCommands(ArrayList<Command> buildCommands);

	public void synchronizeBuildCommands(String replicaID,
			ProgramDescription programDescription);

}
