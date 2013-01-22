package bus.uigen.widgets;

public class FrameSelector {
	public static final String COMMAND = ".create(";

	static FrameFactory factory;

	// static PanelFactory factory = new AWTPanelFactory();

	public static void setFrameFactory(FrameFactory newVal) {
		factory = newVal;
	}

	public static VirtualFrame createFrame() {
		String widgetID = VirtualToolkit.getDefaultObjectID();
		VirtualFrame toReturn = execCreate(widgetID);
		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualFrame.COMMAND_LABEL + widgetID + COMMAND
					+ ")";
			VirtualToolkit.sendCommandByDefault(command);
		}

		return toReturn;

	}

	public static VirtualFrame execCreate(String widgetID) {
		if (!VirtualToolkit.containObjIDByDefault(widgetID)) {
			VirtualFrame toReturn = factory.createFrame();
			if (widgetID != null) {
				VirtualToolkit.defaultAssociate(widgetID, toReturn);
				toReturn.execSetName(widgetID);
			}
			return toReturn;
		} else {
			return (VirtualFrame) VirtualToolkit.getDefaultObjectByID(widgetID);
		}
	}

	public static VirtualFrame createFrame(String title) {
		String widgetID = VirtualToolkit.getDefaultObjectID();
		VirtualFrame toReturn = execCreate(widgetID, title);

		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualFrame.COMMAND_LABEL + widgetID + COMMAND
					+ title + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}

		return toReturn;

	}

	public static VirtualFrame execCreate(String widgetID, String title) {
		if (!VirtualToolkit.containObjIDByDefault(widgetID)) {
			VirtualFrame toReturn = factory.createFrame(title);
			if (widgetID != null) {
				VirtualToolkit.defaultAssociate(widgetID, toReturn);
				toReturn.execSetName(widgetID);
			}
			return toReturn;
		} else {
			return (VirtualFrame) VirtualToolkit.getDefaultObjectByID(widgetID);
		}
	}

}