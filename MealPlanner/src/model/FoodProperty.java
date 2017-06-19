package model;

import java.util.Observable;

import database.ModifyQuery;

public class FoodProperty extends Observable {

	private String name;
	private Object value;
	private boolean useManualValue = true;
	private Food food;

	public FoodProperty(String name, Object value, Food food) {
		this.name = name;
		this.value = value;
		this.food = food;
	}

	public FoodProperty(String name, Object value, Food food, boolean useManualValue) {
		this.name = name;
		this.value = value;
		this.food = food;
		this.useManualValue = useManualValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
		new ModifyQuery("ingredients", name, this.value.toString(), food.getId());
		setChanged();
		notifyObservers();
	}

	public boolean usesManualValue() {
		return useManualValue;
	}

	public void setUseManualValue(boolean useManualValue) {
		this.useManualValue = useManualValue;
		setChanged();
		notifyObservers();
	}

}
