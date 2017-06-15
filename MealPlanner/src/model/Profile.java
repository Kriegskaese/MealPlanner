package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import database.DeleteQuery;
import database.ReadQuery;

public class Profile extends Observable {

	private String name;

	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	private List<IngredientTag> ingredientTags = new ArrayList<IngredientTag>();
	private List<IngredientCategory> ingredientCategories = new ArrayList<IngredientCategory>();
	private List<Recipe> recipies = new ArrayList<Recipe>();
	private List<RecipeTag> recipeTags = new ArrayList<RecipeTag>();
	private List<RecipeCategory> recipeCategories = new ArrayList<RecipeCategory>();
	private List<MealPlan> mealPlans = new ArrayList<MealPlan>();

	public Profile(String name) {
		this.name = name;
		initializeIngredients();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		setChanged();
		notifyObservers();
	}

	public void removeIngredient(Ingredient ingredient) {
		int ingredientId = ingredient.getId();
		ingredients.remove(ingredient);
		new DeleteQuery("ingredients", ingredientId);
		setChanged();
		notifyObservers();
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	private void initializeIngredients() {
		ResultSet resultSet = new ReadQuery("ingredients").getResultSet();

		try {
			while (resultSet.next()) {
				// create a new ingredient for each id
				int id = resultSet.getInt(1);
				Ingredient ingredient = new Ingredient(id);

				// add properties to each ingredient
				int nColumns = resultSet.getMetaData().getColumnCount();

				for (int i = 2; i <= nColumns; i++) {
					String propertyName = resultSet.getMetaData().getColumnName(i);
					Object propertyValue = resultSet.getObject(i);

					new FoodProperty(propertyName, propertyValue);
				}

				// add ingredient to this profile
				ingredients.add(ingredient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
