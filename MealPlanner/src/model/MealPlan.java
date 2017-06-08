package model;

import java.util.List;

public class MealPlan {
	
	private String name;	
	private List<Meal> meals;
	private List<ShoppingList> shoppingLists;
	
	public void addMeal(Meal meal) {
		meals.add(meal);
	}
	
	public void removeMeal(Meal meal) {
		meals.remove(meal);
	}
	
	public void addShoppingList(ShoppingList shoppingList) {
		shoppingLists.add(shoppingList);
	}
	
	public void removeShoppingList(ShoppingList shoppingList) {
		shoppingLists.remove(shoppingList);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
