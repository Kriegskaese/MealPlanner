package model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Recipe extends Food {

	private Set <RecipeTag> tags = new TreeSet<>();;
	private List<RecipeEntry> entries;

	//***************************** Constructor(s) *****************************

	public Recipe(int id) {
		this.id = id;
		nextId = determineHighestAllocatedId() + 1;
	}

	public Recipe() {
		this.id = nextId;
		nextId++;
	}

	//************************** External Method(s) ****************************

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

	public boolean hasTag(RecipeTag tag) {
		return tags.contains(tag);
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

	//************************ Getter(s) and Setter(s) *************************

	public Set<RecipeTag> getTags() {
		return tags;
	}

}
