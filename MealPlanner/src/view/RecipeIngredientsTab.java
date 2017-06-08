package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class RecipeIngredientsTab extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] ingredientsColumnNames = {"Amount [g]", "Ingredient"};
	private Object[][] ingredientsData = {
			{new Integer(150), "Rice"},
			{new Integer(150), "Red Lentils"},
			{new Integer(2), "Tomato"},
			{null, "Salt"}
	};

	public static final String ACTION_COMMAND_ADD_INGREDIENT = "addIngredient";
	public static final String ACTION_COMMAND_DELETE_INGREDIENT = "deleteIngredient";
	public static final String ACTION_COMMAND_DISPLAY_FULL_SIZE_IMAGE = "displayFullSizeImage";

	private JTable ingredientsTable = new JTable(ingredientsData, ingredientsColumnNames);
	private JButton addIngredientButton = new AddButton(ACTION_COMMAND_ADD_INGREDIENT);
	private JButton deleteIngredientButton = new DeleteButton(ACTION_COMMAND_DELETE_INGREDIENT);
	private JButton imageButton = new Button(ACTION_COMMAND_DISPLAY_FULL_SIZE_IMAGE);
	private JPanel topPanel = new JPanel();
	private JPanel imagePanel = new ImagePanel(imageButton, "/home/hermannc/Downloads/vegan-burritos-200px.jpg", "no Image", new Dimension(200, 200));

	public RecipeIngredientsTab() {
		setLayout(new BorderLayout());

		add(topPanel, BorderLayout.NORTH);
		configureTopPanel();

		TablePanel tablePanel = new TablePanel(ingredientsTable, false, addIngredientButton, deleteIngredientButton);
		add(tablePanel);
	}

	private void configureTopPanel() {
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.setPreferredSize(new Dimension(200, 200));

		addAndAlignImagePanel();
	}

	private void addAndAlignImagePanel() {
		topPanel.add(Box.createVerticalGlue());
		topPanel.add(imagePanel);
		topPanel.add(Box.createVerticalGlue());
		imagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	}

}
