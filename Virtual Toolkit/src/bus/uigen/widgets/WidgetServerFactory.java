package bus.uigen.widgets;

import bus.uigen.widgets.distributed.ProgramDescription;

public interface WidgetServerFactory {

	public WidgetServer createWidgetServer();

	public WidgetServer createWidgetServer(
			ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram);

	public WidgetServer createWidgetServer(PipingReplica pipingReplica);

	public void registerOtherFactories();
}
