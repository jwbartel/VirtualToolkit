package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.VirtualPopupMenu;
import bus.uigen.widgets.VirtualToolkit;

public class ForwarderFrame extends ForwarderContainer implements VirtualFrame {
	protected VirtualContainer contents = this;
	String title;

	public ForwarderFrame() {

	}

	public ForwarderFrame(String title) {
		this.title = title;
	}

	@Override
	public VirtualContainer getContentPane() {
		return contents;
	}

	@Override
	public void setContentPane(VirtualContainer container) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResizable(boolean newVal) {
		/*
		 * VirtualToolkit.sendCommandByDefault( VirtualFrame.COMMAND_LABEL +
		 * "setResizable(" + newVal + ")" );
		 */
	}

	@Override
	public void addWindowListener(Object newVal) {
		// TODO Auto-generated method stub

		// Implementation should make use of VirtualToolkit.sendListener.
	}

	@Override
	public void setTitle(String label) {
		this.title = label;

		if (VirtualToolkit.isDistributedByDefault()) {
			/*
			 * VirtualToolkit.sendCommandByDefault( VirtualFrame.COMMAND_LABEL +
			 * this.getName() +".setTitle(" + label + ")" );
			 */
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void dispose() {
		// VirtualToolkit.sendCommandByDefault(VirtualFrame.COMMAND_LABEL +
		// "dispose()");
	}

	@Override
	public VirtualMenuBar getMenuBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMenuBar(VirtualMenuBar newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComponentListener(Object cl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDefaultCloseOperation(int arg) {
		/*
		 * VirtualToolkit.sendCommandByDefault( VirtualToolkit.COMMAND_LABEL +
		 * "setDefaultCloseOperation(" + arg + ")" );
		 */
	}

	@Override
	public void add(VirtualPopupMenu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void asyncExec(Runnable runnable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void syncExec(Runnable runnable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open() {
		// VirtualToolkit.sendCommandByDefault(VirtualFrame.COMMAND_LABEL +
		// "open()");
	}
}
