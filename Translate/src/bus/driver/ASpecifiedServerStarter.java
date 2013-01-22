package bus.driver;

import java.io.IOException;

import bus.uigen.widgets.distributed.server.ApplicationStarter;
import bus.uigen.widgets.exceptions.CollaborativeException;

public class ASpecifiedServerStarter {

	public static void main(String[] args) throws CollaborativeException,
			IOException {
		ApplicationStarter.startApplication("127.0.0.1:15151",
				"translateConfig.txt");
	}
}
