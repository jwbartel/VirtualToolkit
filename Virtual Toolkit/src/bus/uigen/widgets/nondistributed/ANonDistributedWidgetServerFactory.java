package bus.uigen.widgets.nondistributed;

import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.WidgetServer;
import bus.uigen.widgets.WidgetServerFactory;
import bus.uigen.widgets.distributed.ProgramDescription;

public class ANonDistributedWidgetServerFactory implements WidgetServerFactory {

	@Override
	public WidgetServer createWidgetServer() {

		return new ANonDistributedWidgetServer();
	}

	@Override
	public WidgetServer createWidgetServer(
			ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {

		return new ANonDistributedWidgetServer(programDescription, replicaID);
	}

	@Override
	public WidgetServer createWidgetServer(PipingReplica pipingReplica) {
		return new ANonDistributedWidgetServer();
	}

	@Override
	public void registerOtherFactories() {
	}

}
