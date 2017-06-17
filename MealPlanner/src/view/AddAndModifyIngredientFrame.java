package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ingredient;

public class AddAndModifyIngredientFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final String ACTION_COMMAND_CANCEL = "cancel";
	public static final String ACTION_COMMAND_OK = "ok";

	private JButton cancelButton = new CancelButton(ACTION_COMMAND_CANCEL);
	private JButton okButton = new OkButton(ACTION_COMMAND_OK);
	private JPanel contentPanel = new JPanel();
	private List<JTextField> textFields;

	public AddAndModifyIngredientFrame(List<String> labelNames) {
		// configure the frame
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// configure the content panel
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		add(contentPanel);
		createContent(labelNames);

		// configure the buttons panel
		JPanel buttonsPanel = new CancelAndOkButtonPanel(cancelButton, okButton);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	private void createContent(List<String> labelNames) {
		for (String labelName : labelNames) {
			LabelTextFieldPanel panel = new LabelTextFieldPanel(labelName);
			contentPanel.add(panel);
			textFields.add(panel.getTextField());
			if(labelName.equals("id")) {
				int currentId = Ingredient.getCurrentId();
				panel.getTextField().setText(Integer.toString(currentId));
				panel.getTextField().setEnabled(false);
			}
		}
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public List<JTextField> getTextFields() {
		return textFields;
	}

}
