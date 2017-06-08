package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ShoppingListsTab_ extends JPanel {

	private static final long serialVersionUID = 1L;

	public ShoppingListsTab_() {
		setLayout(new BorderLayout());
		
		JPanel leftPanel = new JPanel();
		add(leftPanel, BorderLayout.LINE_START);
		leftPanel.setLayout(new BorderLayout());
		
		JPanel shoppingListsPanel = new JPanel();
		leftPanel.add(shoppingListsPanel, BorderLayout.NORTH);
		shoppingListsPanel.setLayout(new BoxLayout(shoppingListsPanel, BoxLayout.Y_AXIS));
		
		JPanel entry1 = createShoppingListEntry("Einkaufsliste Montag");
		shoppingListsPanel.add(entry1);
		
		JPanel entry2 = createShoppingListEntry("Einkaufsliste Mittwoch");
		shoppingListsPanel.add(entry2);
		
		JPanel entry3 = createShoppingListEntry("Einkaufsliste Samstag");
		shoppingListsPanel.add(entry3);
		
		JScrollPane rightPane = new JScrollPane();
		add(rightPane);
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		
		JTextArea textArea = new JTextArea("100g\tReis\n200g\tRote Linsen\n    2\tTomaten\n\tOregano");
		rightPanel.add(textArea);
		rightPane.setViewportView(rightPanel);
		
		textArea.setEditable(false);
	}
	
	private JPanel createShoppingListEntry(String name) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JCheckBox checkBox = new JCheckBox();
		panel.add(checkBox, BorderLayout.LINE_START);
		
		JLabel label = new JLabel(name);
		panel.add(label);
		
		return panel;
	}
	
}
