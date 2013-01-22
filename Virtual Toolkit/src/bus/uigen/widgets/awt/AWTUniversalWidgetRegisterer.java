package bus.uigen.widgets.awt;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuComponent;
import java.awt.MenuContainer;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;

import bus.uigen.widgets.UniversalWidgetRegisterer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class AWTUniversalWidgetRegisterer implements UniversalWidgetRegisterer {

	protected static boolean registered = false;

	public void registerUniversalWidgetClasses() {
		if (registered)
			return;
		registered = true;
		CentralUniversalWidget.register(Button.class, AWTButton.class);
		CentralUniversalWidget.register(Component.class, AWTComponent.class);
		CentralUniversalWidget.register(Container.class, AWTContainer.class);
		CentralUniversalWidget.register(Applet.class, AWTContainer.class); // do
																			// we
																			// need
																			// this?
		CentralUniversalWidget.register(Frame.class, AWTFrame.class);
		// register (JPanel.class, ASwingPanel.class);
		CentralUniversalWidget.register(Label.class, AWTLabel.class);
		CentralUniversalWidget.register(TextField.class, AWTTextField.class);
		CentralUniversalWidget.register(TextArea.class, AWTTextArea.class);
		CentralUniversalWidget.register(Button.class, AWTButton.class);
		CentralUniversalWidget.register(ScrollPane.class, AWTScrollPane.class);
		CentralUniversalWidget.register(MenuComponent.class,
				AWTMenuComponent.class);
		CentralUniversalWidget.register(MenuContainer.class,
				AWTMenuContainer.class);
		CentralUniversalWidget.register(MenuItem.class, AWTMenuItem.class);
		CentralUniversalWidget.register(Menu.class, AWTMenu.class);
		CentralUniversalWidget.register(PopupMenu.class, AWTPopupMenu.class);
		CentralUniversalWidget.register(MenuBar.class, AWTMenuBar.class);
		CentralUniversalWidget.register(DelegatePanel.class,
				AWTDelegatePanel.class);
	}
}
