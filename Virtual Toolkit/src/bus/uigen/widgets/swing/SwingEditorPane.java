package bus.uigen.widgets.swing;

import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkListener;

import bus.uigen.widgets.VirtualEditorPane;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingEditorPane extends SwingTextComponent implements
		VirtualEditorPane {
	public SwingEditorPane(JEditorPane editorPane) {
		init(editorPane);
	}

	public SwingEditorPane() {
	}

	public JEditorPane getJEditorPane() {
		return (JEditorPane) getComponent();
	}

	public static SwingEditorPane virtualEditorPane(JEditorPane theTextArea) {
		return (SwingEditorPane) AWTComponent.virtualComponent(theTextArea);

	}

	public URL getPage() {
		return getJEditorPane().getPage();
	}

	public void setPage(URL theURL) {
		try {
			getJEditorPane().setPage(theURL);
		} catch (Exception e) {
			e.fillInStackTrace();
		}

	}

	public void addHyperlinkListener(HyperlinkListener listener) {
		getJEditorPane().addHyperlinkListener(listener);
	}

	@Override
	public void addHyperlinkListener(Object listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPage(Object theURL) {
		// TODO Auto-generated method stub

	}

}
