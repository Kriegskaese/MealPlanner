package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public abstract class Food extends Observable {

	protected int id;
	protected static int nextId = 0;
	protected String name;
	protected Map<String, Float> nutrients = new HashMap<>();

	protected static List<String> nutrientNames = new ArrayList<>();
	protected static Set<Food> instances = new LinkedHashSet<>();

	//************************** External Method(s) ****************************

	public void addNutrientName(String nutrientName) {
		//TODO: check for uniqueness
		nutrientNames.add(nutrientName);
		addNutrientNameToAllFoods(nutrientName);
		setChanged();
		notifyObservers();
	}

	public void removeNutrientName(String nutrientName) {
		nutrientNames.remove(nutrientName);
		removeNutrientNameFromAllFoods(nutrientName);
		setChanged();
		notifyObservers();
	}

	//*********************** Internal Helper Method(s) ************************

	private void addNutrientNameToAllFoods(String nutrientName) {
		for (Food food : instances) {
			food.nutrients.put(nutrientName, null);
		}
	}

	private void removeNutrientNameFromAllFoods(String nutrientName) {
		for (Food food : instances) {
			food.nutrients.remove(nutrientName);
		}
	}

	protected int determineHighestAllocatedId() {
		int highestId = 0;

		for (Food instance : instances) {
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

	public int getNextId() {
		return nextId;
	}

	public String getName() {
		return name;
	}

	public float getNutrientValue(String nutrientName) {
		return nutrients.get(nutrientName);
	}

	public void setNutrientValue(String nutrientName, float nutrientValue) {
		nutrients.put(nutrientName, nutrientValue);
		setChanged();
		notifyObservers();
	}

	public static List<String> getNutrientNames() {
		return nutrientNames;
	}

}
