package bus.uigen.widgets.distributed;

import java.io.Serializable;

public class ProgramDescription implements Serializable {

	String urlDescription;

	String server, port;
	String app;
	String session;
	String kind;

	public ProgramDescription() {

	}

	public ProgramDescription(String urlDescription) {
		this.urlDescription = urlDescription;
	}

	private void parseURLDescription() {

		int argPos = urlDescription.indexOf('?');
		String serverAndApp = urlDescription.substring(0, argPos);
		String sessionAndKind = urlDescription.substring(argPos + 1);

		while (serverAndApp.charAt(serverAndApp.length() - 1) == '/') {
			serverAndApp = serverAndApp.substring(0, serverAndApp.length() - 1);
		}

		int serverEnd = serverAndApp.lastIndexOf('/');
		server = serverAndApp.substring(0, serverEnd);
		port = extractPort(server);
		app = serverAndApp.substring(serverEnd + 1);

		int sessionEnd = sessionAndKind.indexOf('&');
		session = sessionAndKind.substring(0, sessionEnd);
		session = session.substring("session=".length());

		kind = sessionAndKind.substring(sessionEnd + 1);
		kind = kind.substring("kind=".length());
	}

	private String extractPort(String server) {
		int colonPos = server.lastIndexOf(':');
		if (colonPos >= 0) {
			return server.substring(colonPos + 1);
		} else {
			return null;
		}
	}

	private void checkAndParseDescrition() {
		if (server == null && port == null && app == null && session == null
				&& kind == null) {
			parseURLDescription();
		}
	}

	public String getUrlDescription() {
		return urlDescription;
	}

	public String getServer() {
		checkAndParseDescrition();
		return server;
	}

	public String getPort() {
		checkAndParseDescrition();
		return port;
	}

	public String getApp() {
		checkAndParseDescrition();
		return app;
	}

	public String getSession() {
		checkAndParseDescrition();
		return session;
	}

	public String getKind() {
		checkAndParseDescrition();
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ProgramDescription)) {
			return false;
		}

		ProgramDescription pd = (ProgramDescription) obj;

		return (pd.urlDescription != null && urlDescription != null && urlDescription
				.equals(pd.urlDescription))
				|| (((pd.server == null && server == null) || server
						.equals(pd.server))
						&& ((pd.port == null && port == null) || port
								.equals(pd.port))
						&& ((pd.app == null && app == null) || app
								.equals(pd.app))
						&& ((pd.session == null && session == null) || session
								.equals(pd.session)) && ((pd.kind == null && kind == null) || kind
						.equals(pd.kind)));
	}

}
