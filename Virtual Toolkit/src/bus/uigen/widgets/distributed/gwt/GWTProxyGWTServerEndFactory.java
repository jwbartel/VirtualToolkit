package bus.uigen.widgets.distributed.gwt;

import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.ProxyGWTServerEndFactory;

public class GWTProxyGWTServerEndFactory implements ProxyGWTServerEndFactory {

	public GWTProxyGWTServerEndFactory() {

	}

	public ProxyGWTServerEnd create() {
		return new GWTProxyGWTServerEnd();
	}

}
