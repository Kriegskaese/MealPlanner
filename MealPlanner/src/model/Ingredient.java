package model;

import java.util.List;

public class Ingredient extends Food {

	private List<IngredientTag> tags;
	
	public void addTag(IngredientTag tag) {
		tags.add(tag);
	}

	public void removeTag(IngredientTag tag) {
		tags.remove(tag);
	}

}
