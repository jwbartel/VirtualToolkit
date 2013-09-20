package bus.uigen.widgets.distributed.nongwt;

import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.ProxyGWTServerEndFactory;

public class NonGWTProxyGWTServerEndFactory implements ProxyGWTServerEndFactory {

	public ProxyGWTServerEnd create() {// String joinDescription, String
										// replicaID, boolean
										// communicationCentralized, boolean
										// widgetsReplicated) {

		return new NonGwtProxyGWTServerEnd();// joinDescription, replicaID,
												// communicationCentralized,
												// widgetsReplicated);
	}

}
