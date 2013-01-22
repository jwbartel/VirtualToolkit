package bus.uigen.widgets;

public class GridLayoutSelector {
	public static final String COMMAND = ".create(";
	static GridLayoutFactory factory;

	public static void setGridLayoutFactory(GridLayoutFactory newVal) {
		factory = newVal;
	}

	public static VirtualGridLayout createLayout() {
		String layoutID = VirtualToolkit.getDefaultObjectID();
		VirtualGridLayout toReturn = execCreate(layoutID);

		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualGridLayout.COMMAND_LABEL + layoutID
					+ COMMAND + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}

		return toReturn;
	}

	public static VirtualGridLayout execCreate(String layoutID) {
		if (!VirtualToolkit.containObjIDByDefault(layoutID)) {
			VirtualGridLayout toReturn = factory.createLayout();
			if (layoutID != null) {
				VirtualToolkit.defaultAssociate(layoutID, toReturn);
				toReturn.setName(layoutID);
			}
			return toReturn;
		} else {
			return (VirtualGridLayout) VirtualToolkit
					.getDefaultObjectByID(layoutID);
		}

	}

	public static VirtualGridLayout createLayout(int rows, int cols) {
		String layoutID = VirtualToolkit.getDefaultObjectID();
		VirtualGridLayout toReturn = execCreate(layoutID, rows, cols);

		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualGridLayout.COMMAND_LABEL + layoutID
					+ COMMAND + rows + "," + cols + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}

		return toReturn;
	}

	public static VirtualGridLayout execCreate(String layoutID, int rows,
			int cols) {
		if (!VirtualToolkit.containObjIDByDefault(layoutID)) {
			VirtualGridLayout toReturn = factory.createLayout(rows, cols);
			if (layoutID != null) {
				VirtualToolkit.defaultAssociate(layoutID, toReturn);
				toReturn.setName(layoutID);
			}
			return toReturn;
		} else {
			return (VirtualGridLayout) VirtualToolkit
					.getDefaultObjectByID(layoutID);
		}
	}
}