package bus.uigen.widgets.distributed.gwt;

import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.ProxyGWTServerEndSelector;
import bus.uigen.widgets.WidgetServer;
import bus.uigen.widgets.WidgetServerFactory;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.nongwt.ADistributedRMIWidgetServer;

public class ADistributedGwtRmiWidgetServerFactory implements
		WidgetServerFactory {

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
	public void registerOtherFactories() {

		ProxyGWTServerEndSelector
				.setProxyGWTServerEndFactory(new GWTProxyGWTServerEndFactory());
	}

	@Override
	public WidgetServer createWidgetServer(PipingReplica pipingReplica) {
		return null;
	}

}
