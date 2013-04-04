package bus.uigen.widgets.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import bus.uigen.widgets.AMatrixMap;
import bus.uigen.widgets.MatrixMap;


public class CustomizableSwingCellRenderer extends DefaultTableCellRenderer {
	MatrixMap<String> cellToTooltipText = new AMatrixMap();
	MatrixMap<Font> cellToFont = new AMatrixMap();
	MatrixMap<Color> cellToBackground = new AMatrixMap();
	MatrixMap<Color> cellToForeground = new AMatrixMap();

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component component = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
	

		return this;
	}
	
	void setComponentAttributes(int aRow, int aColumn, Component aComponent) {
		setComponentToolTip(aRow, aColumn, aComponent);
		setComponentFont(aRow, aColumn, aComponent);
		setComponentForeground(aRow, aColumn, aComponent);
		setComponentBackground(aRow, aColumn, aComponent);		
	}
	
	void setComponentToolTip(int aRow, int aColumn, Component aComponent) {
		String toolTipText = cellToTooltipText.get(aRow, aColumn);
		if (toolTipText != null && aComponent instanceof JComponent) {
			((JComponent) aComponent).setToolTipText(toolTipText);			
		}
	}
	
	void setComponentFont(int aRow, int aColumn, Component aComponent) {
		Font font = cellToFont.get(aRow, aColumn);
		if (font != null)
			aComponent.setFont(font);
	}
	
	void setComponentBackground(int aRow, int aColumn, Component aComponent) {
		Color background = cellToBackground.get(aRow, aColumn);
		if (background != null)
			aComponent.setBackground(background);
	}
	
	void setComponentForeground(int aRow, int aColumn, Component aComponent) {
		Color foreground = cellToForeground.get(aRow, aColumn);
		if (foreground != null)
			aComponent.setForeground(foreground);
	}
	
	String toString(int aRow, int aCol) {
		return aRow + "," + aCol;
	}
	public void setTooltipText (int aRow, int aCol, String newVal) {
		cellToTooltipText.put(aRow, aCol, newVal);
	}
	public void setFont (int aRow, int aCol, Font newVal) {
		cellToFont.put(aRow, aCol, newVal);
	}
	public void setBackground (int aRow, int aCol, Color newVal) {
		cellToBackground.put(aRow, aCol, newVal);
	}
	
	public void setForeground (int aRow, int aCol, Color newVal) {
		cellToBackground.put(aRow, aCol, newVal);
	}
	
	


}
