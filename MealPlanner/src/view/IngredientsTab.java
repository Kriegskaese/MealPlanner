package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class IngredientsTab extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final String ACTION_COMMAND_ADD_INGREDIENT = "addIngredient";
	public static final String ACTION_COMMAND_DELETE_INGREDIENT = "deleteIngredient";

	private JTable ingredientsTable;
	private JButton addButton = new AddButton(ACTION_COMMAND_ADD_INGREDIENT);
	private JButton deleteButton = new DeleteButton(ACTION_COMMAND_DELETE_INGREDIENT);
	private JTextField searchBarTextField = new JTextField();

	public IngredientsTab(JTable ingredientsTable) {
		setLayout(new BorderLayout());

		TablePanel tablePanel = new TablePanel(ingredientsTable, true , addButton, deleteButton);
		add(tablePanel);

		JPanel searchBarPanel = new SearchBarPanel(searchBarTextField);
		tablePanel.getTopPanel().add(searchBarPanel, BorderLayout.LINE_END);
	}

	public JTable getIngredientsTable() {
		return ingredientsTable;
	}

	public JTextField getSearchBarTextField() {
		return searchBarTextField;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

}
