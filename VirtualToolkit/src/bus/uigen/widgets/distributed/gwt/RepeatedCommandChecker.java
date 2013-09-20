package bus.uigen.widgets.distributed.gwt;

import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.client.GWTServerEndAsync;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class RepeatedCommandChecker extends Timer {
	String receiver;
	String program;
	GWTServerEndAsync async;
	GWTProxyGWTServerEnd proxy;

	private static class InitialCommandListCallBack implements
			AsyncCallback<ArrayList<Command>> {
		String receiver;
		GWTProxyGWTServerEnd proxy;

		public InitialCommandListCallBack(String receiver,
				GWTProxyGWTServerEnd proxy) {
			this.receiver = receiver;
			this.proxy = proxy;
		}

		public void onFailure(Throwable caught) {
			caught.printStackTrace();
		}

		public void onSuccess(ArrayList<Command> result) {
			proxy.updateInitialCommands(result, receiver);
		}

	}

	private static class UpdateCommandListCallBack implements
			AsyncCallback<ArrayList<Command>> {
		String receiver;
		GWTProxyGWTServerEnd proxy;

		public UpdateCommandListCallBack(String receiver,
				GWTProxyGWTServerEnd proxy) {
			this.receiver = receiver;
			this.proxy = proxy;
		}

		public void onFailure(Throwable caught) {
			caught.printStackTrace();
		}

		public void onSuccess(ArrayList<Command> result) {
			proxy.updateUpdateCommands(result, receiver);
		}

	}

	private static class ListenerCallBack implements
			AsyncCallback<Map<String, VirtualListener>> {
		GWTProxyGWTServerEnd proxy;

		public ListenerCallBack(String recipient, GWTProxyGWTServerEnd proxy) {
			this.proxy = proxy;
		}

		public void onFailure(Throwable caught) {
			caught.printStackTrace();
		}

		public void onSuccess(Map<String, VirtualListener> result) {
			proxy.updateListeners(result);
		}

	}

	public RepeatedCommandChecker(String receiver, String program,
			GWTServerEndAsync async, GWTProxyGWTServerEnd proxy) {
		this.receiver = receiver;
		this.program = program;
		this.async = async;
		this.proxy = proxy;
	}

	public void run() {
		async.getListeners(program, new ListenerCallBack(receiver, proxy));
		async.getInitialCommands(receiver, new InitialCommandListCallBack(
				receiver, proxy));
		async.getUpdateCommands(receiver, new UpdateCommandListCallBack(
				receiver, proxy));
	}

}
