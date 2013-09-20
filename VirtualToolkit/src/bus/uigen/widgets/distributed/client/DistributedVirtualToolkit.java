package bus.uigen.widgets.distributed.client;

import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.gwt.GWTToolkit;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

public class DistributedVirtualToolkit implements EntryPoint {

	static VirtualTextField field;

	static class CalcButtonListener implements VirtualActionListener {
		String valueToWrite;

		public CalcButtonListener() {

		}

		public CalcButtonListener(String value) {
			this.valueToWrite = value;
		}

		public void actionPerformed(VirtualActionEvent e) {
			String fieldText = field.getText();
			String textToSet;
			if (fieldText.equals("ERROR")) {
				textToSet = valueToWrite;
			} else {
				textToSet = fieldText + valueToWrite;
			}
			field.setText(textToSet);
		}
	}

	public static String eval(String input) {
		String numberRegex = "(([0-9]+([.][0-9]+)?)|([.][0-9]+))";
		String opRegex = "[+x/-]";
		String computableRegex = numberRegex + "(" + opRegex + numberRegex
				+ ")*";
		MatchResult result = RegExp.compile(computableRegex).exec(input);
		if (result == null || result.getGroup(0).length() != input.length()) {
			return "ERROR";
		}

		boolean useInt = true;
		int intResult = 0;
		double doubleResult = 0.0;

		int pos = 0;
		String[] nums = input.split(opRegex);

		Character op = null;

		for (int i = 0; i < nums.length; i++) {
			if (pos != 0) {
				op = input.charAt(pos);
				pos++;
			}

			if (nums[i].contains(".") || !useInt) {
				if (useInt) {
					doubleResult = intResult;
					useInt = false;
				}
				if (op == null) {
					doubleResult = Double.parseDouble(nums[i]);
				} else if (op == '+') {
					doubleResult += Double.parseDouble(nums[i]);
				} else if (op == '-') {
					doubleResult -= Double.parseDouble(nums[i]);
				} else if (op == 'x') {
					doubleResult *= Double.parseDouble(nums[i]);
				} else if (op == '/') {
					doubleResult = doubleResult / Double.parseDouble(nums[i]);
				}

				pos += nums[i].length();
			} else {
				if (op == null) {
					intResult = Integer.parseInt(nums[i]);
				} else if (op == '+') {
					intResult += Integer.parseInt(nums[i]);
				} else if (op == '-') {
					intResult -= Integer.parseInt(nums[i]);
				} else if (op == 'x') {
					intResult *= Integer.parseInt(nums[i]);
				} else if (op == '/') {
					int numVal = Integer.parseInt(nums[i]);
					if (intResult % numVal == 0) {
						intResult = intResult / numVal;
					} else {
						doubleResult = ((double) intResult) / ((double) numVal);
						useInt = false;
					}
				}

				pos += nums[i].length();
			}

		}

		if (useInt) {
			return "" + intResult;
		} else {
			return "" + doubleResult;
		}

	}

	static class EvalListener implements VirtualActionListener {
		String fieldID;

		public EvalListener() {

		}

		public EvalListener(VirtualTextField field) {
			fieldID = field.getName();
		}

		public void actionPerformed(VirtualActionEvent e) {
			String textToSolve = ((VirtualTextField) VirtualToolkit
					.getDefaultObjectByID(fieldID)).getText();
			String solution = eval(textToSolve);
			((VirtualTextField) VirtualToolkit.getDefaultObjectByID(fieldID))
					.setText(solution);
		}

	}

	static VirtualTextField buildCalcField() {
		// Create a textfield to display the results of the calculator
		field = TextFieldSelector.createTextField();
		field.centralizeListeners(false);
		field.addActionListener(new EvalListener(field));
		return field;
	}

	static VirtualContainer buildButtonPanel(String b1, String b2, String b3,
			String b4) {
		// Create a panel of 4 buttons for the calculator
		VirtualContainer container = PanelSelector.createPanel();
		container.setLayout(GridLayoutSelector.createLayout(1, 4));
		container.add(buildCalcButton(b1));
		container.add(buildCalcButton(b2));
		container.add(buildCalcButton(b3));
		container.add(buildCalcButton(b4));
		return container;
	}

	static VirtualButton buildCalcButton(String text) {
		// Create a button to update the text field
		VirtualButton button = ButtonSelector.createButton(text);
		if (text.equals("="))
			button.addActionListener(new EvalListener(field));
		else
			button.addActionListener(new CalcButtonListener(text));
		return button;
	}

	static void buildGUI() {

		VirtualFrame frame = FrameSelector.createFrame("Calculator");
		frame.setSize(200, 200);
		frame.setLayout(GridLayoutSelector.createLayout(5, 1));

		frame.add(buildCalcField());

		frame.add(buildButtonPanel("1", "2", "3", "+"));
		frame.add(buildButtonPanel("4", "5", "6", "-"));
		frame.add(buildButtonPanel("7", "8", "9", "x"));
		frame.add(buildButtonPanel(".", "0", "/", "="));

		/*
		 * VirtualContainer button1 = PanelSelector.createPanel();
		 * button1.setLayout(GridLayoutSelector.createLayout(1,4));
		 * /*VirtualContainer button2 = PanelSelector.createPanel();
		 * //button2.setLayout(GridLayoutSelector.createLayout(1,4));
		 * VirtualContainer button3 = PanelSelector.createPanel();
		 * //button3.setLayout(GridLayoutSelector.createLayout(1,4));
		 * VirtualContainer button4 = PanelSelector.createPanel();
		 * //button4.setLayout(GridLayoutSelector.createLayout(1,4));
		 * 
		 * 
		 * frame.add(button1); /*frame.add(button2); frame.add(button3);
		 * frame.add(button4);
		 */

		/*
		 * button1.add(buildCalcButton("1")); button1.add(buildCalcButton("2"));
		 * button1.add(buildCalcButton("3")); button1.add(buildCalcButton("+"));
		 * 
		 * button2.add(buildCalcButton("4")); button2.add(buildCalcButton("5"));
		 * button2.add(buildCalcButton("6")); button2.add(buildCalcButton("-"));
		 * 
		 * button3.add(buildCalcButton("7")); button3.add(buildCalcButton("8"));
		 * button3.add(buildCalcButton("9")); button3.add(buildCalcButton("x"));
		 * 
		 * 
		 * button4.add(buildCalcButton(".")); button4.add(buildCalcButton("0"));
		 * button4.add(buildCalcButton("÷")); VirtualButton equals =
		 * ButtonSelector.createButton("=");
		 * equals.blockActionEventForwarding(true); equals.addActionListener(new
		 * CalculatorListener(field)); button4.add(equals);
		 */

		VirtualToolkit.start(frame);

	}

	public void onModuleLoad() {
		VirtualToolkit.setDefaultToolkit(new GWTToolkit()); // true,
															// "desktop"));

		buildGUI();

		// VirtualToolkit.start(null);

	}

	public static void main(String[] args) {
		// VirtualToolkit.setDefaultToolkit(new AWTToolkit(true, "desktop"));
		// buildGUI();

		// VirtualToolkit.start(null);

	}

}