package view;

import javax.swing.JButton;

public class Button extends JButton {

	private static final long serialVersionUID = 1L;

	public Button(String actionCommand, String text) {
		setText(text);
		setActionCommand(actionCommand);
	}

	public Button(String actionCommand) {
		setActionCommand(actionCommand);
	}

}
