package bus.uigen.widgets;

import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.nondistributed.ANonDistributedWidgetServerFactory;

public class WidgetServerSelector {

	private static WidgetServerFactory factory = new ANonDistributedWidgetServerFactory();

	public static void setWidgetServerFactory(WidgetServerFactory f) {
		factory = f;
		if (factory != null) {
			factory.registerOtherFactories();
		}
	}

	public static WidgetServer createWidgetServer() {
		return factory.createWidgetServer();
	}

	public static WidgetServer createWidgetServer(
			ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {
		return factory.createWidgetServer(programDescription, replicaID,
				communicationCentralized, widgetsReplicated, isCentralProgram);
	}

	public static WidgetServer createWidgetServer(PipingReplica pipingReplica) {
		return factory.createWidgetServer(pipingReplica);
	}

}
