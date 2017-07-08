package model;

import java.util.Set;
import java.util.TreeSet;

public class Ingredient extends Food {

	private Set<IngredientTag> tags = new TreeSet<>();

	//***************************** Constructor(s) *****************************

	public Ingredient(int id) {
		this.id = id;
		nextId++;
	}

	//************************** External Method(s) ****************************

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

	public boolean hasTag(IngredientTag tag) {
		return tags.contains(tag);
	}

	//************************ Getter(s) and Setter(s) *************************

	public Set<IngredientTag> getTags() {
		return tags;
	}

}
