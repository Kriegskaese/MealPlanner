package model;

import java.util.List;

public class Meal extends MealPlanEntry {
	
	private List<MealEntry> entries;
	
	public void addEntry(MealEntry entry) {
		entries.add(entry);
	}
	
	public void removeEntry(MealEntry entry) {
		entries.remove(entry);
	}
	
}
