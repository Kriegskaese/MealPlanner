package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class Food extends Observable {

	protected List<FoodProperty> properties = new ArrayList<FoodProperty>();

	public int getId() {
		return (int) properties.get(0).getValue();
	}

	public void addProperty(FoodProperty property) {
		properties.add(property);
		setChanged();
		notifyObservers();
	}

	public void removeProperty(FoodProperty property) {
		properties.remove(property);
		setChanged();
		notifyObservers();
	}

}
