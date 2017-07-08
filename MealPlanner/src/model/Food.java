package model;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public abstract class Food extends Observable {

	protected int id;
	protected static int nextId;
	protected String name;
	protected Map<String, Double> properties = new HashMap<>();
	protected static Set<String> propertyNames = new LinkedHashSet<>();
	protected static Set<Food> instances = new LinkedHashSet<>();

	//************************** External Method(s) ****************************

	public void addProperty(String propertyName, double value) {
		setProperty(propertyName, value);
	}

	public void removeProperty(String propertyName) {
		removePropertyName(propertyName);
	}

	public void addPropertyName(String newName) {
		propertyNames.add(newName);
	}

	public void removePropertyName(String name) {
		removePropertyFromAllInstances(name);
		propertyNames.remove(name);
		setChanged();
		notifyObservers();
	}

	//*********************** Internal Helper Method(s) ************************

	private void removePropertyFromAllInstances(String name) {
		for (Food food : instances) {
			food.properties.remove(name);
		}
	}

	//************************ Getter(s) and Setter(s) *************************

	public int getId() {
		return id;
	}

	public int getNextId() {
		return nextId;
	}

	public void setNextId(int id) {
		nextId = id;
	}

	public String getName() {
		return name;
	}

	public double getPropertyValue(String propertyName) {
		return properties.get(propertyName);
	}

	public void setProperty(String propertyName, double value) {
		properties.put(propertyName, value);
		setChanged();
		notifyObservers();
	}

	public Set<String> getpropertyNames() {
		return propertyNames;
	}

}
