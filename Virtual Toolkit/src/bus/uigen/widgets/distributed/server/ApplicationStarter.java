package bus.uigen.widgets.distributed.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bus.uigen.widgets.distributed.nongwt.ADistributedRMIWidgetServer;
import bus.uigen.widgets.exceptions.CollaborativeException;

public class ApplicationStarter {

	static String variableSuffix = "\\s*=\\s*\"([^\"]|(\\\\\"))+\"";

	static String nameREGEX = "(" + "name" + variableSuffix + ")";
	static String typeREGEX = "(" + "type" + variableSuffix + ")";

	static Pattern namePattern = Pattern.compile(nameREGEX);
	static Pattern typePattern = Pattern.compile(typeREGEX);

	static String startAppREGEX = "<\\s*application\\s+name\\s*=\\s*\"([^\"]|(\\\\\"))+\"\\s*>";
	static String endAppREGEX = "</\\s*application\\s*>";

	static Pattern startAppPattern = Pattern.compile(startAppREGEX,
			Pattern.CASE_INSENSITIVE);

	static String programREGEX = "<\\s*program\\s+" + nameREGEX
			+ "\\s*((/>)|(>\\s*</\\s*program\\s*>))";
	static Pattern programPattern = Pattern.compile(programREGEX,
			Pattern.CASE_INSENSITIVE);

	static String widgetREGEX = "<\\s*widget\\s+" + nameREGEX
			+ "\\s*((/>)|(>\\s*</\\s*widget\\s*>))";
	static Pattern widgetPattern = Pattern.compile(widgetREGEX,
			Pattern.CASE_INSENSITIVE);

	static String argREGEX = "<\\s*arg\\s+" + "(" + "(" + nameREGEX + "|"
			+ typeREGEX + ")" + "\\s*" + ")*" + "((/>)|(>\\s*</\\s*arg\\s*>))";
	static Pattern argPattern = Pattern.compile(argREGEX,
			Pattern.CASE_INSENSITIVE);

	static String appDefinitionREGEX = startAppREGEX + ".*?" + endAppREGEX;
	static Pattern appDefinitionPattern = Pattern.compile(appDefinitionREGEX,
			Pattern.CASE_INSENSITIVE);

	public static class Argument implements Serializable {
		String name;
		String type;

		public Argument(String name, String type) {
			this.name = name;
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public String getType() {
			return type;
		}

		public String toString() {
			return name + ":" + type;
		}
	}

	public static void defineApplication(RmiServerEnd serverEnd, String server,
			String configFile) throws IOException, CollaborativeException {
		defineApplication(serverEnd, server, new File(configFile));
	}

	public static void defineApplication(RmiServerEnd serverEnd, String server,
			File configFile) throws IOException, CollaborativeException {
		StringBuffer strBuf = new StringBuffer();

		BufferedReader in = new BufferedReader(new FileReader(configFile));
		String line = in.readLine();
		while (line != null) {
			strBuf.append(line);
			line = in.readLine();
		}

		String configContents = strBuf.toString();

		Matcher appDefinitionMatcher = appDefinitionPattern
				.matcher(configContents);
		while (appDefinitionMatcher.find()) {
			// System.out.println(appDefinitionMatcher.group());
			parseApplicationDefinition(serverEnd, server,
					appDefinitionMatcher.group());
		}
	}

	private static void parseApplicationDefinition(RmiServerEnd serverEnd,
			String server, String definition) throws RemoteException,
			CollaborativeException {

		Matcher startAppMatcher = startAppPattern.matcher(definition);
		startAppMatcher.find();
		String appName = startAppMatcher.group();
		appName = appName.substring(appName.indexOf("\"") + 1,
				appName.lastIndexOf("\""));
		System.out.println(appName);

		ArrayList<String> programs = new ArrayList<String>();
		Matcher programMatcher = programPattern.matcher(definition);
		while (programMatcher.find()) {
			String program = programMatcher.group();
			program = program.substring(program.indexOf("\"") + 1,
					program.lastIndexOf("\""));

			programs.add(program);
		}
		System.out.println(programs);

		ArrayList<String> sharedWidgetListeners = new ArrayList<String>();
		Matcher widgetMatcher = widgetPattern.matcher(definition);
		while (widgetMatcher.find()) {
			String widget = widgetMatcher.group();
			widget = widget.substring(widget.indexOf("\"") + 1,
					widget.lastIndexOf("\""));

			sharedWidgetListeners.add(widget);
		}
		System.out.println(sharedWidgetListeners);

		ArrayList<Argument> arguments = new ArrayList<Argument>();
		Matcher argMatcher = argPattern.matcher(definition);
		while (argMatcher.find()) {
			String arg = argMatcher.group();

			Matcher nameMatcher = namePattern.matcher(arg);
			Matcher typeMatcher = typePattern.matcher(arg);

			String argName = null;
			String argType = null;

			if (nameMatcher.find()) {
				argName = nameMatcher.group();
				argName = argName.substring(argName.indexOf("\"") + 1,
						argName.lastIndexOf("\""));
			}

			if (typeMatcher.find()) {
				argType = typeMatcher.group();
				argType = argType.substring(argType.indexOf("\"") + 1,
						argType.lastIndexOf("\""));
			}

			arguments.add(new Argument(argName, argType));
		}
		System.out.println(arguments);

		System.out.println();

		String port = ADistributedRMIWidgetServer.extractPort(server);

		if (serverEnd == null) {
			RmiServerEnd registrar = NameServerStarter.getRegistrar(server,
					port);
			registrar.registerApplication(appName, programs,
					sharedWidgetListeners, arguments);
		} else {
			serverEnd.registerApplication(appName, programs,
					sharedWidgetListeners, arguments);
		}
	}

	public static void startApplication(String server) throws IOException,
			CollaborativeException {
		startApplication(server, (File) null);
	}

	public static void startApplication(String server, String configFile)
			throws IOException, CollaborativeException {
		if (configFile != null) {
			startApplication(server, new File(configFile));
		} else {
			startApplication(server, (File) null);
		}
	}

	public static void startApplication(String server, File configFile)
			throws IOException, CollaborativeException {
		NameServerStarter start = null;
		String port = ADistributedRMIWidgetServer.extractPort(server);

		RmiServerEnd rmiServerEnd = NameServerStarter
				.getRegistrar(server, port);
		if (rmiServerEnd == null) {
			start = new NameServerStarter(server, port);
			rmiServerEnd = start.getServerEnd();
			start.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (configFile != null) {
			defineApplication(rmiServerEnd, server, configFile);
		}
	}

	public static void main(String[] args) throws IOException,
			CollaborativeException {
		startApplication("127.0.0.1:15151",
				"/home/bartizzi/virtualToolkitConfig.txt");
		// defineApplication("/home/bartizzi/virtualToolkitConfig.txt");
	}
}
