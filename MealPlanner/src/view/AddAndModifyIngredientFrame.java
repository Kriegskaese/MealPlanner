package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddAndModifyIngredientFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final String ACTION_COMMAND_CANCEL = "cancel";
	public static final String ACTION_COMMAND_OK = "ok";

	private JButton cancelButton = new CancelButton(ACTION_COMMAND_CANCEL);
	private JButton okButton = new OkButton(ACTION_COMMAND_OK);
	private JPanel PropertiesPanel = new JPanel();

	public AddAndModifyIngredientFrame() {
		setLayout(new BorderLayout());

		PropertiesPanel.setLayout(new BoxLayout(PropertiesPanel, BoxLayout.Y_AXIS));
		PropertiesPanel.setBackground(Color.CYAN);
		add(PropertiesPanel);

		JPanel ButtonsPanel = new CancelAndOkButtonPanel(cancelButton, okButton);
		add(ButtonsPanel, BorderLayout.SOUTH);

	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JPanel getPropertiesPanel() {
		return PropertiesPanel;
	}

}
