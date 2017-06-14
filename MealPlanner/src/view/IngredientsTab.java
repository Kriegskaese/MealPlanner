package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.IngredientCategory;
import model.IngredientTag;

public class IngredientsTab extends JPanel {

	private static final long serialVersionUID = 1L;

	/*
	private String[] columnNames = {"Name", "Category", "Energy [Kcal/100g]", "Protein [g/100g]",
			"Fat [g/100g]", "Carbs [g/100g]", "Tags"};
	private Object[][] data = {
			{"Apple", new IngredientCategory("Fruits").getName(), new Integer(52), new Integer(4),
				new Integer(7), new Integer(32), new IngredientTag("vegan", false).getName()},
			{"Banana", new IngredientCategory("Fruits").getName(), new Integer(32), new Integer(5),
					new Integer(5), new Integer(54), new IngredientTag("vegan", false).getName()},
			{"Strawberry", new IngredientCategory("Fruits").getName(), new Integer(45), new Integer(2),
						new Integer(12), new Integer(11), new IngredientTag("vegan", false).getName()},
			{"Peach", new IngredientCategory("Fruits").getName(), new Integer(23), new Integer(9),
							new Integer(10), new Integer(34), new IngredientTag("vegan", false).getName()},
			{"Carrot", new IngredientCategory("Vegetables").getName(), new Integer(12), new Integer(2),
								new Integer(3), new Integer(12), new IngredientTag("vegan", false).getName()},
			{"Brokkoli", new IngredientCategory("Vegetables").getName(), new Integer(12), new Integer(2),
									new Integer(3), new Integer(12), new IngredientTag("vegan", false).getName() + ", " +
											new IngredientTag("green", false).getName()}
	};
	*/

	public static final String ACTION_COMMAND_ADD_INGREDIENT = "addIngredient";
	public static final String ACTION_COMMAND_DELETE_INGREDIENT = "deleteIngredient";

	private JTable ingredientsTable;
	private JButton addButton = new AddButton(ACTION_COMMAND_ADD_INGREDIENT);
	private JButton deleteButton = new DeleteButton(ACTION_COMMAND_DELETE_INGREDIENT);
	private JTextField searchBarTextField = new JTextField();

	public IngredientsTab(JTable table) {
		ingredientsTable = table;

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
