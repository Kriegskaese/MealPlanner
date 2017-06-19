package model;

import java.util.List;

public class Recipe extends Food {

	private List<RecipeTag> tags;
	private List<RecipeEntry> entries;

	public Recipe(int id) {
		properties.add(new FoodProperty("id", new Integer(id), this));
	}

	public List<RecipeTag> getTags() {
		return tags;
	}

	public void addTag(RecipeTag tag) {
		tags.add(tag);
		setChanged();
		notifyObservers();
	}

	public void removeTag(RecipeTag tag) {
		tags.remove(tag);
		setChanged();
		notifyObservers();
	}

	public void addEntry(RecipeEntry entry) {
		entries.add(entry);
		setChanged();
		notifyObservers();
	}

	public void removeEntry(RecipeEntry entry) {
		entries.remove(entry);
		setChanged();
		notifyObservers();
	}

}
