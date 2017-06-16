package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabelTextFieldPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JTextField textField = new JTextField();

	public LabelTextFieldPanel(String labelName) {
		setLayout(new BorderLayout());

		JLabel label = new JLabel(labelName);
		add(label, BorderLayout.LINE_START);

		textField.setPreferredSize(new Dimension(200, 24));
		add(textField, BorderLayout.LINE_END);
	}

}
