package model;

import java.util.List;

public class Ingredient extends Food {

	private List<IngredientTag> tags;

	public Ingredient() {
	}

	public void addTag(IngredientTag tag) {
		tags.add(tag);
	}

	public void removeTag(IngredientTag tag) {
		tags.remove(tag);
	}

	public List<IngredientTag> getTags() {
		return tags;
	}

}
