package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TablePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel topPanel = new JPanel();
	private JPanel topLeftPanel = new JPanel();

	public TablePanel(JTable table, Boolean isSortable, JButton button1, JButton button2) {
		setLayout(new BorderLayout());

		createScrollableTable(table, isSortable);
		createTopLeftPanel();

		topLeftPanel.add(button1);
		topLeftPanel.add(button2);
	}

	public TablePanel(JTable table, Boolean isSortable, JButton button1, JButton button2, JButton button3, JButton button4) {
		setLayout(new BorderLayout());

		createScrollableTable(table, isSortable);
		createTopLeftPanel();

		topLeftPanel.add(button1);
		topLeftPanel.add(button2);
		topLeftPanel.add(button3);
		topLeftPanel.add(button4);
	}

	private void createScrollableTable(JTable table, boolean isSortable) {
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		scrollPane.setViewportView(table);

		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.changeSelection(0, 0, false, false);

		if(isSortable) {
			table.setAutoCreateRowSorter(true);
		}
	}

	private void createTopLeftPanel() {
		add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout());

		topPanel.add(topLeftPanel, BorderLayout.LINE_START);
	}

	public JPanel getTopPanel() {
		return topPanel;
	}

}
