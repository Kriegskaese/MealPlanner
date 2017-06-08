package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchBarPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SearchBarPanel(JTextField textField) {
		JLabel searchLabel = new JLabel("Search:");
		add(searchLabel);

		add(textField);
		textField.setPreferredSize(new Dimension(200, 24));
	}

}
