package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
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

	private List<String> labelNames;
	private JButton cancelButton = new CancelButton(ACTION_COMMAND_CANCEL);
	private JButton okButton = new OkButton(ACTION_COMMAND_OK);
	private JPanel contentPanel = new JPanel();
	private List<JTextField> textFields = new ArrayList<JTextField>();

	//***************************** Constructor(s) *****************************

	public AddAndModifyIngredientFrame(List<String> labelNames) {
		this.labelNames = labelNames;

		configureFrame();
		configureContentPanel();
		configureButtonsPanel();
	}

	//*********************** Internal Helper Method(s) ************************

	private void configureFrame() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void configureContentPanel() {
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		add(contentPanel);

		createContent(labelNames);
	}

	private void configureButtonsPanel() {
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

	//************************ Getter(s) and Setter(s) *************************

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
