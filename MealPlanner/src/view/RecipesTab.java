package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.IngredientTag;

public class RecipesTab extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] recipeColumnNames = {"Name", "Category", "Energy [Kcal/100g]", "Protein [g/100g]",
			"Fat [g/100g]", "Carbs [g/100g]", "Tags"};
	private Object[][] recipeData = {
			{"Chilli Sin Carne", "Main Dishes", new Integer(52), new Integer(4),
				new Integer(7), new Integer(32), new IngredientTag("vegan", false).getName()},
			{"Tomato Soup", "Soups", new Integer(32), new Integer(5),
					new Integer(5), new Integer(54), new IngredientTag("vegan", false).getName()}
	};

	public static final String ACTION_COMMAND_ADD_RECIPE = "addRecipe";
	public static final String ACTION_COMMAND_DELETE_RECIPE = "deleteRecipe";

	private JTable recipesTable = new JTable(recipeData, recipeColumnNames);
	private JButton addRecipeButton = new AddButton(ACTION_COMMAND_ADD_RECIPE);
	private JButton deleteRecipeButton = new DeleteButton(ACTION_COMMAND_DELETE_RECIPE);
	private JTextField recipeSearchBarTextField = new JTextField();
	private JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
	private TablePanel leftPanel = new TablePanel(recipesTable, true, addRecipeButton, deleteRecipeButton);
	private JTabbedPane rightPane = new JTabbedPane();

	public RecipesTab() {
		setLayout(new BorderLayout());

		add(splitPane);
		configureSplitPane();

		splitPane.setLeftComponent(leftPanel);
		configureLeftPanel();

		splitPane.setRightComponent(rightPane);
		configureRightPane();
	}

	private void configureSplitPane() {
		splitPane.setResizeWeight(1.0);
		splitPane.setOneTouchExpandable(true);
	}

	private void configureLeftPanel() {
		leftPanel.setMinimumSize(new Dimension(420, 50));

		JPanel searchBarPanel = new SearchBarPanel(recipeSearchBarTextField);
		leftPanel.getTopPanel().add(searchBarPanel, BorderLayout.LINE_END);
	}

	private void configureRightPane() {
		Dimension rightPaneSize = new Dimension(285, 50);
		rightPane.setMinimumSize(rightPaneSize);
		rightPane.setPreferredSize(rightPaneSize);

		rightPane.addTab("Ingredients", new RecipeIngredientsTab());
		rightPane.addTab("Preferences", new RecipePreferencesTab());
		rightPane.addTab("Notes", new NotesTab());
	}

	public JTable getRecipesTable() {
		return recipesTable;
	}

	public JButton getAddRecipeButton() {
		return addRecipeButton;
	}

	public JButton getDeleteRecipeButton() {
		return deleteRecipeButton;
	}

	public JTextField getRecipeSearchBarTextField() {
		return recipeSearchBarTextField;
	}

}
