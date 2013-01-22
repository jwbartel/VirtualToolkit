package bus.uigen.widgets;public class PanelSelector {	public static final String COMMAND = ".create(";	static PanelFactory factory;	// static PanelFactory factory = new AWTPanelFactory();	public static void setPanelFactory(PanelFactory newVal) {		factory = newVal;	}	public static VirtualContainer createPanel() {		String widgetID = VirtualToolkit.getDefaultObjectID();		VirtualContainer toReturn = execCreate(widgetID);		if (VirtualToolkit.isDistributedByDefault()) {			String command = VirtualContainer.COMMAND_LABEL + widgetID					+ COMMAND + ")";			VirtualToolkit.sendCommandByDefault(command);		}		return toReturn;	}	public static VirtualContainer execCreate(String widgetID) {		if (!VirtualToolkit.containObjIDByDefault(widgetID)) {			VirtualContainer toReturn = factory.createPanel();			if (widgetID != null) {				VirtualToolkit.defaultAssociate(widgetID, toReturn);				toReturn.execSetName(widgetID);			}			return toReturn;		} else {			return (VirtualContainer) VirtualToolkit					.getDefaultObjectByID(widgetID);		}	}}