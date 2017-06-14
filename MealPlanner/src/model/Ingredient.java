package model;

import java.util.List;

import database.AddQuery;

public class Ingredient extends Food {

	private static int currentId = 0;
	private List<IngredientTag> tags;

	public Ingredient() {
		properties.add(new FoodProperty("id", new Integer(currentId)));
		new AddQuery("ingredients", currentId);
		currentId++;
	}

	public List<IngredientTag> getTags() {
		return tags;
	}

	public void addTag(IngredientTag tag) {
		tags.add(tag);
		setChanged();
		notifyObservers();
	}

	public void removeTag(IngredientTag tag) {
		tags.remove(tag);
		setChanged();
		notifyObservers();
	}

}
