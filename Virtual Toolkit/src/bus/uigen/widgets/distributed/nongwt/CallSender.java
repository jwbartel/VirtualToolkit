package bus.uigen.widgets.distributed.nongwt;

import bus.uigen.widgets.distributed.Command;

public class CallSender extends Thread {
	RmiClientEnd rmiClient;
	Command command;
	String recipient;

	public CallSender(RmiClientEnd rmiClient, Command command, String recipient) {
		this.rmiClient = rmiClient;
		this.command = command;
		this.recipient = recipient;
	}

	public void run() {
		try {
			rmiClient.receiveCommand(command, recipient);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
