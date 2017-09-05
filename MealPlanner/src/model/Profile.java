package model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Observable;
import java.util.Set;

public class Profile extends Observable {

	private int id;
	protected static int nextId = 0;
	private String name;
	private Set<Ingredient> ingredients = new HashSet<>();
	private Set<Recipe> recipies = new HashSet<>();
	private Set<Meal> meals = new HashSet<>();
	private Set<MealPlan> mealPlans = new HashSet<>();
	protected static Set<Profile> instances = new LinkedHashSet<>();

	//***************************** Constructor(s) *****************************

	public Profile(int id) {
		this.id = id;
		nextId = determineHighestAllocatedId() + 1;
	}

	public Profile() {
		this.id = nextId;
		nextId++;
	}

	//************************** External Method(s) ****************************

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		setChanged();
		notifyObservers();
	}

	public void removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
		setChanged();
		notifyObservers();
	}

	//*********************** Internal Helper Method(s) ************************

	private int determineHighestAllocatedId() {
		int highestId = 0;

		for (Profile instance : instances) {
			if (instance.getId() > highestId) {
				highestId = instance.getId();
			}
		}

		return highestId;
	}

	//************************ Getter(s) and Setter(s) *************************

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

}
