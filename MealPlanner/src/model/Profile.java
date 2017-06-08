package model;

import java.util.List;
import java.util.Observable;

public class Profile extends Observable {
	
	private String name;
	
	private List<Ingredient> ingredients;
	private List<IngredientTag> ingredientTags;
	private List<IngredientCategory> ingredientCategories;
	private List<Recipe> recipies;
	private List<RecipeTag> recipeTags;
	private List<RecipeCategory> recipeCategories;
	private List<MealPlan> mealPlans;
	
	public Profile(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
}
