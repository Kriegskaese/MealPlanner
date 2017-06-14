package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import database.AddQuery;
import database.DeleteQuery;

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
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		new AddQuery("ingredients", ingredients.size());
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
}
