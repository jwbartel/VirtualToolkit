package bus.uigen.widgets;

import java.util.ArrayList;

import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.exceptions.CollaborativeException;

public interface PipingReplica {

	public void buildGenericCentralProgram(ProgramDescription programDescriptio);

	public void setSharedListenerWidgets(ArrayList<String> sharedListenerWidgets);

	public ArrayList<String> getSharedListenerWidgets();

	public void registerRmiClientEnd(String rmiClientEndID,
			ProgramDescription programDescription, String replicaID,
			boolean widgetsReplicated, boolean isCentralProgram)
			throws CollaborativeException;

	public void broadcastCommand(Command command,
			boolean directCommunicationCapable) throws CollaborativeException;

	public void sendListener(VirtualListener listener, String id)
			throws CollaborativeException;

	public String getProgramKind();

	public void setCentralWidgetServer(WidgetServer widgetServer);

}