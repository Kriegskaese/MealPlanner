package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CancelAndOkButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CancelAndOkButtonPanel(JButton canelButton, JButton okButton) {
		setLayout(new BorderLayout());

		JPanel buttonsArea = new JPanel();
		add(buttonsArea, BorderLayout.LINE_END);

		buttonsArea.setLayout(new BoxLayout(buttonsArea, BoxLayout.X_AXIS));

		buttonsArea.add(canelButton);
		buttonsArea.add(okButton);
	}

}
