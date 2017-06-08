package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class TagsAndCategoriesTab extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final String ACTION_COMMAND_ADD_INGREDIENT_CATEGORY = "addIngredientCategory";
	public static final String ACTION_COMMAND_DELETE_INGREDIENT_CATEGORY = "deleteIngredientCategory";
	public static final String ACTION_COMMAND_ADD_RECIPE_CATEGORY = "addRecipeCategory";
	public static final String ACTION_COMMAND_DELETE_RECIPE_CATEGORY = "deleteRecipeCategory";
	public static final String ACTION_COMMAND_ADD_TAG = "addTag";
	public static final String ACTION_COMMAND_DELETE_TAG = "deleteTag";

	private JButton addIngredientCategoryButton = new AddButton(ACTION_COMMAND_ADD_INGREDIENT_CATEGORY);
	private JButton deleteIngredientCategoryButton = new DeleteButton(ACTION_COMMAND_DELETE_INGREDIENT_CATEGORY);
	private JButton addRecipeCategoryButton = new AddButton(ACTION_COMMAND_ADD_RECIPE_CATEGORY);
	private JButton deleteRecipeCategoryButton = new DeleteButton(ACTION_COMMAND_DELETE_RECIPE_CATEGORY);
	private JButton addTagButton = new AddButton(ACTION_COMMAND_ADD_TAG);
	private JButton deleteTagButton = new DeleteButton(ACTION_COMMAND_DELETE_TAG);

	private JSplitPane centerSplitPane = new JSplitPane();
	private JSplitPane leftSplitPane = new JSplitPane(); 

	public TagsAndCategoriesTab() {
		setLayout(new BorderLayout());

		createThreePartSplitPane();

		configureLeftArea();
		configureCenterArea();
		configureRightArea();
	}

	private void createThreePartSplitPane() {
		add(centerSplitPane);
		centerSplitPane.setLeftComponent(leftSplitPane);

		// Guarantees that all three areas have the same size.
		centerSplitPane.setResizeWeight(0.66);
		leftSplitPane.setResizeWeight(0.5);
	}

	private void configureLeftArea() {
		String[] ingredientCategoriesColumnNames = {"Ingredient Category"};
		Object[][] ingredientCategoriesData = {{"Obst"}, {"Gemüse"}, {"Nüsse"}, {"Samen"}, {"Getreide"}};
		JTable leftTable = new JTable(ingredientCategoriesData, ingredientCategoriesColumnNames);

		JPanel leftPanel = new TablePanel(leftTable, true, addIngredientCategoryButton, deleteIngredientCategoryButton);
		leftSplitPane.setLeftComponent(leftPanel);
	}
	private void configureCenterArea() {
		String[] recipeCategoriesColumnNames = {"Recipe Category"};
		Object[][] recipeCategoriesData = {{"Salate"}, {"Suppen"}, {"Süßspeisen"}, {"Soßen"}, {"Hauptgerichte"}};
		JTable centerTable = new JTable(recipeCategoriesData, recipeCategoriesColumnNames);

		JPanel centerPanel = new TablePanel(centerTable, true, addRecipeCategoryButton, deleteRecipeCategoryButton);
		leftSplitPane.setRightComponent(centerPanel);
	}
	private void configureRightArea() {
		String[] tagsColumnNames = {"Tag", "Ingredient", "Recipe", "Carry Over"};
		Object[][] tagsData = {
				{"Vegan", new Boolean(true), new Boolean(true), new Boolean(true)},
				{"Vegetarian", new Boolean(true), new Boolean(true), new Boolean(true)},
				{"Grünes Gemüse", new Boolean(true), new Boolean(false), new Boolean(false)}
		};
		JTable rightTable = new JTable(tagsData, tagsColumnNames);

		JPanel rightPanel = new TablePanel(rightTable, true, addTagButton, deleteTagButton);
		centerSplitPane.setRightComponent(rightPanel);
	}

	public JButton getAddIngredientCategoryButton() {
		return addIngredientCategoryButton;
	}

	public JButton getDeleteIngredientCategoryButton() {
		return deleteIngredientCategoryButton;
	}

	public JButton getAddRecipeCategoryButton() {
		return addRecipeCategoryButton;
	}

	public JButton getDeleteRecipeCategoryButton() {
		return deleteRecipeCategoryButton;
	}

	public JButton getAddTagButton() {
		return addTagButton;
	}

	public JButton getDeleteTagButton() {
		return deleteTagButton;
	}

}
