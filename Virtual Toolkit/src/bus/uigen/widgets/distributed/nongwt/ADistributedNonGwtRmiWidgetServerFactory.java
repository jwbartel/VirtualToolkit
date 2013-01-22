package bus.uigen.widgets.distributed.nongwt;

import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.ProxyGWTServerEndSelector;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServer;
import bus.uigen.widgets.WidgetServerFactory;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.server.ForwarderWidgetServer;
import bus.uigen.widgets.gwt.GWTSynchronizer;

public class ADistributedNonGwtRmiWidgetServerFactory implements
		WidgetServerFactory {

	public ADistributedNonGwtRmiWidgetServerFactory() {
		VirtualToolkit.setSynchronizer(new GWTSynchronizer());
	}

	@Override
	public WidgetServer createWidgetServer() {
		return new ADistributedRMIWidgetServer();
	}

	@Override
	public WidgetServer createWidgetServer(
			ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {

		return new ADistributedRMIWidgetServer(programDescription, replicaID,
				communicationCentralized, widgetsReplicated, isCentralProgram);
	}

	@Override
	public WidgetServer createWidgetServer(PipingReplica pipingReplica) {
		return new ForwarderWidgetServer(pipingReplica);
	}

	@Override
	public void registerOtherFactories() {

		ProxyGWTServerEndSelector
				.setProxyGWTServerEndFactory(new NonGWTProxyGWTServerEndFactory());
	}

}
