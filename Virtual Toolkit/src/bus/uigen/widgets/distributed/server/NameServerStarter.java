package bus.uigen.widgets.distributed.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.distributed.nongwt.ADistributedRMIWidgetServer;

public class NameServerStarter extends Thread {

	String server;
	String port;
	RmiServerEnd registrar;

	public NameServerStarter(String server) {
		this.server = server;
		this.port = ADistributedRMIWidgetServer.extractPort(server);
		try {
			registrar = new AnRmiServerEnd();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public NameServerStarter(String server, String port) {
		this.server = server;
		this.port = port;
		if (port == null)
			this.port = ADistributedRMIWidgetServer.extractPort(server);
		try {
			registrar = new AnRmiServerEnd();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public RmiServerEnd getServerEnd() {
		return registrar;
	}

	public void run() {
		try {
			String portVal = port;
			if (portVal == null) {
				portVal = VirtualToolkit.PORT;
			}
			LocateRegistry.createRegistry(Integer.parseInt(portVal));
			Naming.rebind(VirtualToolkit.getFullRegistrarName(server, port),
					registrar);
			System.err.println("Registrar started at "
					+ VirtualToolkit.getFullRegistrarName());
			while (true) {
				Thread.sleep(600000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void start() {
		super.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static RmiServerEnd getRegistrar(String server, String port) {
		try {
			String name = VirtualToolkit.getFullRegistrarName(server, port);
			return (RmiServerEnd) Naming.lookup(name);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * public static RmiServerEnd getRegistrar(){ try { String name =
	 * VirtualToolkit.getFullRegistrarName(); return (RmiServerEnd)
	 * Naming.lookup(name); } catch (Exception e) { return null; } }
	 */
}
